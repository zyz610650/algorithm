package zyz.algorithm.type.array.medium;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title:旋转图像
 * @seq:48
 * @address: https://leetcode-cn.com/problems/rotate-image/
 * @idea:
 */
public class RotateImage_47 {

    //这题背下来

    public static void main(String[] args) {
       int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate1(matrix);
    }
    //规律 (row,col)->(col,n-row-1) 倒着赋值就只需要一个变量就行了
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n /2; ++i) {
            for (int j = i; j < n-i-1; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
        Utils.print2Arr(matrix);
    }

    public static void rotate1(int[][] matrix)
    {
        int tmp=0;
        int n=matrix.length;
        for(int i=0;i<n/2;i++)
        {
            for(int j=0;j<n;j++)
            {
                tmp=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=tmp;
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        Utils.print2Arr(matrix);
    }
}
