package example.archive.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Deal {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    @PrimaryKeyJoinColumn
    private DealNumber number;

    @OneToOne
    @PrimaryKeyJoinColumn
    private DealNumber oldNumber;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Inventory inventory;

    private String heading;

    private long sheetCount;

    private String annotation;

    // TODO: 5/13/21 type
    private String docType;

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
