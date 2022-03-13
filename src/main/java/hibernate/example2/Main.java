package hibernate.example2;

public class Main {

    public static void main(String[] args) {
        CarRepository carRepository = new CarRepository();
        carRepository.save(new Car(null, "Ford", "blue"));
        carRepository.save(new Car(null, "Audi", "black"));

        Car carById = carRepository.findById(2L);
        System.out.println("Found by id: " + carById);

//        carRepository.delete(carById);

        carRepository.update(carById, "Green");

    }
}
