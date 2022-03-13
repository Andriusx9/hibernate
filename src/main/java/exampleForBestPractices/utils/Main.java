package exampleForBestPractices.utils;

import exampleForBestPractices.repository.EngineerRepository;
import exampleForBestPractices.repository.ProjectRepository;
import exampleForBestPractices.service.ResultSetPrintingService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.out.println("Suranda visus projektus:");
        ProjectRepository projectRepository = new ProjectRepository();
        ResultSet projects = projectRepository.findAll();
        ResultSetPrintingService printingService = new ResultSetPrintingService();
        printingService.printAllProjects(projects);

        System.out.println();

        System.out.println("Suranda projektus kuriu biudzetas daugiau nei 25000:");
        ResultSet projectsByBudget = projectRepository.findProjectsByBudget(25000);
        printingService.printAllProjects(projectsByBudget);

        System.out.println();

        ResultSet projectByName = projectRepository.findByName("Pokemon");
        printingService.printAllProjects(projectByName);

        System.out.println();

        projectRepository.addProject("e-sveikata", 55555);
        ResultSet newlyAddedProject = projectRepository.findByName("e-sveikata");
        printingService.printAllProjects(newlyAddedProject);

//        System.out.println("Updatina projekta kur ID = 1:");
//        projectRepository.updateProject("B-Mobile", 50001, 1);
//        ResultSet projectById = projectRepository.findProjectById(1);
//        printingService.printAllProjects(projectById);
//
//        System.out.println();
//
//        System.out.println("Deletina projekta kur id: 4 ir atspausdina visus likusius projektus:");
//        projectRepository.deleteProjectById(4);
//        ResultSet allProjects = projectRepository.findAll();
//        printingService.printAllProjects(allProjects);
//
//        System.out.println();
//
//        System.out.println("Suranda visus engineers kurie dirba prie projektu:");
//        EngineerRepository engineerRepository = new EngineerRepository();
//        ResultSet allEngineersWhoWorkOnProjects = engineerRepository.findAllEngineersWhoWorkOnProjects();
//        printingService.printAllEngineersWhoWorkOnProjects(allEngineersWhoWorkOnProjects);


    }
}
