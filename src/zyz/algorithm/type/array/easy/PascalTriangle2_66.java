package zyz.algorithm.type.array.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 杨辉三角 II
 * @seq: 119
 * @address: https://leetcode-cn.com/problems/pascals-triangle-ii/
 * @idea:
 */
public class PascalTriangle2_66 {
    public static void main(String[] args) {

    }
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp=new Integer[rowIndex+1];
        Arrays.fill(dp,1);
        for(int i=1;i<=rowIndex;i++)
        {
            for(int j=i-1;j>=1;j--)
            {
                dp[j]+=dp[j-1];
            }
        }
        return Arrays.asList(dp);
    }
}
