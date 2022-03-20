package hibernate.example3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Employee {

    @Id // pirminis raktas
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increament sukurimas
    private Integer employId;

    private String email;
    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL) //saugant i DB eomployee bus automatiskai assaugotas account
    @JoinColumn(name = "accountId") // cia nurodom koks bus FK employee lenteleje, tam kadbutu sukurtas sarysis su Account
    private Account account;
}
