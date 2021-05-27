package example.archive.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "file_numbers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "aFile")
public class FileNumber {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String number;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private File aFile;
}
