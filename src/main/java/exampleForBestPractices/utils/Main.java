package exampleForBestPractices.utils;

import exampleForBestPractices.repository.ProjectRepository;
import exampleForBestPractices.service.ResultSetPrintingService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        ProjectRepository projectRepository = new ProjectRepository();
        ResultSet projects = projectRepository.findAll();
        ResultSetPrintingService printingService = new ResultSetPrintingService();
        printingService.printAllProjects(projects);

        System.out.println();

        ResultSet projectsByBudget = projectRepository.findProjectsByBudget(25000);
        printingService.printAllProjects(projectsByBudget);
    }
}
