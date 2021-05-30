package example.archive.services.interfaces;

import example.archive.entities.File;
import example.archive.entities.Inventory;

import java.util.List;

public interface InventoryService {

    Inventory deleteInventory(Long inventoryId);

    Inventory updateInventoryIntroduction(Long inventoryId,String introduction);

    List<File> getInventoryFiles(Long inventoryId);

    Inventory addFileToInventory(Long inventoryId,File file);
}
