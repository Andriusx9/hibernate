package hibernate.example1;

import javax.transaction.Transaction;

public class main {

    public static void main(String[] args) {

        Pet fido = new Pet();
        fido.setName("Fido");
        fido.setAge(12);

        PetRepository petRepository = new PetRepository();
        petRepository.save(fido);
        petRepository.save(new Pet(null, "Rainius", 8));

        Pet foundPetById = petRepository.findById(2L);
        System.out.println("Pet is found: " +foundPetById);

        petRepository.delete(fido);
        petRepository.deleteById(2L);
    }
}
