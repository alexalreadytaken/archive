package example.archive.controllers;

import example.archive.entities.Fund;
import example.archive.entities.Inventory;
import example.archive.services.interfaces.FundService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class FundController {

    @NonNull private final FundService fundService;

    @MessageMapping("/fund")
    @SendTo("/topic/funds")
    public String saveFund(@Payload String fund){
        log.trace("request for save fund = '{}'",fund);
        return fund;
    }

    @GetMapping("/fund")
    public List<Fund> fundList(){
        return fundService.getFundsList();
    }

    @PostMapping("/fund")
    public Fund saveFund(@RequestBody Fund fund){
        log.trace("request for save fund = '{}'",fund);
        return fundService.saveFund(fund);
    }

    @DeleteMapping("/fund/{fundId}")
    public Fund deleteFund(@PathVariable Long fundId){
        log.trace("request for delete fund by id = '{}'",fundId);
        return fundService.deleteFund(fundId);
    }

    @PostMapping("/fund/{fundId}/name")
    public Fund updateFundName(@PathVariable Long fundId, @RequestBody String name){
        log.trace("request for update name = '{}' for fund by id = '{}'",name,fundId);
        return fundService.updateFundName(fundId, name);
    }

    @GetMapping("/fund/{fundId}/inventory")
    public List<Inventory> fundInventories(@PathVariable Long fundId){
        log.trace("request for fund = '{}' inventories",fundId);
        return fundService.getFundInventories(fundId);
    }

    @PostMapping("/fund/{fundId}/inventory")
    public Inventory addInventory(@PathVariable Long fundId,@RequestBody Inventory inventory){
        log.trace("request for add inventory = '{}' to fund by id = '{}'",inventory,fundId);
        return fundService.addInventoryToFund(fundId,inventory);
    }

}
