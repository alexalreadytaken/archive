package example.archive.repos;

import example.archive.entities.DealNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealNumberRepo extends JpaRepository<DealNumber,Long> {
}
