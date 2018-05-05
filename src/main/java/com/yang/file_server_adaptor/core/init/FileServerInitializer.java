package com.yang.file_server_adaptor.core.init;

import com.yang.file_server_adaptor.core.handler.HandlerFactory;
import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import com.yang.file_server_adaptor.core.pool.PoolConfig;
import com.yang.file_server_adaptor.core.property.PropertiesBean;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FileServerInitializer {

    @Autowired
    private PropertiesBean propertiesBean;

    @Bean
    public FileServerClient initFileServerClient() {
        GenericObjectPool<IFileServerHandler> pool = new GenericObjectPool<IFileServerHandler>(new HandlerFactory(this.propertiesBean), new PoolConfig(this.propertiesBean));
        return new FileServerClient(pool);
    }

}
