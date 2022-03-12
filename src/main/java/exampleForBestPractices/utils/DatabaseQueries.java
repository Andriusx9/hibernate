package exampleForBestPractices.utils;

public class DatabaseQueries {
    public static final String FIND_ALL_PROJECTS = "SELECT * FROM PROJECTS";
    public static final String Find_PROJECTS_BY_BUDGET = "SELECT * FROM PROJECTS WHERE budget >= %d";
}
