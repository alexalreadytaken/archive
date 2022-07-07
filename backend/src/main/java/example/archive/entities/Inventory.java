package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "files")
@JsonIgnoreProperties(value = "files")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String number;

    @Column(columnDefinition = "TEXT")
    private String introduction;

    @OneToMany(orphanRemoval = true,
            fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id",referencedColumnName = "id")
    private List<File> files;
}