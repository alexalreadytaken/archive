package example.archive.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "indexes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Index {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String value;
}
