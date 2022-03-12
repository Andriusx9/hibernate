package practicalTask;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "root";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/jdbcfun2?serverTimezone=UTC";

    public static void main(String[] args) {


        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dealer, product WHERE dealer.dealer_id = product.dealer_id;");

            List<Dealer> dealers = new ArrayList<>();

            while (resultSet.next()) {
                int dealerId = resultSet.getInt("dealer_id");
                String fullName = resultSet.getString("full_name");
                int age = resultSet.getInt("age");
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("name");
                int weight = resultSet.getInt("weight");
                String brand = resultSet.getString("brand");

                Product product = new Product();
                product.setProductId(productId);
                product.setName(productName);
                product.setWeight(weight);
                product.setBrand(brand);

                Dealer dealer = new Dealer();
                dealer.setDealerId(dealerId);
                dealer.setFullName(fullName);
                dealer.setAge(age);
                dealer.setProduct(product);

                dealers.add(dealer);
            }

            resultSet.close();
            statement.close();
            connection.close();

            for (Dealer dealer : dealers) {
                System.out.println(dealer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
