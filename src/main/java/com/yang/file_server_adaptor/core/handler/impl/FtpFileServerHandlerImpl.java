package com.yang.file_server_adaptor.core.handler.impl;

import com.yang.file_server_adaptor.core.handler.IFileServerHandler;
import com.yang.file_server_adaptor.core.property.PropertiesBean;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;

public class FtpFileServerHandlerImpl implements IFileServerHandler {

    private static final Logger logger = LoggerFactory.getLogger(FtpFileServerHandlerImpl.class);

    private PropertiesBean propertiesBean;

    private FTPClient ftpClient;

    public FtpFileServerHandlerImpl(PropertiesBean propertiesBean) {
        this.propertiesBean = propertiesBean;
    }

    public boolean init() {
        boolean flag = false;
        ftpClient = new FTPClient();
        try {
            ftpClient.connect(this.propertiesBean.getHost(), this.propertiesBean.getPort());
            ftpClient.login(this.propertiesBean.getUserName(), this.propertiesBean.getPassword());
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                logger.info("FTP连接失败，用户名或密码错误！");
                ftpClient.disconnect();
            } else {
                flag = true;
                logger.info("FTP连接成功！");
            }
        } catch (SocketException e) {
            logger.error("FTP服务器地址错误！", e);
        } catch (IOException e) {
            logger.error("FTP服务器端口错误！", e);
        }
        return flag;
    }

    @Override
    public void uploadFile() {

    }

    public void uploadFile(String directory, String fileName, InputStream inputStream) {
        System.out.println("Ftp Ftp");
        try {
            this.ftpClient.changeWorkingDirectory(directory);
            this.ftpClient.storeFile(fileName, inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                this.ftpClient.disconnect();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }

    }
}
