package com.yang.file_server_adaptor.core.enumerate;

public enum FileServerType {
    NAIVE_FS("naiveFileSystem"),
    FTP("ftp"),
    SFTP("sftp"),
    FAST_DFS("fastDfs");

    private String name;

    FileServerType(String name) {
        this.name = name;
    }
}
