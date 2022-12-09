package com.test.demo.design.prototype.old;

import com.test.demo.design.prototype.old.QuestionBankController;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/9/5 11:14
 */
public class Test {

    public static void main(String[] args) {
        QuestionBankController questionBankController = new QuestionBankController();
        System.out.println(questionBankController.createPaper("花花", "1000001921032"));
        System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
        System.out.println(questionBankController.createPaper("大宝", "1000001921987"));
    }
}
