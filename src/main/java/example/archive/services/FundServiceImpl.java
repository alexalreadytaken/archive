package example.archive.services;

import example.archive.entities.Fund;
import example.archive.entities.FundName;
import example.archive.entities.Inventory;
import example.archive.repos.FundRepo;
import example.archive.services.interfaces.FundService;
import example.archive.utils.exceptions.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class FundServiceImpl implements FundService {

    @NonNull private final FundRepo fundRepo;

    @Override
    public List<Fund> getFundsList() {
        return fundRepo.findAll(Sort.by("id"));
    }

    @Override
    public Fund saveFund(Fund fund) {
        return fundRepo.save(fund);
    }

    @Override
    public Fund updateFundName(Long fundId,String name) {
        Fund fund = fundRepo.findById(fundId)
                .orElseThrow(() -> new NotFoundException("фонд не найден"));
        FundName currentFundName = fund.getCurrentFundName();
        FundName fundName = createNewFundName(name,fund);
        fund.setCurrentFundName(fundName);
        if (currentFundName != null) {
            fund.getOldNames().add(currentFundName);
        }
        return fundRepo.save(fund);
    }

    @Override
    public List<Inventory> getFundInventories(Long fundId) {
        Fund fund = fundRepo.findById(fundId)
                .orElseThrow(() -> new NotFoundException("фонд не найден"));
        return fund.getInventories();
    }

    @Override
    public Inventory addInventoryToFund(Long fundId, Inventory inventory) {
        Fund fund = fundRepo.findById(fundId)
                .orElseThrow(() -> new NotFoundException("фонд не найден"));
        fund.getInventories().add(inventory);
        fundRepo.save(fund);
        return inventory;
    }


    private FundName createNewFundName(String name, Fund fund) {
        return FundName.builder()
                .name(name).fund(fund)
                .fromDate(LocalDateTime.now())
                .build();
    }
}
