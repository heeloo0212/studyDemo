package com.test.demo.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/4/1 9:19
 */
public class Test1 {

    public static void main(String[] args) {
        String url = "www.baidu.com?cd=362&id=fffff==&checkout=4444";
        System.out.println(getQueryParams(url));
    }

    public static Map<String, String> getQueryParams(String url) {
        try {
            Map<String, String> params = new HashMap<String, String>();
            String[] urlParts = url.split("\\?");
            if (urlParts.length > 1) {
                String query = urlParts[1];
                for (String param : query.split("&")) {
                    String[] pair = param.split("=",2);
                    String key = URLDecoder.decode(pair[0], "UTF-8");
                    String value = "";
                    if (pair.length > 1) {
                        value = URLDecoder.decode(pair[1], "UTF-8");
                    }
                    params.put(key,value);
                }
            }

            return params;
        } catch (UnsupportedEncodingException ex) {
            throw new AssertionError(ex);
        }
    }

}
