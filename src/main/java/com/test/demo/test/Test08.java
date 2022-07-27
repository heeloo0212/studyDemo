package com.test.demo.test;

import cn.hutool.core.codec.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/21 17:35
 */
public class Test08 {

    public static void main(String[] args) {
        Test08 test08 = new Test08();
        System.out.println("666:---"+test08.base64ToStr("http://124.71.219.129:19014/down/pic/20220719/park/256097280/055914_闽DZ100W_BLUE_SB.jpg"));
    }

    private String base64ToStr(String path) {
        InputStream in = null;
        byte[] bytes;
        URL url;
        HttpURLConnection conn;
        String base64 = "";

        try {
            url = new URL(path);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(2 * 1000);
            conn.setRequestProperty("Accept-Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + "UTF-8");
            in = conn.getInputStream();
            bytes = readInputStream(in);
            base64 = Base64.encode(bytes);

        } catch (IOException e) {

        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
            }
        }
        return base64;
    }

    private byte[] readInputStream(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            int bytesRead = 0;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer, 0, 1024)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.flush();
            return out.toByteArray(); //将输出流的结果转换为字节数组的形式返回	（先执行finally再执行return	）
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }
}
