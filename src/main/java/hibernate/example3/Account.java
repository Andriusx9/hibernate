package hibernate.example3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;

    private String accountNumber;
    private LocalDate employmentDate;

    //turi rodyti i Employee klases account FIELDA
    @OneToOne(mappedBy = "account")
    private Employee employee;
}
