package model;

import util.DataUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabase {
	public void addUser(User user) throws SQLException {
	    String sql = "INSERT INTO users (email, password, country, first_name, last_name, " +
	                 "job_title, work_phone, company_name, address, city, zip) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DataUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, user.getEmail());
	        stmt.setString(2, user.getPassword());
	        stmt.setString(3, user.getCountry());
	        stmt.setString(4, user.getFirstName());
	        stmt.setString(5, user.getLastName());
	        stmt.setString(6, user.getJobTitle());
	        stmt.setString(7, user.getWorkPhone());
	        stmt.setString(8, user.getCompanyName());
	        stmt.setString(9, user.getAddress());
	        stmt.setString(10, user.getCity());
	        stmt.setString(11, user.getZip());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new SQLException("Error adding user", e);
	    }
	}

	public User getUser(String email) throws SQLException {
	    String sql = "SELECT * FROM users WHERE email = ?";
	    User user = null;

	    try (Connection conn = DataUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, email);
	        
	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                user = new User();
	                user.setEmail(rs.getString("email"));
	                user.setPassword(rs.getString("password"));
	                user.setCountry(rs.getString("country"));
	                user.setFirstName(rs.getString("first_name"));
	                user.setLastName(rs.getString("last_name"));
	                user.setJobTitle(rs.getString("job_title"));
	                user.setWorkPhone(rs.getString("work_phone"));
	                user.setCompanyName(rs.getString("company_name"));
	                user.setAddress(rs.getString("address"));
	                user.setCity(rs.getString("city"));
	                user.setZip(rs.getString("zip"));
	            }
	        }
	    } catch (SQLException e) {
	        throw new SQLException("Error getting user", e);
	    }

	    return user;
	}

	public void updateUser(User user) throws SQLException {
	    String sql = "UPDATE users SET country=?, first_name=?, last_name=?, job_title=?, " +
	                 "work_phone=?, company_name=?, address=?, city=?, zip=? WHERE email=?";

	    try (Connection conn = DataUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, user.getCountry());
	        stmt.setString(2, user.getFirstName());
	        stmt.setString(3, user.getLastName());
	        stmt.setString(4, user.getJobTitle());
	        stmt.setString(5, user.getWorkPhone());
	        stmt.setString(6, user.getCompanyName());
	        stmt.setString(7, user.getAddress());
	        stmt.setString(8, user.getCity());
	        stmt.setString(9, user.getZip());
	        stmt.setString(10, user.getEmail());

	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        throw new SQLException("Error updating user", e);
	    }
	}

	public boolean containsEmail(String email) throws SQLException {
	    String sql = "SELECT email FROM users WHERE email = ?";
	    try (Connection conn = DataUtil.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setString(1, email);
	        try (ResultSet rs = stmt.executeQuery()) {
	            return rs.next();  // Returns true if email is found
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();  // This will print the detailed error message
	        throw new SQLException("Error checking email existence", e);
	    }
	}
	public boolean deleteUserByEmail(String email) {
	    String sql = "DELETE FROM users WHERE email = ?";
	    try (Connection conn = DataUtil.getConnection(); 
	    	 PreparedStatement stmt = conn.prepareStatement(sql)) {
	        stmt.setString(1, email);
	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}