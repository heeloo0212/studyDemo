package com.test.demo.test;

import cn.hutool.crypto.digest.MD5;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/7 14:37
 */
public class Test05 {

    public static void main(String[] args) {
        //5d41402abc4b2a76b9719d911017c592
        //System.out.println(MD5.create().digestHex("hello"));

        PipedOutputStream outputStream = new PipedOutputStream();
        PipedInputStream inputStream;
        try {
            inputStream = new PipedInputStream(outputStream);
            for(int i=0;i<1000;i++){
                byte[] array = new byte[100];
                for(int j=0;j<100;j++){
                    byte b = (byte) j;
                    array[j] = b;
                }
                outputStream.write(array);
                if(outputStream != null){
                    int read = inputStream.read();
                    System.out.println(read);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(outputStream != null) {
                    outputStream.close();
                }

            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }

    }

}
