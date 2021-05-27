package example.archive.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "fund_names")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "fund")
public class FundName {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fromDate;

    @Column(columnDefinition = "TEXT")
    private String name;

    @OneToOne
    private Fund fund;
}
