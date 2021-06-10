package example.archive.repos;

import example.archive.entities.File;
import example.archive.entities.FileNumber;
import example.archive.utils.TestEntitiesSupplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
@Tag("db-test")
public class FileRepoTest {

    @Autowired private FileRepo fileRepo;

    @Test
    public void saveFileTest(){
        log.info("test for saving file");
        File file = TestEntitiesSupplier.getFile();
        fileRepo.save(file);
        assertNotNull(file.getId(),"file id not assigned");
        assertTrue(fileRepo.existsById(file.getId()),"file not saved");
        fileRepo.delete(file);
    }

    @Test
    public void removeAllFilesTest(){
        log.trace("just convenient clean");
        fileRepo.deleteAll();
        assertEquals(0,fileRepo.count());
    }

    @Test
    public void updateFileNumberTest(){
        log.trace("test for update file number");
        File file = TestEntitiesSupplier.getFile();
        fileRepo.save(file);
        assertNotNull(file.getId(),"file id not assigned");
        assertTrue(fileRepo.existsById(file.getId()),"file not saved");
        assertNull(file.getOldNumber());
        FileNumber currentNumber = file.getCurrentNumber();
        file.setOldNumber(currentNumber);
        file.setCurrentNumber(TestEntitiesSupplier.getFileNumber());
        fileRepo.save(file);
        assertNotNull(file.getCurrentNumber(),"updated file number not saved");
        assertNotNull(file.getOldNumber(),"new old file number not saved");
        assertNotEquals(file.getCurrentNumber(),file.getOldNumber(),"old number equals current number");
        fileRepo.delete(file);
    }

}
