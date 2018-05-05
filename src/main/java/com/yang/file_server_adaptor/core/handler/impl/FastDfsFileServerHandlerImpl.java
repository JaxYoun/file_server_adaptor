package com.yang.file_server_adaptor.core.handler.impl;

import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import com.yang.file_server_adaptor.core.property.PropertiesBean;

public class FastDfsFileServerHandlerImpl implements IFileServerHandler {

    private PropertiesBean propertiesBean;

    public FastDfsFileServerHandlerImpl(PropertiesBean propertiesBean) {
        this.propertiesBean = propertiesBean;
    }

    @Override
    public void uploadFile() {
        System.out.println("fastDfs fastDfs");
    }

}
