package com.test.demo.web.controller;

import com.pig4cloud.plugin.excel.annotation.ResponseExcel;
import com.pig4cloud.plugin.excel.annotation.Sheet;
import com.test.demo.web.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/7/20 9:16
 */
@RestController
public class EasyExcelController {

    @ResponseExcel(name = "test", sheets = @Sheet(sheetName = "testSheet1"))
    @GetMapping("/easyExcelTest")
    public List<User> easyExcelTest(){
        List<User> users = new ArrayList<>();
        users.add(new User("老马1","18","河南洛阳"));
        users.add(new User("老马2","18","河南洛阳"));
        users.add(new User("老马3","18","河南洛阳"));
        users.add(new User("老马4","18","河南洛阳"));
        users.add(new User("老马5","18","河南洛阳"));
        users.add(new User("老马6","18","河南洛阳"));
        users.add(new User("老马7","18","河南洛阳"));
        users.add(new User("老马8","18","河南洛阳"));
        users.add(new User("老马9","18","河南洛阳"));
        users.add(new User("老马10","18","河南洛阳"));
        return users;
    }

}
