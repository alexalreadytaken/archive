package example.archive.repos;

import example.archive.entities.FundName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundNameRepo extends JpaRepository<FundName,Long> {

}
