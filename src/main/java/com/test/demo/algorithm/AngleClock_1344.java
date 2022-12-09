package com.test.demo.algorithm;

/**
 * <p>
 * 1344. 时钟指针的夹角
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/12/9 10:40
 */
public class AngleClock_1344 {

    public static void main(String[] args) {
        AngleClock_1344 angleClock = new AngleClock_1344();
        double v = angleClock.angleClock(3, 15);
        System.out.println(v);
    }

    public double angleClock(int hour, int minutes) {
        double res = 0;
        double minAngle = minutes * 6;
        double hourAngle = hour * 30 + 0.5 * minutes;
        if(minAngle > hourAngle){
           res = minAngle - hourAngle;
        }else {
            res = hourAngle - minAngle;
        }
        return res>180?360-res:res;
    }
}
