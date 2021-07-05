package zyz.algorithm.array.DynamicProgramming;

/**
 * @author zyz
 * @title: 使用最小花费爬楼梯
 * @seq: 19
 * @address: https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * @idea:
 *  简单题
 *   dp[i] 到达楼梯i的最小体力花费
 *   dp[i]=min[dp[i-2],dp[i-1]]+cost[i];
 *   dp[0]=cost[0];
 *   dp[1]=cost[1];
 */
public class MinCostClimbingStairs_19 {
}
