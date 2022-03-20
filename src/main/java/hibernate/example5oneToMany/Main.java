package hibernate.example5oneToMany;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

//        Owner tomas = Owner.builder().name("Tomas").email("tomas@gmail.com").country("LT").build();
//        Book cookingBook = Book.builder().title("Cooking").price(15).owner(tomas).build();
//        Book songBook = Book.builder().title("Singing Tutorial").price(10).owner(tomas).build();
//
//        List<Book> tomoKnygos = new ArrayList<>();
//        tomoKnygos.add(cookingBook);
//        tomoKnygos.add(songBook);
//
//        tomas.setBooks(tomoKnygos);
//
//        session.beginTransaction();
//        session.save(tomas);
//        session.getTransaction().commit();

        Owner tomas = Owner.builder()
                .name("Tomas")
                .email("tomas@gmail.com")
                .country("LT")
                .build();

        Book cookingBook = Book.builder()
                .title("Cooking book")
                .price(15)
                .owner(tomas)
                .build();


        List<Book> books = new ArrayList<>();
        books.add(cookingBook);

        tomas.setBooks(books);

        session.beginTransaction();
        session.persist(tomas); // naudojant cascade PERSIST, naudoti persis ne save
        session.getTransaction().commit();

//        session.beginTransaction();
//        session.delete(tomas);
//        session.getTransaction().commit();

        Library mazvydoBiblioteka = Library.builder()
                .address("geguzes g. 15")
                .name("Mazvydo biblioteka")
                .owners(Set.of(tomas)) // pridedu sarasa su 1 owneriu
                .build();

        Library saulesBiblioteka = Library.builder()
                .address("saules g. 225")
                .name("Saules biblioteka")
                .owners(Set.of(tomas)) // pridedu sarasa su 1 owneriu
                .build();

        session.beginTransaction();
        session.persist(mazvydoBiblioteka); // naudojant cascade PERSIST, naudoti persis ne save
        session.persist(saulesBiblioteka);
        session.getTransaction().commit();

        session.beginTransaction();
        session.delete(mazvydoBiblioteka);
        session.getTransaction().commit();
    }
}
