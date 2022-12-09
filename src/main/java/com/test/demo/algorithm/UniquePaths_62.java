package com.test.demo.algorithm;

/**
 * <p>
 *
 * </p>
 *
 * @author yangqingfang
 * @since 2022/10/24 11:55
 */
public class UniquePaths_62 {

    public static void main(String[] args) {
        UniquePaths_62 uniquePaths = new UniquePaths_62();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }

    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
        }
        return arr[m-1][n-1];
    }

}
