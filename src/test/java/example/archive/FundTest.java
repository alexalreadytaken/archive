package example.archive;

import example.archive.entities.Fund;
import example.archive.entities.FundName;
import example.archive.repos.FundRepo;
import example.archive.utils.TestEntitiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class FundTest {

    @Autowired
    private FundRepo fundRepo;

    private Long testFundId;

    @BeforeEach
    public void saveTestEntity(){
        Fund fund = TestEntitiesProvider.getFund();
        fundRepo.save(fund);
        testFundId=fund.getId();
        log.info("prepare fund with id {}", testFundId);
    }

    @AfterEach
    public void tryRemoveTestEntity(){
        log.info("removing test find if exists");
        if (fundRepo.existsById(testFundId))fundRepo.deleteById(testFundId);
    }

    @Test
    public void fundSaveTest(){
        log.info("test for cascade saving entities");
        Fund fund = TestEntitiesProvider.getFund();
        fundRepo.save(fund);
        assertNotNull(fund.getId(),"id for fund not assigned");
        assertTrue(fundRepo.existsById(fund.getId()),"fund not saved");
    }

    @Test
    public void getFundListTest(){
        log.info("test for getting all fund");
        fundRepo.saveAll(TestEntitiesProvider.getFunds(2));
        assertTrue(fundRepo.count()>=2,"several funds not saved");
    }

    @Test
    public void gettingFundTest(){
        log.info("test for getting fund from db");
        Fund one = fundRepo.getById(testFundId);
        Assert.notNull(one,"fund not found");
    }

    @Test
    public void cascadeFundDeleteTest(){
        log.info("test for delete fund and entire entities");
        fundRepo.deleteById(testFundId);
        Optional<Fund> fund = fundRepo.findById(testFundId);
        if (fund.isPresent())throw new TestAbortedException("fund not deleted");
    }

    @Test
    public void clearAllTest(){
        log.info("just convenient clean");
        fundRepo.deleteAll();
        assertEquals(0, fundRepo.count());
    }

    @Test
    public void updateFundNameTest(){
        Fund fund = fundRepo.getById(testFundId);
        FundName oldCurrentFundName = fund.getCurrentFundName();
        FundName newCurrentFundName = TestEntitiesProvider.getFundName(fund);
        fund.setCurrentFundName(newCurrentFundName);
        fund.getOldNames().add(oldCurrentFundName);
        fundRepo.save(fund);
        // TODO: 5/29/21 how check
    }
}
