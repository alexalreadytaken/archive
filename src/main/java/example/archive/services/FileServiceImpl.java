package example.archive.services;

import example.archive.entities.File;
import example.archive.repos.FileRepo;
import example.archive.services.interfaces.FileService;
import example.archive.utils.exceptions.BadRequestException;
import example.archive.utils.exceptions.NotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @NonNull private final FileRepo fileRepo;

    @Override
    public File deleteFile(Long fileId) {
        File file = getFileOrThrow(fileId);
        fileRepo.delete(file);
        log.trace("delete file by id = '{}'",fileId);
        return file;
    }

    @Override
    public File updateFile(File file) {
        if (!fileRepo.existsById(file.getId())) {
            log.warn("file for update not exists");
            throw new BadRequestException("данный путь не предназначен для сохранения нового дела");
        }
        return fileRepo.save(file);
    }

    private File getFileOrThrow(Long fileId){
        log.trace("try find file by id = '{}'",fileId);
        return fileRepo.findById(fileId)
                .orElseThrow(()->{
                    log.warn("file by id '{}' not found",fileId);
                    throw new NotFoundException("дело не найдено");
                });
    }
}
