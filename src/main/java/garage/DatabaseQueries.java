package garage;

public class DatabaseQueries {

    public static final String SELECT_ALL_CARS_AND_OWNERS = "SELECT * FROM cars, owners WHERE cars.owner_id = owners.owner_id;";
    public static final String SELECT_ALL_CARS = "SELECT * FROM cars;";
    public static final String SELECT_ALL_OWNERS = "SELECT * FROM owners;";
    public static final String UPDATE_OWNERS = "UPDATE owners SET first_name = ?, last_name = ?, age = ?, email = ? WHERE owner_id = ?";
    public static final String DELETE_FROM_OWNERS = "DELETE FROM owners WHERE owner_id = ?";
}
