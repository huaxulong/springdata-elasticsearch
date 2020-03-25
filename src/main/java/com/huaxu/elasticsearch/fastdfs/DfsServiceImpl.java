package com.huaxu.elasticsearch.fastdfs;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.DefaultFastFileStorageClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Service
public class DfsServiceImpl implements DfsService {

    private final DefaultFastFileStorageClient storageClient;

    public DfsServiceImpl(DefaultFastFileStorageClient storageClient) {
        this.storageClient = storageClient;
    }

    @Override
    public String upload(MultipartFile multipartFile) throws KkException {
        InputStream inputStream;
        try {
            inputStream = multipartFile.getInputStream();
        } catch (IOException e) {
            throw new KkException(CAN_NOT_FOUND_FILE_TO_UPLOAD, e);
        }

        String originalFilename = multipartFile.getOriginalFilename();
        if (Objects.isNull(originalFilename) || !originalFilename.matches(FILE_FORMAT)) {
            throw new KkException(INVALID_FILE_FORMAT);
        }
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        StorePath storePath;
        try {
            storePath = storageClient.uploadFile(inputStream, multipartFile.getSize(), suffix, null);
        } catch (Exception e) {
            throw new KkException(ERROR, (IOException) e);
        }

        String path = storePath.getFullPath();
        return path;
    }
}
