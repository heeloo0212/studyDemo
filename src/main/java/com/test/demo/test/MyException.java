package com.test.demo.test;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/3/29 9:18
 */
public class MyException extends Exception{

    public MyException(){
        super();
    }

    public MyException(String message){
        super(message);
    }

    public MyException(String message,Throwable cause){
        super(message, cause);
    }

    public MyException(Throwable cause){
        super(cause);
    }

}
