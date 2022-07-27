package com.test.demo.aspect;

import com.test.demo.test.aspect.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Describe:
 * @Author: yangqingfang
 * @Date: 2022/5/6 9:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeforeAndAfterTest {

    @Test
    public void beforeAndAfterTest(){
        new Target();
    }

}
