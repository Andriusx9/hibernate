package garage;

public class Car {
    private int carId;
    private String brand;
    private int carYear;


    public Car(int carId, String brand, int carYear) {
        this.carId = carId;
        this.brand = brand;
        this.carYear = carYear;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", carYear=" + carYear +
                '}';
    }
}
