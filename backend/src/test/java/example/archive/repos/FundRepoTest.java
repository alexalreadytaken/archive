package example.archive.repos;

import example.archive.entities.Fund;
import example.archive.entities.FundName;
import example.archive.utils.TestEntitiesSupplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Tag("db-test")
public class FundRepoTest {

    @Autowired private FundRepo fundRepo;

    private Long testFundId;

    @BeforeEach
    public void prepare(){
        Fund fund = TestEntitiesSupplier.getFund();
        fundRepo.save(fund);
        testFundId=fund.getId();
        log.info("prepare fund with id {}", testFundId);
    }

    @AfterEach
    public void clean(){
        log.info("removing test find if exists");
        if (fundRepo.existsById(testFundId))fundRepo.deleteById(testFundId);
    }

    @Test
    public void fundSave(){
        log.info("test for cascade saving entities");
        Fund fund = TestEntitiesSupplier.getFund();
        fundRepo.save(fund);
        assertNotNull(fund.getId(),"id for fund not assigned");
        assertTrue(fundRepo.existsById(fund.getId()),"fund not saved");
    }

    @Test
    public void gettingFund(){
        log.info("test for getting fund from db");
        Optional<Fund> one = fundRepo.findById(testFundId);
        assertTrue(one.isPresent(),"fund not found");
    }

    @Test
    public void cascadeFundDelete(){
        log.info("test for delete fund and entire entities");
        fundRepo.deleteById(testFundId);
        Optional<Fund> fund = fundRepo.findById(testFundId);
        assertFalse(fund.isPresent(),"fund not deleted");
    }

    @Test
    public void clearAll(){
        log.info("just convenient clean");
        fundRepo.deleteAll();
        assertEquals(0, fundRepo.count());
    }

    @Test
    @Transactional
    public void getOldFundNames(){
        this.updateFundName();
        Optional<Fund> fundOpt = fundRepo.findById(testFundId);
        assertTrue(fundOpt.isPresent(),"test fund not found");
        Fund fund = fundOpt.get();
        FundName currentFundName = fund.getCurrentFundName();
        List<FundName> oldNames = fund.getOldNames();
        assertFalse(oldNames.contains(currentFundName),"current fund name contains in old names");
    }

    @Test
    @Transactional
    public void updateFundName(){
        log.info("start update name test");
        Optional<Fund> fundOpt = fundRepo.findById(testFundId);
        assertTrue(fundOpt.isPresent(),"test fund not found");
        Fund fund = fundOpt.get();
        FundName currentFundName = fund.getCurrentFundName();
        FundName fundName = TestEntitiesSupplier.getFundName(fund);
        fund.setCurrentFundName(fundName);
        if (currentFundName != null) {
            fund.getOldNames().add(currentFundName);
        }
        fundRepo.save(fund);
        assertFalse(fund.getOldNames().contains(fundName),"current fund name contains in old names");
    }
}
