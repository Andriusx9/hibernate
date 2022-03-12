package exampleForBestPractices.service;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetPrintingService {

    public void printAllProjects(ResultSet projectResultSet) throws SQLException {
        while(projectResultSet.next()){
            int projectId = projectResultSet.getInt("projectId");
            String projectName = projectResultSet.getString("projectName");
            int budget = projectResultSet.getInt("budget");
            System.out.println("Project ID:" + projectId + "; Name: " + projectName + "; Budget is:" + budget);
        }
    }

    public void printAllEngineersWhoWorkOnProjects(ResultSet engineerResultSet) throws SQLException {
        while(engineerResultSet.next()) {
            int engineerId = engineerResultSet.getInt("engineerId");
            String firstName = engineerResultSet.getString("firstName");
            String lastName = engineerResultSet.getString("lastName");
            int experience = engineerResultSet.getInt("experience");

            int projectId = engineerResultSet.getInt("projects.projectId");
            String projectName = engineerResultSet.getString("projectName");
            int budget = engineerResultSet.getInt("budget");

            System.out.println("Engineer ID: "+ engineerId +"; Full name: "+firstName+" "+lastName+
                    "; Has experience: "+experience+"; Project ID: "+projectId+"; Working on: "+projectName+
                    "; Budget is: "+ budget);
        }
    }

}
