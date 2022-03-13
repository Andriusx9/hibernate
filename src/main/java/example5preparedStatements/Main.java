package example5preparedStatements;

import exampleForBestPractices.utils.DatabaseUtils;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {

    private static final String INSERT_ENGINEER = "INSERT INTO ENGINEERS (firstName, lastName, experience, projectId) VALUES(?,?,?,?)";
    private static final String UPDATE_ENGINEER = "UPDATE ENGINEERS SET projectId = ? WHERE engineerId = ?";
    public static void main(String[] args) throws SQLException {

        PreparedStatement preparedStatement = DatabaseUtils.databaseConnection.prepareStatement(INSERT_ENGINEER);
        preparedStatement.setString(1, "Bryan");
        preparedStatement.setString(2, "Adams");
        preparedStatement.setInt(3, 30);
        preparedStatement.setInt(4, 1);

//        preparedStatement.executeUpdate();

        PreparedStatement PreStmt = DatabaseUtils.databaseConnection.prepareStatement(UPDATE_ENGINEER);
        PreStmt.setInt(1, 3);
        PreStmt.setInt(2, 1);

        PreStmt.executeUpdate();

    }
}
