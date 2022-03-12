package garage;

public class Car {
    private int carId;
    private String brand;
    private int carYear;
    private Owner owner;

    public Car(int carId, String brand, int carYear, Owner owner) {
        this.carId = carId;
        this.brand = brand;
        this.carYear = carYear;
        this.owner = owner;
    }

    public Car() {
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", carYear=" + carYear +
                ", owner=" + owner +
                '}';
    }
}
