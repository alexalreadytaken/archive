package example.archive.entities;

import lombok.*;
import org.hibernate.annotations.*;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "funds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String number;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "fund_name_id",referencedColumnName = "id")
    private FundName currentFundName;

    // TODO: 5/29/21 exclude current name
    @OneToMany(targetEntity = FundName.class,orphanRemoval = true,
            fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    private List<FundName> oldNames;

    @OneToMany(targetEntity = Inventory.class,orphanRemoval = true,
            fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    private List<Inventory> inventories;

}
