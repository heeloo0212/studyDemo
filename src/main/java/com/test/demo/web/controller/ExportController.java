package com.test.demo.web.controller;

import com.test.demo.web.entity.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/5/31 8:37
 */
@RestController
@RequestMapping("/yang")
public class ExportController {

    @RequestMapping("/exportFile")
    public void exportFile(HttpServletRequest request, HttpServletResponse response){
        String fileName = "金海湾5号-3栋1#电容柜-通讯状态.xlsx";
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
        /**
         *创建HSSFWorkbook对象(excel的文档对象)，本实例是导出扩张名为xls（office2003）。
         * 如果需要导出扩展名xlsx（office2007以后版本），只需要把文中HSSF改为XSSF即可，
         * 如      HSSFWorkbook改为XSSFWorkbook。
         */
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet userTable = wb.createSheet("用户表");

        /**
         *  HSSFRow 代表行   0 = 表的第一行
         *  HSSFCell 代表列  0 = 第一行第一列
         *  注意 ： 单元行单元列下标从零开始
         */
        HSSFRow row0 = userTable.createRow(0);
        HSSFCell cell0 = row0.createCell(0);
        // 设置内容
        cell0.setCellValue("用户表格一览");
        // 合并单元格 起始行 截至列 起始列 截至行
        userTable.addMergedRegion(new CellRangeAddress(0,0,0,4));


        //设置单元列名
        HSSFRow row1 = userTable.createRow(1);
        row1.createCell(0).setCellValue("姓名");
        row1.createCell(1).setCellValue("年龄");
        row1.createCell(2).setCellValue("住址");


        //  循环内容
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            HSSFRow row = userTable.createRow(i + 2);
            row.createCell(0).setCellValue(user.getName());
            row.createCell(1).setCellValue(user.getAge());
            row.createCell(2).setCellValue(user.getAddress());

        }

        try (OutputStream os = response.getOutputStream()) {
            response.reset();
            if (fileName == null) {
                fileName = UUID.randomUUID().toString();
            }
            String encode = URLEncoder.encode(fileName, "UTF-8");
            System.out.println(encode);
            System.out.println(URLDecoder.decode(encode,"UTF-8"));
            response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
            response.setHeader("Content-Disposition","inline;filename=" + encode);
            wb.write(os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
