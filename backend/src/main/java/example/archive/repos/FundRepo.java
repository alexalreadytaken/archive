package example.archive.repos;

import example.archive.entities.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

//при наследованиии от JpaRepository происходит магия и создается готовая имплементация с базовыми методами
//                                          сущность,его id
public interface FundRepo extends JpaRepository<Fund,Long> {

    //кастомные query
    //здесь используется HQL, чтобы включить нативные (mysql,postgresql,...) запросы надо добавить nativeQuery=true
    @Query("select f from Fund f left join fetch f.currentFundName")
    List<Fund> selectAllWithJoinFetchName();

    //кастомные query
    //здесь используется HQL, чтобы включить нативные mysql,postgresql,... запросы надо добавить nativeQuery=true
    @Transactional//при ошибке изменение не сохранится
    @Modifying//разрешение изменять таблицу
    @Query("update Fund set number=:number")
    void setFundNumber(@Param("number") String number);
}
