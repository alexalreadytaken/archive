package example.archive.controllers;

import example.archive.entities.File;
import example.archive.entities.Inventory;
import example.archive.services.interfaces.InventoryService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//контроллер, работающий по json'ам
@Slf4j//логгер от ломбока, генерируется при компиляции
@RequiredArgsConstructor//конструктор от ломобока, генерируется при компиляции, ищет final поля
@RequestMapping("/inventory")//перед всеми запросами этого контроллера ставится /inventory
public class InventoryController {

    //spring автоматически передаст имплементацию, если их больше одной нужно говорить какую конкретно
    @NonNull private final InventoryService inventoryService;

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    @DeleteMapping("/{inventoryId}")
    public Inventory deleteInventory(@PathVariable Long inventoryId){
        log.trace("request for delete inventory by id = '{}'",inventoryId);
        return inventoryService.deleteInventory(inventoryId);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    //@RequestBody автоматически парсится из json, поля в котором должны называтся как в java классе
    //в этом случае @RequestBody можно отправлять просто строку
    @PutMapping("/{inventoryId}/introduction")
    public Inventory updateInventoryIntroduction(@PathVariable Long inventoryId, @RequestBody String intro){
        log.trace("request for update introduction = '{}' for inventory by id = '{}'",intro,inventoryId);
        return inventoryService.updateInventoryIntroduction(inventoryId,intro);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    @GetMapping("/{inventoryId}/file")
    public List<File> getInventoryFiles(@PathVariable Long inventoryId){
        log.trace("request for inventory = '{}' files",inventoryId);
        return inventoryService.getInventoryFiles(inventoryId);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    //@RequestBody автоматически парсится из json, поля в котором должны называтся как в java классе
    @PostMapping("/{inventoryId}/file")
    public Inventory addFileToInventory(@PathVariable Long inventoryId,@RequestBody File file){
        log.trace("request for add file to inventory by id = '{}', file = '{}'",inventoryId,file);
        return inventoryService.addFileToInventory(inventoryId,file);
    }
}
