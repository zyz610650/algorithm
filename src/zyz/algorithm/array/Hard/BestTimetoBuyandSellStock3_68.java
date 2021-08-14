package zyz.algorithm.array.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 买卖股票的最佳时机 III
 * @seq: 123
 * @address: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 * @idea:
 */
public class BestTimetoBuyandSellStock3_68 {
    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};

        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int n=prices.length;
        int min=Integer.MAX_VALUE;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(min>=prices[i]) min=prices[i];
            else {
                list.add(prices[i]-min);
            }
        }
        Integer[] arr= list.toArray(new Integer[0]);
        Arrays.sort(arr);
        return arr[arr.length-1]+arr[arr.length-2];
//        3,3,5,0,0,4,3,1
//        思路: 记录最大和最小利润的下标,然后这时候可能分成两个区间 递归继续寻找 比如这个
//        3,3,5    0,0,4      3,1
//        找到0,0,4  再分别从 3,3,5  和  3,1找 记录每次分区后找到的最大利润 存到List,然后排序之类去最后两个
    }
}

