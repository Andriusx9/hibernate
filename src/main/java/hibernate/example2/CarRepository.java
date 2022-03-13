package hibernate.example2;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarRepository {
    private static Session session = HibernateUtil.getSessionFactory().openSession();

    public void save(Car car) {
        Transaction transaction = session.beginTransaction();
        session.persist(car); // tas pats kas INSERT INTO
        transaction.commit();
        System.out.println("Car was created: " + car);
    }

    public Car findById(Long id) {
        return session.find(Car.class, id);
    }

    public void delete(Car car) {
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        System.out.println("Car was deleted: " + car);
    }

    public void update(Car car, String newColor) {
        Transaction transaction = session.beginTransaction();
        car.setColor(newColor);
        transaction.commit();
        System.out.println("Car color changed to: " + car.getColor());
    }

}
