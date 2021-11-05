package zyz.algorithm.type.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 杨辉三角
 * @seq: 16
 * @address: https://leetcode-cn.com/problems/pascals-triangle/
 * @idea:
 * 1. 判断
 *    根据1 根据2
 * 2.dp[i][j]=dp[i-1][j-1]
 * 3.边界: j=0 全为1  i=j 全为1
 */
public class PascalTriangle_16 {
    public static void main(String[] args) {
        int n=5;
        int[][] dp=new int[n][n];
        dp[0][0]=1;
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <=i ; j++) {
                if (j==0||j==i) dp[i][j]=1;
                else dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
            }
        }


    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows == 0) return new ArrayList<>();
        List<Integer> inlist = new ArrayList<>();
        inlist.add(1);
        list.add(inlist);
        for(int i = 2;i <= numRows;i++){
            List<Integer> rows = list.get(i-2);
            List<Integer> newlist = new ArrayList<>();
            newlist.add(1);
            //根据前一行的值计算
            for(int j = 0;j < rows.size()-1;j++){
                newlist.add(rows.get(j)+rows.get(j+1));
            }
            newlist.add(1);
            list.add(newlist);
        }
        return list;
    }
}

