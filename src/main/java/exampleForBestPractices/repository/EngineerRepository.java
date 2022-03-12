package exampleForBestPractices.repository;

import exampleForBestPractices.utils.DatabaseQueries;
import exampleForBestPractices.utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Service responsible for interacting with database table Engineers.
 * Provides CRUD (create, read, update, delete) method implementation, like:
 * findAll, findById, update, etc...
 */
public class EngineerRepository {

    public ResultSet findAllEngineersWhoWorkOnProjects() {

        ResultSet engineerResulSet = null;
        try {
            Statement statement = DatabaseUtils.databaseConnection.createStatement();
            engineerResulSet = statement.executeQuery(DatabaseQueries.FIND_ALL_ENGINEERS_WHO_WORKING_ON_PROJECTS);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return engineerResulSet;
    }

}
