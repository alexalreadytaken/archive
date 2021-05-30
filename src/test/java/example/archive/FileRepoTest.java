package example.archive;

import example.archive.entities.File;
import example.archive.repos.FileRepo;
import example.archive.utils.TestEntitiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class FileRepoTest {

    @Autowired
    private FileRepo fileRepo;

    @Test
    public void saveFileTest(){
        log.info("test for saving file");
        File file = TestEntitiesProvider.getFile();
        fileRepo.save(file);
        assertNotNull(file.getId());
        assertTrue(fileRepo.existsById(file.getId()));
    }
}
