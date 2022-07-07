package example.archive.controllers;


import example.archive.entities.File;
import example.archive.services.interfaces.FileService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/file")
@CrossOrigin
public class FileController {

    @NonNull private final FileService fileService;

    @DeleteMapping("/{fileId}")
    public File deleteFile(@PathVariable Long fileId){
        log.trace("request for deleting file with id = '{}'",fileId);
        return fileService.deleteFile(fileId);
    }

    @PutMapping("/{fileId}")
    public File updateFile(@PathVariable String fileId,
                           @RequestBody File file){
        log.trace("request for update file with id = '{}'",fileId);
        return fileService.saveFile(file);
    }

}