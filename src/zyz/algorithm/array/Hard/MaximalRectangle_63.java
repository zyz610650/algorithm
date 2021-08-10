package zyz.algorithm.array.Hard;

import zyz.algorithm.utils.Utils;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 最大矩形
 * @seq: 85
 * @address: https://leetcode-cn.com/problems/maximal-rectangle/
 * @idea:
 */
public class MaximalRectangle_63 {
    public static void main(String[] args) {
        char[][]  matrix = {{'1','1','1','1','1','1','1','1'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','1','1','0'},{'1','1','1','1','1','0','0','0'},{'0','1','1','1','1','0','0','0'}};
        Utils.print2Arr(matrix);
        System.out.println();
        System.out.println( maximalRectangle(matrix));;

    }
    public static int maximalRectangle(char[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        int[][] row=new int[m][n];
        int ans=0;
        for(int i=0;i<m;i++)
        {
            ans=0;
            for(int j=n-1;j>=0;j--)
            {
                if(matrix[i][j]=='1')
                {
                    row[i][j]=++ans;
                    max=Math.max(max,ans);
                }else{
                    ans=0;
                }
            }
        }
        Utils.print2Arr(row);
        int min=n;
        int index=m-1;
        int eIndex=0,maxE=0,minE=0;
        for(int j=0;j<n;j++)
        {
            min=n;
            index=m-1;
            for(int i=m-1;i>=0;i--)
            {
                if(matrix[index][j]!='1'&&matrix[i][j]=='1')
                {
                    index=i;
                }
                if(matrix[i][j]=='1')
                {
                    min=Math.min(min,row[i][j]);
                    minE=Math.min(min, row[i][j])*(index-i+1);
                    if(i!=m-1&&row[i][j]==row[i+1][j])
                    {
                        maxE=(row[i][j]+row[i+1][j])*(eIndex-i-+1);
                    }else eIndex=i;
                    max=Math.max(max,minE);
                    max=Math.max(max,maxE);

                }else index=i;
            }
        }
        System.out.println();
        Utils.print2Arr(row);
        return max;
    }
}
