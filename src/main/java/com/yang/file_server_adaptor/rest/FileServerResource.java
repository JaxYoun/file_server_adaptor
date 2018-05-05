package com.yang.file_server_adaptor.rest;

import com.yang.file_server_adaptor.core.init.FileServerClient;
import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/file")
public class FileServerResource {

    @Autowired
    private FileServerClient fileServerClient;

    @GetMapping("/uploadFile")
    public void uploadFile() {
        try {
            GenericObjectPool<IFileServerHandler> pool = this.fileServerClient.getPool();
            IFileServerHandler fileServerHandler = pool.borrowObject();
            fileServerHandler.uploadFile();
            pool.returnObject(fileServerHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
