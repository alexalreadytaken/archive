package example.archive.repos;

import example.archive.entities.FileNumber;
import org.springframework.data.jpa.repository.JpaRepository;

//при наследованиии от JpaRepository происходит магия и создается готовая имплементация с базовыми методами
//                                                    сущность  ,его id
public interface FileNumberRepo extends JpaRepository<FileNumber,Long> {
}
