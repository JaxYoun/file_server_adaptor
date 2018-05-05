package com.yang.file_server_adaptor.core.pool;

import com.yang.file_server_adaptor.core.property.PropertiesBean;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class PoolConfig extends GenericObjectPoolConfig {

    public PoolConfig(PropertiesBean propertiesBean) {
        if (propertiesBean.getMaxTotal() > 0) {
            this.setMaxTotal(propertiesBean.getMaxTotal());
        }
        if (propertiesBean.getMaxIdle() > 0) {
            this.setMaxIdle(propertiesBean.getMaxIdle());
        }
        if (propertiesBean.getMinIdle() > 0) {
            this.setMinIdle(propertiesBean.getMinIdle());
        }
    }

}
