package com.yang.file_server_adaptor.core.handler.impl;

import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import com.yang.file_server_adaptor.core.property.PropertiesBean;

public class SftpFileServerHandlerImpl implements IFileServerHandler {

    private PropertiesBean propertiesBean;

    public SftpFileServerHandlerImpl(PropertiesBean propertiesBean) {
        this.propertiesBean = propertiesBean;
    }

    @Override
    public void uploadFile() {
        System.out.println("sftp sftp");
    }

}
