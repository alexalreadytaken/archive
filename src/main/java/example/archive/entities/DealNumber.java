package example.archive.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class DealNumber {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    private Deal aDeal;
}
