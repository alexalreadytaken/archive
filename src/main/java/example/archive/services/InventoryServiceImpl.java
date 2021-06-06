package example.archive.services;

import example.archive.entities.File;
import example.archive.entities.Inventory;
import example.archive.repos.InventoryRepo;
import example.archive.services.interfaces.InventoryService;
import example.archive.utils.exceptions.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    @NonNull private final InventoryRepo inventoryRepo;

    @Override
    public Inventory deleteInventory(Long inventoryId) {
        Inventory inventory = getInventoryOrThrow(inventoryId);
        log.trace("delete inventory = '{}'",inventory);
        inventoryRepo.deleteById(inventoryId);
        return inventory;
    }

    @Override
    public Inventory updateInventoryIntroduction(Long inventoryId, String introduction) {
        Inventory inventory = getInventoryOrThrow(inventoryId);
        log.trace("update inventory = '{}' set introduction = '{}'",inventory,introduction);
        inventory.setIntroduction(introduction);
        return inventoryRepo.save(inventory);
    }

    @Override
    public List<File> getInventoryFiles(Long inventoryId) {
        return getInventoryOrThrow(inventoryId)
                .getFiles();
    }

    @Override
    public Inventory addFileToInventory(Long inventoryId, File file) {
        Inventory inventory = getInventoryOrThrow(inventoryId);
        log.trace("add file = '{}' to inventory = '{}'",file,inventory);
        inventory.getFiles().add(file);
        return inventoryRepo.save(inventory);
    }

    private Inventory getInventoryOrThrow(Long inventoryId) {
        log.trace("try find inventory by id = '{}'",inventoryId);
        return inventoryRepo.findById(inventoryId)
                .orElseThrow(() -> {
                    log.warn("inventory by id = '{}' not found",inventoryId);
                    return new NotFoundException("опись не найдена");
                });
    }
}
