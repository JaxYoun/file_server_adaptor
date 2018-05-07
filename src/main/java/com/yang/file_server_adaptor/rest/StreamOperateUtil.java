package com.yang.file_server_adaptor.rest;

import java.io.*;

public class StreamOperateUtil {

    public static void main(String[] args) throws FileNotFoundException {

        InputStream input = new FileInputStream("c:\\test.txt");
        //InputStream input =  httpconn.getInputStream(); //这里可以写你获取到的流

        ByteArrayOutputStream baos = cloneInputStream(input);

        // 打开两个新的输入流
        InputStream stream1 = new ByteArrayInputStream(baos.toByteArray());
        InputStream stream2 = new ByteArrayInputStream(baos.toByteArray());

    }

    private static ByteArrayOutputStream cloneInputStream(InputStream input) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = input.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
