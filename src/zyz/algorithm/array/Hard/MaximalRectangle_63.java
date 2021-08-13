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
        char[][]  matrix = {{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}};
        Utils.print2Arr(matrix);
        System.out.println();
        System.out.println( maximalRectangle(matrix));;

    }
    //暴力
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
        int wid=n;

       for (int i=0;i<m;i++)
       {
           for (int j=0;j<n;j++)
           {
               wid=row[i][j];
               //计算出以当前位置为起点能形成的最大矩形面积
               for (int k=i+1;k<m;k++)
               {
                   if(matrix[k][j]=='0') break;
                   wid=Math.min(wid,row[k][j]);
                   max=Math.max(max,(k-i+1)*wid);
                   if((k-i+1)*wid==15) System.out.println(i+" "+j);
               }
           }
       }
        System.out.println();
        Utils.print2Arr(row);
        return max;
    }
}
