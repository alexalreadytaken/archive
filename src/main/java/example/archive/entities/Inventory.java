package example.archive.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Inventory {
    @Id
    @GeneratedValue
    private Long id;

    private String number;

    private String introduction;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Fund fund;

    @OneToMany(mappedBy = "inventory",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Deal> deals;
}
