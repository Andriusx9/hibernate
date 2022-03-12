package garage;

import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {

        //method getAllCar()
        List<Car> cars = DatabaseService.getAllCar();
        System.out.println("List of cars:");
        cars.forEach(System.out::println);

        //method getAllOwners()
        List<Owner> owners = DatabaseService.getAllOwners();
        System.out.println("List of owners:");
        owners.forEach(System.out::println);

        //method getAllCarsAndOwners()
        List<Car> allCarsAndOwners = DatabaseService.getAllCarsAndOwners();
        System.out.println("All cars and Owners list: ");
        for (Car x : allCarsAndOwners) {
            System.out.println("Car id: "+x.getCarId()+"; car brand: "+x.getBrand()+"; car year: "+x.getCarYear()+"; Owner: "+x.getOwner().getFirstName()+" "+
                    x.getOwner().getLastName()+"; email: "+x.getOwner().getEmail());
        }

        //method updateCar()
        DatabaseService.updateCar(40, "Ford", 2015, 3);

        //method updateOwner()
        DatabaseService.updateOwner("Stephen", "Curry", 33, "stephen@gmail.com", 9 );

        //method deleteOwner()
        DatabaseService.deleteOwner(11);


    }
}
