package zyz.algorithm.hot.top;

import java.util.List;
import java.util.Random;

/**
 * @author zyz
 * @title: 384. 打乱数组
 * @seq: 384
 * @address: https://leetcode-cn.com/problems/shuffle-an-array/
 * @idea:
 */
public class T384_325 {

    class Solution {

        List<int[]> lists;
        int[] nums;
        int[] cntNums;

        Random rand=new Random();
        public Solution(int[] nums) {
            this.nums=nums;
            cntNums=new int[nums.length];
            System.arraycopy(nums,0,cntNums,0,nums.length);
        }

        public int[] reset() {
            System.arraycopy(cntNums,0,nums,0,nums.length);
            return nums;
        }

        public int[] shuffle() {

            for(int i=0;i<nums.length;i++)
            {
                int j=i+rand.nextInt(nums.length-i);
                int tmp=nums[i];
                nums[i]=nums[j];
                nums[j]=tmp;
            }
            return nums;
        }

    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

}
