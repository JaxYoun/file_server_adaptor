package com.yang.file_server_adaptor.core.property;

import com.yang.file_server_adaptor.core.enumerate.FileServerType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesBean {

    @Value("${file.server.type}")
    private String serverType;

    @Value("${file.server.maxTotal}")
    private String maxTotal;

    @Value("${file.server.maxIdle}")
    private String maxIdle;

    @Value("${file.server.minIdle}")
    private String minIdle;

    public FileServerType getServerType() {
        return FileServerType.valueOf(serverType.trim().toUpperCase());
    }

    public void setServerType(String serverType) {
        this.serverType = serverType;
    }

    public int getMaxTotal() {
        return Integer.parseInt(maxTotal.trim());
    }

    public void setMaxTotal(String maxTotal) {
        this.maxTotal = maxTotal;
    }

    public int getMaxIdle() {
        return Integer.parseInt(this.maxIdle.trim());
    }

    public void setMaxIdle(String maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return Integer.parseInt(this.minIdle.trim());
    }

    public void setMinIdle(String minIdle) {
        this.minIdle = minIdle;
    }
}
