package example.archive.controllers;

import example.archive.entities.Fund;
import example.archive.entities.Inventory;
import example.archive.services.interfaces.FundService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//контроллер, работающий по json'ам
@Slf4j//логгер от ломбока, генерируется при компиляции
@RequiredArgsConstructor//конструктор от ломобока, генерируется при компиляции, ищет final поля
@RequestMapping("/fund")//перед всеми запросами этого контроллера ставится /fund
@CrossOrigin
public class FundController {

    //spring автоматически передаст имплементацию, если их больше одной нужно говорить какую конкретно
    @NonNull private final FundService fundService;

    @GetMapping// get /fund
    public List<Fund> fundList(){
        return fundService.getFundsList();
    }

    // post to /fund
    //@RequestBody автоматически парсится из json, поля в котором должны называтся как в java классе
    @PostMapping
    public Fund saveFund(@RequestBody Fund fund){
        log.trace("request for save fund = '{}'",fund);
        return fundService.saveFund(fund);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    @DeleteMapping("/{fundId}")
    public Fund deleteFund(@PathVariable Long fundId){
        log.trace("request for delete fund by id = '{}'",fundId);
        return fundService.deleteFund(fundId);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    //@RequestBody автоматически парсится из json, поля в котором должны называтся как в java классе
    //в этом случае @RequestBody можно отправлять просто строку
    @PostMapping("/{fundId}/name")
    public Fund updateFundName(@PathVariable Long fundId, @RequestBody String name){
        log.trace("request for update name = '{}' for fund by id = '{}'",name,fundId);
        return fundService.updateFundName(fundId, name);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    @GetMapping("/{fundId}/inventory")
    public List<Inventory> fundInventories(@PathVariable Long fundId){
        log.trace("request for fund = '{}' inventories",fundId);
        return fundService.getFundInventories(fundId);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    //@RequestBody автоматически парсится из json, поля в котором должны называтся как в java классе
    @PostMapping("/{fundId}/inventory")
    public Inventory addInventory(@PathVariable Long fundId,@RequestBody Inventory inventory){
        log.trace("request for add inventory = '{}' to fund by id = '{}'",inventory,fundId);
        return fundService.addInventoryToFund(fundId,inventory);
    }

}
