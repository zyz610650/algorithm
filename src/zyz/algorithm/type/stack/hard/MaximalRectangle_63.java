package zyz.algorithm.type.stack.hard;

import zyz.algorithm.utils.Utils;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author zyz
 * @title: 最大矩形
 * @seq: 85
 * @address: https://leetcode-cn.com/problems/maximal-rectangle/
 * @idea:
 */
public class MaximalRectangle_63 {
    public static void main(String[] args) {
        char[][]  matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        System.out.println();
        System.out.println( maximalRectangle1(matrix));;

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

    //单调栈 思路就是把每一行当作第84题来做，就是每一行如果matrix为1 就记录它为1的高度 然后以每一行为柱子的底
    //代码就是 计算每一行高度 然后调用第84题的代码
    //https://leetcode-cn.com/problems/maximal-rectangle/solution/js85zui-da-ju-xing-dan-diao-zhan-lian-do-20st/
    public static int maximalRectangle1(char[][] matrix) {
        int m=matrix.length;
        if(m==0) return 0;
        int n=matrix[0].length;
        int max=0;
        int[] height=new int[n+2];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)//col
            {
                if(matrix[i][j]=='1') height[j+1]++;
                else height[j+1]=0;
            }
            System.out.println(Arrays.toString(height));
            max=Math.max(max,getMax(height,n+2));
        }
        return max;
    }

    public static int getMax(int[] height,int n)
    {
        Deque<Integer> stack=new ArrayDeque<>();
        int max=0;
        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty()&&height[i]<height[stack.peekLast()])
            {
                int peek=stack.pollLast();
                int left= stack.peekLast();
                max=Math.max(max,(i-left-1)*height[peek]); // 注意这减的是 左边比自己小的下标 不能减自己的下标,这样得话左边比自己大的地方就没有算
                //  0, 3, 1, 3, 2, 2, 0 比如 1, 3, 2, 2 计算2 的时候栈里为 0 1 2 2 计算2应该是2的下标-1的下标再-1 否则3这个柱子就没有算上
            }

            stack.addLast(i);
        }

        return max;
    }

}
