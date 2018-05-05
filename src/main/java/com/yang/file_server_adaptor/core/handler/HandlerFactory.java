package com.yang.file_server_adaptor.core.handler;

import com.yang.file_server_adaptor.core.handler.impl.FastDfsFileServerHandlerImpl;
import com.yang.file_server_adaptor.core.handler.impl.FtpFileServerHandlerImpl;
import com.yang.file_server_adaptor.core.handler.impl.SftpFileServerHandlerImpl;
import com.yang.file_server_adaptor.core.property.PropertiesBean;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class HandlerFactory extends BasePooledObjectFactory<IFileServerHandler> {

    private PropertiesBean propertiesBean;

    public HandlerFactory(PropertiesBean propertiesBean) {
        this.propertiesBean = propertiesBean;
    }

    @Override
    public IFileServerHandler create() throws Exception {
        IFileServerHandler fileServerHandler;
        switch (this.propertiesBean.getServerType()) {
            case FTP: {
                fileServerHandler = new FtpFileServerHandlerImpl(this.propertiesBean);
                break;
            }
            case SFTP: {
                fileServerHandler = new SftpFileServerHandlerImpl(this.propertiesBean);
                break;
            }
            case FAST_DFS: {
                fileServerHandler = new FastDfsFileServerHandlerImpl(this.propertiesBean);
                break;
            }
            default: {
                fileServerHandler = null;
                break;
            }
        }
        return fileServerHandler;
    }

    @Override
    public PooledObject<IFileServerHandler> wrap(IFileServerHandler iFileServerHandler) {
        return new DefaultPooledObject<>(iFileServerHandler);
    }

}
