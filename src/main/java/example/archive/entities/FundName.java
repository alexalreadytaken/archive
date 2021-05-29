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
@ToString(exclude = "fund")
@EqualsAndHashCode(of = "id")
public class FundName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime fromDate;

    @Column(columnDefinition = "TEXT")
    private String name;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fund fund;
}
