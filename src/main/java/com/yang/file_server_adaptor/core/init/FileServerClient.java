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

    public IFileServerHandler borrowFileServerHandler() throws RuntimeException {
        try {
            return this.pool.borrowObject();
        } catch (Exception e) {
            throw new RuntimeException("Fail to get fileServerHandler!", e);
        }
    }

    public void borrowFileServerHandler(IFileServerHandler fileServerHandler) {
        this.pool.returnObject(fileServerHandler);
    }
}
