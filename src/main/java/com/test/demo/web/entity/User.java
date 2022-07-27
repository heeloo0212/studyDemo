package com.test.demo.web.entity;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/5/30 19:22
 */
public class User {

    @ExcelProperty("用户名")
    String name;

    @ExcelProperty("年龄")
    String age;

    @ExcelProperty("地址")
    String address;

    public User(String name, String age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
