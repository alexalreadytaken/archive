package example.archive;

import example.archive.entities.Fund;
import example.archive.repos.*;
import example.archive.utils.TestEntitiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@Slf4j
public class FundTests {

    @Autowired
    private FundRepo fundRepo;

    private final String testFundNumber = "i hope this number not exists";

    @BeforeEach
    public void saveTestEntity(){
        log.info("prepare fund with id {}", testFundNumber);
        Fund fund = TestEntitiesProvider.getDeepFund(2, 2);
        fund.setNumber(testFundNumber);
        fundRepo.save(fund);
    }

    @AfterEach
    public void tryRemoveTestEntity(){
        log.info("removing test find if exists");
        fundRepo.deleteByNumber(testFundNumber);
    }

    @Test
    public void cascadeFundInsertTest(){
        log.info("test for cascade saving entities");
        Fund fund = TestEntitiesProvider.getDeepFund(2, 2);
        fundRepo.save(fund);
    }

    @Test
    public void gettingFundTest(){
        log.info("test for getting fund from db");
        Fund one = fundRepo.getByNumber(testFundNumber);
        Assert.notNull(one,"fund not found");
    }

    @Test
    public void cascadeFundDeleteTest(){
        log.info("test for delete fund and entire entities");
        fundRepo.deleteByNumber(testFundNumber);
        Fund fund = fundRepo.getByNumber(testFundNumber);
        Assert.isNull(fund,"fund not deleted");
    }
}
