package com.test.demo.web.entity;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/20 16:03
 */
public class UserDocument {

    private String id;
    private String name;
    private String sex;
    private Integer age;
    private String city;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
