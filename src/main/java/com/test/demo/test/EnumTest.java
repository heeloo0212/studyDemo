package com.test.demo.test;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/6 18:15
 */
public enum EnumTest {
    
    ARE_YOU_OK("XIAOMI","LEIJUN"),
    THANK_YOU("THANK","YOU");

    private String code;

    private String value;

    EnumTest(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
