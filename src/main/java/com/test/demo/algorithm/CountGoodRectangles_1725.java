package com.test.demo.algorithm;

/**
 * <p>
 * 1725. 可以形成最大正方形的矩形数目
 * 给你一个数组 rectangles ，其中 rectangles[i] = [li, wi] 表示第 i 个矩形的长度为 li 、宽度为 wi 。
 *
 * 如果存在 k 同时满足 k <= li 和 k <= wi ，就可以将第 i 个矩形切成边长为 k 的正方形。例如，矩形 [4,6] 可以切成边长最大为 4 的正方形。
 *
 * 设 maxLen 为可以从矩形数组 rectangles 切分得到的 最大正方形 的边长。
 *
 * 请你统计有多少个矩形能够切出边长为 maxLen 的正方形，并返回矩形 数目 。
 * </p>
 *
 * @author yangqingfang
 * @since 2022/12/8 14:18
 */
public class CountGoodRectangles_1725 {

    public static void main(String[] args) {
        CountGoodRectangles_1725 countGoodRectangles = new CountGoodRectangles_1725();
        int[][] rectangles = new int[][]{{5,8},{8,9},{5,12},{16,5}};
        int i = countGoodRectangles.countGoodRectangles(rectangles);
        System.out.println(i);
    }

    public int countGoodRectangles(int[][] rectangles) {
        int length = 0;
        int width = 0;
        int count = 0;
        int maxLen = 0;
        for(int i=0;i<rectangles.length;i++){
            length = rectangles[i][0];
            width = rectangles[i][1];
            int min = Math.min(length, width);
            if(min > maxLen){
                maxLen = min;
                count = 0;
            }else if(min == maxLen){
                count++;
            }
        }
        return count+1;
    }

}
