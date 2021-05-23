package example.archive.repos;

import example.archive.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepo extends JpaRepository<File,Long> {

}
