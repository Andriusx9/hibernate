package hibernate.example3;

import org.hibernate.Session;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Account benAccount = Account.builder()
                .accountNumber("123456")
                .employmentDate(LocalDate.of(2022, 3, 8))
                .build();

        Employee ben = Employee.builder()
                .email("ben@gmail.com")
                .firstName("Ben")
                .lastName("Benavicius")
                .account(benAccount)
                .build();

        session.beginTransaction();
        session.save(ben);
        session.getTransaction().commit();

    }
}
