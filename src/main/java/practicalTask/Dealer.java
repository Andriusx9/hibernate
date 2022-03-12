package practicalTask;

public class Dealer {
    private int dealerId;
    private String fullName;
    private int age;
    private Product product;

    public Dealer(int dealerId, String fullName, int age, Product product) {
        this.dealerId = dealerId;
        this.fullName = fullName;
        this.age = age;
        this.product = product;
    }

    public Dealer() {
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "dealerId=" + dealerId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", product=" + product +
                '}';
    }
}
