package com.yang.file_server_adaptor.core.init;

import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class FileServerClient {

    private GenericObjectPool<IFileServerHandler> pool;

    public FileServerClient(GenericObjectPool<IFileServerHandler> pool) {
        this.pool = pool;
    }

    public GenericObjectPool<IFileServerHandler> getPool() {
        return pool;
    }

    public void setPool(GenericObjectPool<IFileServerHandler> pool) {
        this.pool = pool;
    }
}
