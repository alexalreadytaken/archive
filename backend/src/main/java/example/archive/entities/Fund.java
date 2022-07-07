package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "funds")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "inventories")
@JsonIgnoreProperties(value = {"inventories"})
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "TEXT",nullable = false)
    @NotBlank // TODO: 6/26/21 not work
    private String number;

    @Column(length = 1)
    private String letter;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.JOIN)
    @JoinColumn(name = "fund_name_id",referencedColumnName = "id")
    private FundName currentFundName;

    @OneToMany(targetEntity = FundName.class,orphanRemoval = true,
            fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    @Where(clause = "select f.fund_name_id!=id from funds f where f.id=fund_id")
    private List<FundName> oldNames;

    @OneToMany(orphanRemoval = true,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    private List<Inventory> inventories;
}