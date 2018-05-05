package com.yang.file_server_adaptor.core.handler.impl;

import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import com.yang.file_server_adaptor.core.property.PropertiesBean;
import sun.net.ftp.impl.FtpClient;

public class FtpFileServerHandlerImpl implements IFileServerHandler {

    private PropertiesBean propertiesBean;

    private FtpClient ftpClient;

    public FtpFileServerHandlerImpl(PropertiesBean propertiesBean) {
        this.propertiesBean = propertiesBean;
//        ftpClient = new
    }

    @Override
    public void uploadFile() {
        System.out.println("Ftp Ftp");
    }
}
