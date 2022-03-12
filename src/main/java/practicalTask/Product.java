package practicalTask;

public class Product {
    private int productId;
    private String name;
    private int weight;
    private String brand;

    public Product(int productId, String name, int weight, String brand) {
        this.productId = productId;
        this.name = name;
        this.weight = weight;
        this.brand = brand;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", brand='" + brand + '\'' +
                '}';
    }
}
