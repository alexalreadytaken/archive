package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(value = "fund")
public class FundName {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime fromDate;

    @Column(columnDefinition = "TEXT")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fund fund;
}
