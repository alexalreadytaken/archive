package example.archive.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

@Entity//говорить для hibernate, что это сущность базы
@Table(name = "fund_names")//конкретное название таблицы
@Data//аннотация ломбока
@NoArgsConstructor//аннотация ломбока, генерирует пустой конструкто для hibernate
@AllArgsConstructor//аннотация ломбока, генерирует конструктор со всеми полями
@Builder//аннотация ломбока, создает билдер для класса
@ToString(exclude = "fund")//аннотация ломбока
@EqualsAndHashCode(of = "id")//аннотация ломбока
@JsonIgnoreProperties(value = "fund")//при возвращении клиенту эти поля будут игнорироватся
public class FundName {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate fromDate;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT")
    private String name;

    //fetch = сценарий загрузи при загрузке текущей сущности
    //в данном случае загрузка ленивая
    @ManyToOne(fetch = FetchType.LAZY)
    //при удалении фонда удалятся все его имена
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Fund fund;
}
