package com.yang.file_server_adaptor.rest;

import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import com.yang.file_server_adaptor.core.init.FileServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
public class ExceptionChain {

    @Autowired
    private FileServerClient fileServerClient;

    public InputStream downloadFileAsInputStream(String directory, String fileName) {
        IFileServerHandler fileServerHandler = null;
        try {
            fileServerHandler = this.fileServerClient.borrowFileServerHandler();
            fileServerHandler.uploadFile();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            this.fileServerClient.borrowFileServerHandler(fileServerHandler);
        }
        return null;
    }

}
