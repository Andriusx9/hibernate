package garage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/garage?serverTimezone=UTC";

    public static List<Car> getAllCar() throws SQLException {

        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(DatabaseQueries.SELECT_ALL_CARS);

        List<Car> cars = new ArrayList<>();

        while(resultSet.next()) {
            int carId = resultSet.getInt("car_id");
            String brand = resultSet.getString("brand");
            int year = resultSet.getInt("year");

            cars.add(new Car(carId, brand, year));

        }

        resultSet.close();
        statement.close();
        connection.close();

        return cars;
    }

    public static List<Owner> getAllOwners() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(DatabaseQueries.SELECT_ALL_OWNERS);

        List<Owner> owners = new ArrayList<>();

        while(resultSet.next()) {
            int ownerId = resultSet.getInt("owner_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int age = resultSet.getInt("age");
            String email = resultSet.getString("email");

            owners.add(new Owner(ownerId, firstName, lastName, age, email));
        }

        resultSet.close();
        statement.close();
        connection.close();

        return owners;
    }

    public static ArrayList<Object> getAllCarsAndOwners() throws SQLException {

        List<Car> cars = getAllCar();
        List<Owner> owners = getAllOwners();

        ArrayList<Object> carsAndOwners = new ArrayList<>();

        carsAndOwners.add(cars);
        carsAndOwners.add(owners);

        return carsAndOwners;
    }

    public static void updateCar(int updatedCarId, String newCarBrand, int newCarYear, int newOwnerId) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        Statement statement = connection.createStatement();

        statement.executeUpdate("UPDATE cars SET brand = '" + newCarBrand + "', year = " +
                newCarYear + ", owner_id = " + newOwnerId + " WHERE car_id = " + updatedCarId + ";");

        statement.close();
        connection.close();
    }

    public static void updateOwner(String firstName, String lastName, int age, String email, int updatedOwnerId) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(DatabaseQueries.UPDATE_OWNERS);

        preparedStatement.setString(1, firstName);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, age);
        preparedStatement.setString(4, email);
        preparedStatement.setInt(5, updatedOwnerId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    public static void deleteOwner(int deletedOwnerId) throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(DatabaseQueries.DELETE_FROM_OWNERS);

        preparedStatement.setInt(1, deletedOwnerId);

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

}
