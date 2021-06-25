package example.archive.services;

import example.archive.entities.File;
import example.archive.repos.FileRepo;
import example.archive.services.interfaces.FileService;
import example.archive.utils.exceptions.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service//специальная аннотация для spring, что бы он мог понять, что этот класс нужно передавать другим
@Slf4j//логгер от ломбока, генерируется при компиляции
@RequiredArgsConstructor//конструктор от ломобока, генерируется при компиляции, ищет final поля
public class FileServiceImpl implements FileService {

    //spring автоматически передаст имплементацию, если их больше одной нужно говорить какую конкретно
    @NonNull private final FileRepo fileRepo;

    @Override
    public File deleteFile(Long fileId) {
        File file = getFileOrThrow(fileId);
        fileRepo.delete(file);
        log.trace("delete file by id = '{}'",fileId);
        return file;
    }

    @Override
    public File saveFile(File file) {
        log.trace("save file = '{}'",file);
        return fileRepo.save(file);
    }

    private File getFileOrThrow(Long fileId){
        log.trace("try find file by id = '{}'",fileId);
        return fileRepo.findById(fileId)
                .orElseThrow(()->{
                    log.warn("file by id '{}' not found",fileId);
                    throw new NotFoundException("дело не найдено");//передается в ErrorsController
                });
    }
}
