package example.archive.controllers;

import example.archive.entities.Fund;
import example.archive.entities.Inventory;
import example.archive.services.interfaces.FundService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin
public class FundController {

    @NonNull private final FundService fundService;

    @GetMapping("/fund")
    public List<Fund> fundList(){
        return fundService.getFundsList();
    }

    @PostMapping("/fund")
    public Fund saveFund(@RequestBody Fund fund){
        return fundService.saveFund(fund);
    }

    @PostMapping("/fund/{fundId}/name")
    public Fund updateFundName(@PathVariable Long fundId, @RequestBody String name){
        return fundService.updateFundName(fundId, name);
    }

    @GetMapping("/fund/{fundId}/inventory")
    public List<Inventory> fundInventories(@PathVariable Long fundId){
        return fundService.getFundInventories(fundId);
    }

    @PostMapping("/fund/{fundId}/inventory")
    public Inventory addInventory(@PathVariable Long fundId,@RequestBody Inventory inventory){
        return fundService.addInventoryToFund(fundId,inventory);
    }

}
