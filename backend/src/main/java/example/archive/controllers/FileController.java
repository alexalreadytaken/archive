package example.archive.controllers;


import example.archive.entities.File;
import example.archive.services.interfaces.FileService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController//контроллер, работающий по json'ам
@Slf4j//логгер от ломбока, генерируется при компиляции
@RequiredArgsConstructor//конструктор от ломобока, генерируется при компиляции, ищет final поля
@RequestMapping("/file")//перед всеми запросами этого контроллера ставится /file
@CrossOrigin
public class FileController {

    //spring автоматически передаст имплементацию, если их больше одной нужно говорить какую конкретно
    @NonNull private final FileService fileService;

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    @DeleteMapping("/{fileId}")
    public File deleteFile(@PathVariable Long fileId){
        log.trace("request for deleting file with id = '{}'",fileId);
        return fileService.deleteFile(fileId);
    }

    //то что в фигурных скобка вводится в браузере, передается в @PathVariable
    //@RequestBody автоматически парсится из json, поля в котором должны называтся как в java классе
    @PutMapping("/{fileId}")
    public File updateFile(@PathVariable String fileId,
                           @RequestBody File file){
        log.trace("request for update file with id = '{}'",fileId);
        return fileService.saveFile(file);
    }

}
