package example.archive.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity//говорить для hibernate, что это сущность базы
@Table(name = "files")//конкретное название таблицы
@Data//аннотация ломбока
@NoArgsConstructor//аннотация ломбока, генерирует пустой конструкто для hibernate
@AllArgsConstructor//аннотация ломбока, генерирует конструктор со всеми полями
@Builder//аннотация ломбока, создает билдер для класса
@EqualsAndHashCode(of = "id")//аннотация ломбока
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    /*// FIXME: 5/23/21
    @ElementCollection
    @CollectionTable(name = "file_indexes")
    @MapKeyJoinColumn(name = "index_id")
    @Column(name = "value",columnDefinition = "TEXT")
    private Map<Index,String> indexes;*/

    //одно дело = один текущий номер
    //cascade = при сохранении,удалении,... фонда все операции будут повторены для дочерних сущностей
    //orphanRemoval = удалять сущности, у которых нет связей ни с кем
    //fetch = сценарий загрузи при загрузки текущей сущности
    //в данном случае загрузка жадная
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    //в таблице дела будет колонка current_file_number_id ссылающаяся на колонку id в таблице номеров дел
    @JoinColumn(name = "current_file_number_id",referencedColumnName = "id")
    //при запросе дела в этом же запросе будет join на номер
    @Fetch(value = FetchMode.JOIN)
    private FileNumber currentNumber;

    //одно дело = один старый номер
    //cascade = при сохранении,удалении,... фонда все операции будут повторены для дочерних сущностей
    //orphanRemoval = удалять сущности, у которых нет связей ни с кем
    //fetch = сценарий загрузи при загрузки текущей сущности
    //в данном случае загрузка жадная
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    //в таблице дела будет колонка old_file_number_id ссылающаяся на колонку id в таблице номеров дел
    @JoinColumn(name = "old_file_number_id",referencedColumnName = "id")
    //при запросе дела в этом же запросе будет join на номер
    @Fetch(value = FetchMode.JOIN)
    private FileNumber oldNumber;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT")
    private String heading;

    private long sheetCount;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT")
    private String annotation;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT")
    private String docType;

    //говорит postgres'у что это тип данных text
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
