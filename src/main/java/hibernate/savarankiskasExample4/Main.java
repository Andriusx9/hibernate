package hibernate.savarankiskasExample4;

import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Passport passport = Passport.builder()
                .passportNumber("A5464a")
                .passportId(null)
                .nationality("American")
                .build();

        Traveler traveler = Traveler.builder()
                .travelerId(null)
                .email("ben@gmail.com")
                .firstName("Ben")
                .lastName("Benoravicius")
                .passport(passport)
                .build();

        session.beginTransaction();
        session.save(traveler);
        session.getTransaction().commit();
    }
}
