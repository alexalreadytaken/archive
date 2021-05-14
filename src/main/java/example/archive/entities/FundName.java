package example.archive.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class FundName {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fromDate;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    private Fund fund;
}
