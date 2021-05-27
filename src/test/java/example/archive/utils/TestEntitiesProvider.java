package example.archive.utils;

import example.archive.entities.*;

import java.time.LocalDateTime;
import java.util.*;

public class TestEntitiesProvider {

    // FIXME: 5/14/21
    @Deprecated
    public static Fund getDeepFund(int inventoriesCount,int dealCountInInventory){
        Random random = new Random();
        Set<Inventory> inventories = new HashSet<>();
        Fund fund = new Fund();
        FundName fundName = new FundName();
        fundName.setName("FUND_NAME");
        fundName.setFromDate(LocalDateTime.of(1900,12,12,12,12));
        fund.setCurrentFundName(fundName);
        fund.setNumber("3234");
        for (int i = 0; i < inventoriesCount; i++) {
            Inventory inventory = Inventory.builder()
                    .introduction("intro")
                    .number(i + "").build();
            inventories.add(inventory);
            Set<File> files = new HashSet<>();
            for (int j = 0; j < dealCountInInventory; j++) {
                FileNumber fileNumber = new FileNumber();
                fileNumber.setNumber(i+"."+j);
                File file = File.builder()
                        .number(fileNumber)
                        .annotation("annotation").heading("heading")
                        .sheetCount(random.nextInt(1000))
                        .docType("maybe text").dropout(false)
                        .nominal("my").defectsType('a')
                        .yearFrom(1900+j)
                        .yearTo(2000+i)
                        .build();
                fileNumber.setAFile(file);
                files.add(file);
            }
            inventory.setFiles(files);
        }
        fund.setInventories(inventories);
        return fund;
    }



}
