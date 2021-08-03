package zyz.algorithm.array.medium;

import zyz.algorithm.utils.Utils;

/**
 * @author zyz
 * @title: 螺旋矩阵 II
 * @seq: 59
 * @address: https://leetcode-cn.com/problems/spiral-matrix-ii/
 * @idea:
 */
public class SpiralMatrixII_52 {
    public static void main(String[] args) {
        int[][] t=generateMatrix(3);
        Utils.print2Arr(t);
    }
    public static int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int t=1;
        int i=-1,j=-1;
        int q=0;
        while(true)
        {
            for(i++,j++;j<n-q;j++) matrix[i][j]=t++;
            if(t==(n*n+1)) break;
            for(j--,i++;i<n-q;i++) matrix[i][j]=t++;
            if(t==(n*n+1)) break;
            for(i--,j--;j>=q;j--) matrix[i][j]=t++;
            if(t==(n*n+1)) break;
            for(j++,i--;i>q;i--) matrix[i][j]=t++;
            if(t==(n*n+1)) break;
            q++;
        }
        return matrix;
    }
}
