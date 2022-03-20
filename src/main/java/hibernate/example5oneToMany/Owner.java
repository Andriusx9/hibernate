package hibernate.example5oneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ownerId;
    private String name;
    private String email;
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner") // One to Many
    private List<Book> books;

    @ManyToMany(mappedBy = "owners")// mapina su Library fieldu owners
    private Set<Library> libraries;
}
