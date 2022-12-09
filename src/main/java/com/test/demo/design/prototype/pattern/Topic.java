package com.test.demo.design.prototype.pattern;

import java.util.*;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/5 11:18
 */
public class Topic {

    private Map<String,String> option = new HashMap<>();

    private String key = new String();

    public Topic(Map<String,String> option,String key){
        this.option = option;
        this.key = key;
    }

    public Map<String, String> getOption() {
        return option;
    }

    public void setOption(Map<String, String> option) {
        this.option = option;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
