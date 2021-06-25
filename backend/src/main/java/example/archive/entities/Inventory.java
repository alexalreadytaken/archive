package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity//говорить для hibernate, что это сущность базы
@Table(name = "inventories")//конкретное название таблицы
@Data//аннотация ломбока
@NoArgsConstructor//аннотация ломбока, генерирует пустой конструкто для hibernate
@AllArgsConstructor//аннотация ломбока, генерирует конструктор со всеми полями
@Builder//аннотация ломбока, создает билдер для класса
@EqualsAndHashCode(of = "id")//аннотация ломбока
@ToString(exclude = "files")//аннотация ломбока
@JsonIgnoreProperties(value = "files")//при возвращении клиенту эти поля будут игнорироватся
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT")
    private String number;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT")
    private String introduction;

    //одна опись = много дел
    //cascade = при сохранении,удалении,... фонда все операции будут повторены для дочерних сущностей
    //orphanRemoval = удалять сущности, у которых нет связей ни с кем
    //fetch = сценарий загрузи при загрузки текущей сущности
    //в данном случае загрузка ленивая
    @OneToMany(orphanRemoval = true,
            fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //в таблице дел будет колонка inventory_id ссыдающаяся на колонку id в таблице описи
    @JoinColumn(name = "inventory_id",referencedColumnName = "id")
    private List<File> files;
}

