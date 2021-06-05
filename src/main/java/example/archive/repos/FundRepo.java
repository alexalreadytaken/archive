package example.archive.repos;

import example.archive.entities.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FundRepo extends JpaRepository<Fund,Long> {

    @Query("select f from Fund f join fetch f.currentFundName")
    List<Fund> selectAllWithJoinFetch();

    @Transactional
    @Modifying
    @Query("update Fund set number=:number")
    void setFundNumber(@Param("number") String number);
}
