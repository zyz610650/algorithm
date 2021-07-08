package zyz.algorithm.array.DynamicProgramming.medium;

/**
 * @author zyz
 * @title: 跳跃游戏
 * @seq: 22
 * @address: https://leetcode-cn.com/problems/jump-game/
 * @idea:
 *   就无需用dp，分类误导 lj dp
 *
 *   贪心
 *   这种方法所依据的核心特性：如果一个位置能够到达，那么这个位置左侧所有位置都能到达
 *
 */
public class JumpGame_22 {

    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums) {
        int len=nums.length;
        boolean[] dp=new boolean[len];
        dp[0]=true;

        for(int i=0;i<len;i++)
        {
            for(int j=1;j<=nums[i];j++)
                if(dp[i]&&i+nums[j]<len)
                {
                    dp[i+nums[i]]=true;
                }
        }
        return dp[len-1];
    }

    // 这种方法所依据的核心特性：如果一个位置能够到达，那么这个位置左侧所有位置都能到达
    public boolean canJump2(int[] nums)
    {
        int k=0;
        for (int i=0;i<nums.length;i++)
        {
            if(i>k) return false;
            k=Math.max(k,i+nums[i]);
        }
        return true;
    }
}
