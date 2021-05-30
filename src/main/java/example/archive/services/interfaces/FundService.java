package example.archive.services.interfaces;

import example.archive.entities.Fund;
import example.archive.entities.Inventory;

import java.util.List;

public interface FundService {

    List<Fund> getFundsList();

    Fund saveFund(Fund fund);

    Fund updateFundName(Long fundId,String name);

    List<Inventory> getFundInventories(Long fundId);

    Inventory addInventoryToFund(Long fundId, Inventory inventory);
}
