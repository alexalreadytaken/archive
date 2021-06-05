package example.archive.entities;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Map;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /*// FIXME: 5/23/21
    @ElementCollection
    @CollectionTable(name = "file_indexes")
    @MapKeyJoinColumn(name = "index_id")
    @Column(name = "value",columnDefinition = "TEXT")
    private Map<Index,String> pointers;*/

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "current_file_number_id",referencedColumnName = "id")
    private FileNumber currentNumber;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "old_file_number_id",referencedColumnName = "id")
    private FileNumber oldNumber;

    @Column(columnDefinition = "TEXT")
    private String heading;

    private long sheetCount;

    @Column(columnDefinition = "TEXT")
    private String annotation;

    @Column(columnDefinition = "TEXT")
    private String docType;

    @Column(columnDefinition = "TEXT")
    private String nominal;

    private boolean dropout;

    private char defectsType;

    private int dayFrom;

    private int monthFrom;

    private int yearFrom;

    private int dayTo;

    private int monthTo;

    private int yearTo;
}
