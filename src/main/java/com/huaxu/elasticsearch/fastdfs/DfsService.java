package com.huaxu.elasticsearch.fastdfs;

import org.springframework.web.multipart.MultipartFile;

public interface DfsService {

    String FILE_FORMAT = "^.+\\..+$";
    String CAN_NOT_FOUND_FILE_TO_UPLOAD = "未发现要上传的文件！";
    String INVALID_FILE_FORMAT = "无效的文件格式！";
    String ERROR = "操作错误！";
    String SUCCESS = "操作成功！";

    public String upload(MultipartFile multipartFile) throws KkException;

}
