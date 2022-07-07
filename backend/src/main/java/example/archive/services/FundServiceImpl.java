package example.archive.services;

import example.archive.entities.Fund;
import example.archive.entities.FundName;
import example.archive.entities.Inventory;
import example.archive.repos.FundNameRepo;
import example.archive.repos.FundRepo;
import example.archive.repos.InventoryRepo;
import example.archive.services.interfaces.FundService;
import example.archive.utils.exceptions.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FundServiceImpl implements FundService {

    @NonNull private final FundRepo fundRepo;
    @NonNull private final FundNameRepo fundNameRepo;
    @NonNull private final InventoryRepo inventoryRepo;

    @Override
    public List<Fund> getFundsList() {
        return fundRepo.selectAllWithJoinFetchName();
    }

    @Override
    public Fund saveFund(Fund fund) {
        log.trace("save fund = '{}'",fund);
        FundName currentFundName = fund.getCurrentFundName();
        if (currentFundName!=null) {
            currentFundName.setFund(fund);
        }
        return fundRepo.save(fund);
    }

    @Override
    public Fund deleteFund(Long fundId) {
        Fund fund = getFundOrThrow(fundId);
        log.trace("deleting fund = '{}'",fund);
        fundRepo.delete(fund);
        return fund;
    }

    @Override
    public Fund updateFundName(Long fundId,String name) {
        Fund fund = getFundOrThrow(fundId);
        FundName currentFundName = fund.getCurrentFundName();
        FundName newFundName = createNewFundName(name,fund);
        log.trace("set new name = '{}' for fund = '{}'",newFundName,fund);
        fund.setCurrentFundName(newFundName);
        if (currentFundName != null) {
            fund.getOldNames().add(currentFundName);
            fundNameRepo.save(newFundName);
        }
        return fundRepo.save(fund);
    }

    @Override
    public List<Inventory> getFundInventories(Long fundId) {
        Fund fund = getFundOrThrow(fundId);
        return fund.getInventories();
    }

    @Override
    public Inventory addInventoryToFund(Long fundId, Inventory inventory) {
        Fund fund = getFundOrThrow(fundId);
        log.trace("add inventory = '{}' to fund = '{}'",inventory,fund);
        fund.getInventories().add(inventory);
        inventoryRepo.save(inventory);
        fundRepo.save(fund);
        return inventory;
    }

    private Fund getFundOrThrow(Long fundId) {
        log.trace("try find fund by id = '{}'",fundId);
        return fundRepo.findById(fundId)
                .orElseThrow(()-> {
                    log.warn("fund by id = '{}' not found",fundId);
                    return new NotFoundException("фонд не найден");
                });
    }


    private FundName createNewFundName(String name, Fund fund) {
        FundName fundName = FundName.builder()
                .name(name).fund(fund)
                .fromDate(LocalDate.now())
                .build();
        log.trace("created new name = '{}' for fund = '{}'",fundName,fund.getId());
        return fundName;
    }
}
