package example.archive.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "deal_number")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "aDeal")
public class DealNumber {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String number;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Deal aDeal;
}
