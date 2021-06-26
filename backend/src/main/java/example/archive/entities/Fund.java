package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity//говорить для hibernate, что это сущность базы
@Table(name = "funds")//конкретное название таблицы
@Data//аннотация ломбока
@NoArgsConstructor//аннотация ломбока, генерирует пустой конструкто для hibernate
@AllArgsConstructor//аннотация ломбока, генерирует конструктор со всеми полями
@Builder//аннотация ломбока, создает билдер для класса
@EqualsAndHashCode(of = "id")//аннотация ломбока
@ToString(exclude = "inventories")//аннотация ломбока
@JsonIgnoreProperties(value = {"inventories"})//при возвращении клиенту эти поля будут игнорироватся
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT",nullable = false)
    @NotBlank // TODO: 6/26/21 not work
    private String number;

    @Column(length = 1)
    private String letter;

    //один фонд = одно текущее имя
    //cascade = при сохранении,удалении,... фонда все операции будут повторены для дочерних сущностей
    //orphanRemoval = удалять сущности, у которых нет связей ни с кем
    //fetch = сценарий загрузи при загрузке текущей сущности
    //в данном случае загрузка ленивая
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true,
            fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.JOIN)
    //в таблице фонда будет колонка fund_name_id ссылающаяся на колонку id в имени фонда
    @JoinColumn(name = "fund_name_id",referencedColumnName = "id")
    private FundName currentFundName;

    //один фонд = много старых имен
    //cascade = при сохранении,удалении,... фонда все операции будут повторены для дочерних сущностей
    //orphanRemoval = удалять сущности, у которых нет связей ни с кем
    //fetch = сценарий загрузи при загрузке текущей сущности
    //в данном случае загрузка ленивая
    @OneToMany(targetEntity = FundName.class,orphanRemoval = true,
            fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    //в таблице имени фонда будет колонка fund_id ссылающаяся на колонку id в фонде
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    //дополнительный фильтр, что бы исключить текущее имя фонда
    @Where(clause = "select f.fund_name_id!=id from funds f where f.id=fund_id")
    private List<FundName> oldNames;

    //один фонд = много описей
    //cascade = при сохранении,удалении,... фонда все операции будут повторены для дочерних сущностей
    //orphanRemoval = удалять сущности, у которых нет связей ни с кем
    //fetch = сценарий загрузи при загрузке текущей сущности
    //в данном случае загрузка ленивая
    @OneToMany(orphanRemoval = true,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //в таблице описи будет колонка fund_id ссылающаяся на колонку id в фонде
    @JoinColumn(name = "fund_id",referencedColumnName = "id")
    private List<Inventory> inventories;

}
