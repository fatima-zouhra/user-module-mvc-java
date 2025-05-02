# **User Module MVC - Java**

## **Project Overview**

This project implements a **User Module** using the **Model-View-Controller (MVC)** architecture in Java. The module provides user management features such as **user registration**, **login**, **profile editing**, and **logout**, while connecting to a **MySQL** database for persistent storage.

### **Project Structure**

- **controller**: Contains servlet classes responsible for handling user requests:
  - `Register.java`: Handles user registration.
  - `Login.java`: Manages user authentication.
  - `Home.java`: Redirects to the homepage.
  - `Profile.java`: Displays and updates the user profile.
  - `DeleteUser.java`: Deletes user data.

- **model**: Contains data-related logic and models:
  - `User.java`: JavaBean class representing the user entity.
  - `UserDatabase.java`: Handles database operations such as user creation and lookup.

- **util**: Provides utility classes:
  - `DataUtil.java`: Contains logic to establish a connection to the MySQL database.

### **View Layer (JSP Files)**

- `register.jsp`: Registration form interface.
- `login.jsp`: Login form interface.
- `home.jsp`: Main homepage after login.
- `dashboard.jsp`: User dashboard view.
- `profile.jsp`: Displays and edits user profile.
- `logout.jsp`: Handles user logout.
- `checkLogin.jsp`: Utility page for login validation.
- `error.jsp`: Displays error messages.

---

## **Database Design**

The project uses a **MySQL** database to store user data. The following table is used:

**User Table**:

| Column         | Data Type | Description              |
|----------------|-----------|--------------------------|
| id             | INT       | Primary key, auto-increment |
| name           | VARCHAR   | User's full name         |
| email          | VARCHAR   | User's email (unique)    |
| password       | VARCHAR   | User's encrypted password|
| profile_picture| VARCHAR   | Path to the user's profile picture |

### **Features Implemented**

- **User Registration**: 
  - Validates password match and unique email.

- **User Login**: 
  - Validates credentials and starts a user session.

- **Edit Profile**: 
  - Allows users to update personal information like name and profile picture.

- **Logout**: 
  - Clears the user session using `session.invalidate()`.

- **Account Deletion**: 
  - Allows users to delete their accounts and remove all data from the database.

---

## **Installation**

### **1. Set Up MySQL Database**

Create a **MySQL database** and configure your credentials in the `DataUtil.java` class for connecting to the database.

- Create the user table using the SQL script provided in the [Database Design](#database-design) section.

### **2. Set Up the Project in Your IDE**

If you are using an IDE like **Eclipse**, **IntelliJ IDEA**, or **NetBeans**:

1. Import the project as a **Dynamic Web Project**.
2. Make sure you have the **Servlet API** (or **Tomcat** servlet container) set up.
3. Configure the project to use **JSP** and **Servlets**.

### **3. Deploy on Apache Tomcat**

1. Deploy the application on **Apache Tomcat** or another servlet container.
2. Copy the project to the `webapps` folder of your Tomcat server.
3. Start the Tomcat server.
4. Access the application at `http://localhost:8080`.

---
Building software is a journey—I'm glad you stopped by to check out this User Module. 
Whether you’re learning, adapting, or building on it, remember: every line of code is a step toward something amazing. 🌟
If you have thoughts, ideas, or questions, don’t hesitate to reach out. Let’s create something extraordinary together! 🌱


[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


