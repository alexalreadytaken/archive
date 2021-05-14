package example.archive.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Fund {

    @Id
    @GeneratedValue
    private Long id;

    private String number;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private FundName fundName;

    @OneToMany(mappedBy = "fund",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Inventory> inventories;
}
