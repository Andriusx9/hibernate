package hibernate.example1;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PetRepository {

    private static Session session = HibernateUtil.getSessionFactory().openSession();

    /**
     * Vienas is CRUD metodu
     * C - Create (save)
     * R - Read (select)
     * U - Update
     * D - Delete
     * @param pet
     */
    public void save(Pet pet) {
        Transaction transaction = session.beginTransaction();
        session.persist(pet); // tas pats kas INSERT INTO
        transaction.commit();
        System.out.println("Pet was created: " + pet);
    }

    /**
     * R - Read (select) - nuskaito duomenis
     * @param id given id
     * @return dound Pet by ID
     */
    public Pet findById(Long id) {
        return session.find(Pet.class, id); // veikia kaip SELECT * FROM pets WHERE petId = id
    }

    public void delete(Pet pet) {
        Transaction transaction = session.beginTransaction();
        session.delete(pet);
        transaction.commit();
        System.out.println("Pet was deleted: " + pet);
    }

    public void deleteById(Long id) {
        Transaction transaction = session.beginTransaction();
        session.delete(findById(id));
        transaction.commit();
    }

}
