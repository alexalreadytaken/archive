package example.archive.repos;

import example.archive.entities.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FundRepo extends JpaRepository<Fund,Long> {
    Fund getById(Long id);

    Fund getByNumber(String number);

    @Transactional
    @Modifying
    void deleteByNumber(String number);

    @Transactional
    @Modifying
    @Query("update Fund set number=:number")
    void setFundNumber(@Param("number") String number);
}
