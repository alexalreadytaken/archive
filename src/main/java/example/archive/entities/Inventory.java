package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "inventories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties(value = "files")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String number;

    @Column(columnDefinition = "TEXT")
    private String introduction;

    @OneToMany(targetEntity = File.class,orphanRemoval = true,
            fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "inventory_id",referencedColumnName = "id")
    private List<File> files;
}
