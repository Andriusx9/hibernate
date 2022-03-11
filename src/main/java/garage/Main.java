package garage;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        //method getAllCar()
        List<Car> cars = DatabaseService.getAllCar();
        cars.forEach(System.out::println);

        //method getAllOwners()
        List<Owner> owners = DatabaseService.getAllOwners();
        owners.forEach(System.out::println);

        //method getAllCarsAndOwners() NEGALIU PASIEKTI OBJEKTO car metodu
        ArrayList<Object> allCarsAndOwners = DatabaseService.getAllCarsAndOwners();
        // allCarsAndOwners.get(0).       // <-- zinau kad su index 0, yra Listas su car objektais

        //method updateCar()
        DatabaseService.updateCar(40, "Ford", 2015, 3);

        //method updateOwner()
        DatabaseService.updateOwner("Stephen", "Curry", 33, "stephen@gmail.com", 9 );

        //method deleteOwner()
        DatabaseService.deleteOwner(11);


    }
}
