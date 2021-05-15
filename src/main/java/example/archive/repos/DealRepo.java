package example.archive.repos;

import example.archive.entities.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepo extends JpaRepository<Deal,Long> {

}
