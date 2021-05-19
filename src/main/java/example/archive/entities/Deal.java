package example.archive.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "deal")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "id")
@ToString(exclude = "inventory")
// TODO: 5/19/21 RENAME
public class Deal {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @PrimaryKeyJoinColumn
    private Inventory inventory;

    @ElementCollection
    @CollectionTable(name = "deal_pointers")
    @MapKeyJoinColumn(name = "pointer_id")
    @Column(name = "value",columnDefinition = "TEXT")
    private Map<Pointer,String> pointers;

    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @PrimaryKeyJoinColumn
    private DealNumber number;

    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @PrimaryKeyJoinColumn
    private DealNumber oldNumber;


    @Column(columnDefinition = "TEXT")
    private String heading;

    private long sheetCount;

    @Column(columnDefinition = "TEXT")
    private String annotation;

    // TODO: 5/13/21 type
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
