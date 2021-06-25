package example.archive.entities;

import lombok.*;

import javax.persistence.*;

@Entity//говорить для hibernate, что это сущность базы
@Table(name = "file_numbers")//конкретное название таблицы
@Data//аннотация ломбока
@NoArgsConstructor//аннотация ломбока, генерирует пустой конструкто для hibernate
@AllArgsConstructor//аннотация ломбока, генерирует конструктор со всеми полями
@Builder//аннотация ломбока, создает билдер для класса
@EqualsAndHashCode(of = "id")//аннотация ломбока
public class FileNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //говорит postgres'у что это тип данных text
    @Column(columnDefinition = "TEXT")
    private String number;

}
