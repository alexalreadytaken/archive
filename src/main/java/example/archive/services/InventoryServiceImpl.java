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
        Inventory inventory = inventoryRepo.findById(inventoryId)
                .orElseThrow(() -> new NotFoundException("опись не найдена"));
        inventoryRepo.deleteById(inventoryId);
        return inventory;
    }

    @Override
    public Inventory updateInventoryIntroduction(Long inventoryId, String introduction) {
        Inventory inventory = inventoryRepo.findById(inventoryId)
                .orElseThrow(() -> new NotFoundException("опись не найдена"));
        inventory.setIntroduction(introduction);
        return inventoryRepo.save(inventory);
    }

    @Override
    public List<File> getInventoryFiles(Long inventoryId) {
        return inventoryRepo
                .findById(inventoryId)
                .map(Inventory::getFiles)
                .orElseThrow(()->new NotFoundException("опись не найдена"));
    }

    @Override
    public Inventory addFileToInventory(Long inventoryId, File file) {
        Inventory inventory = inventoryRepo.findById(inventoryId)
                .orElseThrow(()->new NotFoundException("опись не найдена"));
        inventory.getFiles().add(file);
        return inventoryRepo.save(inventory);
    }
}
