package example.archive.services.interfaces;

import example.archive.entities.File;

public interface FileService {

    File deleteFile(Long fileId);

    File saveFile(File file);
}
