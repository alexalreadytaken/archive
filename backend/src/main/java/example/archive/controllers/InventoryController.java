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
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {

    @NonNull private final InventoryService inventoryService;

    @DeleteMapping("/{inventoryId}")
    public Inventory deleteInventory(@PathVariable Long inventoryId){
        log.trace("request for delete inventory by id = '{}'",inventoryId);
        return inventoryService.deleteInventory(inventoryId);
    }

    @PutMapping("/{inventoryId}/introduction")
    public Inventory updateInventoryIntroduction(@PathVariable Long inventoryId, @RequestBody String intro){
        log.trace("request for update introduction = '{}' for inventory by id = '{}'",intro,inventoryId);
        return inventoryService.updateInventoryIntroduction(inventoryId,intro);
    }

    @GetMapping("/{inventoryId}/file")
    public List<File> getInventoryFiles(@PathVariable Long inventoryId){
        log.trace("request for inventory = '{}' files",inventoryId);
        return inventoryService.getInventoryFiles(inventoryId);
    }

    @PostMapping("/{inventoryId}/file")
    public Inventory addFileToInventory(@PathVariable Long inventoryId,@RequestBody File file){
        log.trace("request for add file to inventory by id = '{}', file = '{}'",inventoryId,file);
        return inventoryService.addFileToInventory(inventoryId,file);
    }
}