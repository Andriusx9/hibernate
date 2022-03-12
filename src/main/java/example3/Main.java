package example3;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun2?serverTimezone=UTC";

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN departments ON users.department_id = departments.department_id;");

            while (resultSet.next()){
               int userID =  resultSet.getInt("users.user_id");
               String fullName = resultSet.getString("users.full_name");
               int departmentId = resultSet.getInt("departments.department_id");
               String departmentName = resultSet.getString("departments.name");

               Department department = new Department();
               department.setDepartmentId(departmentId);
               department.setName(departmentName);

               User user = new User();
               user.setUserId(userID);
               user.setFullName(fullName);
               user.setDepartment(department);

               users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
