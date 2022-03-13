package exampleForBestPractices.repository;

import exampleForBestPractices.utils.DatabaseQueries;
import exampleForBestPractices.utils.DatabaseUtils;

import java.sql.PreparedStatement;
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
            String sql = String.format(DatabaseQueries.FIND_PROJECTS_BY_BUDGET, budget);
            projectResultSet = statement.executeQuery(sql);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return projectResultSet;
    }

    public void updateProject(String newProjectName, int newProjectBudget, int updatedProjectId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtils.databaseConnection.prepareStatement(DatabaseQueries.UPDATE_PROJECT_BY_ID);
            preparedStatement.setString(1, newProjectName);
            preparedStatement.setInt(2, newProjectBudget);
            preparedStatement.setInt(3, updatedProjectId);

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteProjectById(int deletedProjectId) {
        try {
            PreparedStatement preparedStatement = DatabaseUtils.databaseConnection.prepareStatement(DatabaseQueries.DELETE_PROJECT_BY_ID);
            preparedStatement.setInt(1, deletedProjectId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet findProjectById(int projectId) {
        ResultSet projectResultSet = null;

        try {
            PreparedStatement preparedStatement = DatabaseUtils.databaseConnection.prepareStatement(DatabaseQueries.FIND_PROJECT_BY_ID);
            preparedStatement.setInt(1, projectId);
            projectResultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectResultSet;
    }

        public ResultSet findByName(String projectName) {
            ResultSet projectResultSet = null;

            try {
                Statement statement = DatabaseUtils.databaseConnection.createStatement();
                String sql = String.format(DatabaseQueries.FIND_PROJECT_BY_NAME, projectName);
                projectResultSet = statement.executeQuery(sql);

            } catch (SQLException exception) {
                exception.printStackTrace();
            }
            return projectResultSet;
        }

        public void addProject(String projectName, int budget) {

            int affectedRows = 0;
            try {
                Statement statement = DatabaseUtils.databaseConnection.createStatement();
                String sql = String.format(DatabaseQueries.ADD_PROJECT, projectName, budget);
                affectedRows = statement.executeUpdate(sql);

            } catch (SQLException e) {
                e.printStackTrace();
            }

            if (affectedRows == 1) {
                System.out.println("Project Added");
            }
        }

}
