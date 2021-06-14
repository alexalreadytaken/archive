package example.archive.repos;

import example.archive.entities.FileNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileNumberRepo extends JpaRepository<FileNumber,Long> {
}
