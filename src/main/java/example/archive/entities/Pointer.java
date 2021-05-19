package example.archive.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pointer")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pointer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String value;
}
