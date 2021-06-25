package example.archive.repos;

import example.archive.entities.File;
import example.archive.entities.Inventory;
import example.archive.utils.TestEntitiesSupplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Tag("db-test")
public class InventoryRepoTest {

    @Autowired private InventoryRepo inventoryRepo;

    @Test
    public void saveInventoryTest(){
        log.trace("test for saving inventory test");
        Inventory inventory = TestEntitiesSupplier.getInventory();
        inventoryRepo.save(inventory);
        assertNotNull(inventory.getId(),"inventory id not assigned");
        assertTrue(inventoryRepo.existsById(inventory.getId()),"inventory not saved");
    }

    @Test
    public void addFileToInventoryTest(){
        log.trace("test for adding file to inventory");
        Inventory inventory = TestEntitiesSupplier.getInventory();
        inventoryRepo.save(inventory);
        assertNotNull(inventory.getId(),"inventory id not assigned");
        assertTrue(inventoryRepo.existsById(inventory.getId()),"inventory not saved");
        File file = TestEntitiesSupplier.getFile();
        inventory.getFiles().add(file);
        inventoryRepo.save(inventory);
        assertEquals(3,inventory.getFiles().size());
        inventoryRepo.delete(inventory);
    }
}
