package example.archive.controllers;

import example.archive.entities.File;
import example.archive.entities.Inventory;
import example.archive.services.interfaces.InventoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class InventoryController {

    @NonNull private final InventoryService inventoryService;

    @DeleteMapping("/inventory/{inventoryId}")
    public Inventory deleteInventory(@PathVariable Long inventoryId){
        return inventoryService.deleteInventory(inventoryId);
    }

    @PutMapping("/inventory/{inventoryId}/introduction")
    public Inventory updateInventoryIntroduction(@PathVariable Long inventoryId, @RequestBody String intro){
        return inventoryService.updateInventoryIntroduction(inventoryId,intro);
    }

    @GetMapping("/inventory/{inventoryId}/file")
    public List<File> getInventoryFiles(@PathVariable Long inventoryId){
        return inventoryService.getInventoryFiles(inventoryId);
    }

    @PostMapping("/inventory/{inventoryId}/file")
    public Inventory addFileToInventory(@PathVariable Long inventoryId,@RequestBody File file){
        return inventoryService.addFileToInventory(inventoryId,file);
    }
}
