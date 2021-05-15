package example.archive.utils;

import example.archive.entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestEntitiesProvider {

    // FIXME: 5/14/21
    public static Fund getDeepFund(int inventoriesCount,int dealCountInInventory){
        Random random = new Random();
        List<Inventory> inventories = new ArrayList<>();
        Fund fund = new Fund();
        FundName fundName = new FundName();
        fundName.setFund(fund);
        fundName.setName("FUND_NAME");
        fundName.setFromDate(LocalDateTime.of(1900,12,12,12,12));
        fund.setFundName(fundName);
        fund.setNumber("3234");
        fund.setInventories(inventories);
        for (int i = 0; i < inventoriesCount; i++) {
            List<Deal> deals = new ArrayList<>();
            Inventory inventory = Inventory.builder()
                    .fund(fund).deals(deals)
                    .introduction("intro")
                    .number(i + "").build();
            inventories.add(inventory);
            for (int j = 0; j < dealCountInInventory; j++) {
                DealNumber dealNumber = new DealNumber();
                dealNumber.setNumber(i+"."+j);
                Deal deal = Deal.builder()
                        .number(dealNumber)
                        .inventory(inventory)
                        .annotation("annotation").heading("heading")
                        .sheetCount(random.nextInt(1000))
                        .docType("maybe text").dropout(false)
                        .nominal("my").defectsType('a')
                        .yearFrom(1900+j)
                        .yearTo(2000+i)
                        .build();
                dealNumber.setADeal(deal);
                deals.add(deal);
            }
        }
        return fund;
    }



}
