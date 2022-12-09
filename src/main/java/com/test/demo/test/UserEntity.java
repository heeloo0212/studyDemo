package com.test.demo.test;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/2 15:52
 */
public class UserEntity{
    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo("lyh");
        UserInfo userInfo1 = new UserInfo("24","female");
        UserInfo userInfo2 = new UserInfo("lyh","24","female");

    }
}

class UserInfo {

    private String name;

    private String age;

    private String sex;

    public UserInfo getUserInfo(String name){
        return this;
    }

    public UserInfo(String name){
        this.name = name;
    }

    public UserInfo(String age,String sex){
        this.age = age;
        this.sex = sex;
    }

    public UserInfo(String name,String age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

}
