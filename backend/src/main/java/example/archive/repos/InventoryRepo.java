package example.archive.repos;

import example.archive.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

//при наследованиии от JpaRepository происходит магия и создается готовая имплементация с базовыми методами
//                                                    сущность,его id
public interface InventoryRepo extends JpaRepository<Inventory,Long> {

}
