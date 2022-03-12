package exampleForBestPractices.repository;

import exampleForBestPractices.utils.DatabaseQueries;
import exampleForBestPractices.utils.DatabaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Service responsible for interacting with database table Projects.
 * Provides CRUD (create, read, update, delete) method implementation, like:
 * findAll, findById, update, etc...
 */
public class ProjectRepository {

    //galetu grazinti List<Projects> jeigu resultSet pries tai sumapintume
    public ResultSet findAll() {
        ResultSet projectResultSet = null;
        try {
            Statement statement = DatabaseUtils.databaseConnection.createStatement();
            projectResultSet = statement.executeQuery(DatabaseQueries.FIND_ALL_PROJECTS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectResultSet;
    }

    /**
     * Finds projects which budget's are more than given margin
     * @param budget given margin
     * @return all projets wich are more expensive than given budget
     */
    public ResultSet findProjectsByBudget(int budget) {
        ResultSet projectResultSet = null;

        try {
            Statement statement = DatabaseUtils.databaseConnection.createStatement();
            String sql = String.format(DatabaseQueries.Find_PROJECTS_BY_BUDGET, budget);
            projectResultSet = statement.executeQuery(sql);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return projectResultSet;
    }
}
