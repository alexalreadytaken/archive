package example.archive.repos;

import example.archive.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepo extends JpaRepository<File,Long> {
}
