package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "funds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties(value = "inventories")
@ToString(exclude = "inventories")
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String number;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "fund_name_id",referencedColumnName = "id")
    @Fetch(value = FetchMode.JOIN)
    @UniqueElements
    private FundName currentFundName;

    @OneToMany(targetEntity = FundName.class,orphanRemoval = true,
            fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    @Where(clause = "select f.fund_name_id!=id from funds f where f.id=fund_id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<FundName> oldNames;


    @OneToMany(targetEntity = Inventory.class,orphanRemoval = true,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Inventory> inventories;

}
