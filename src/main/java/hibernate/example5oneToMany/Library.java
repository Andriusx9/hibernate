package hibernate.example5oneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer libraryId;

    private String name;
    private String address;

    @ManyToMany(cascade = CascadeType.PERSIST) // issitrins tik su rysiais
    @JoinTable(name = "owners_to_libraries") // sukurs tarpine lentele
    private Set<Owner> owners; // vienoje bibliotekoje gali lankytis daug lankytoju(owneriu)


}
