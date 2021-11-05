package zyz.algorithm.type.array.easy;

/**
 * @author zyz
 * @title: 多数元素
 * @seq: 169
 * @address: https://leetcode-cn.com/problems/majority-element/
 * @idea:
 */
public class MajorityElement_79 {

// 哈希
    // 排序法
    //摩尔投票法
    public int majorityElement(int[] nums) {
        int count=1;
        int cnt=nums[0];
        for (int i=0;i<nums.length;i++)
        {
            if (cnt==nums[i]) count++;
            else{
                count--;
                if (count==0)
                {
                    cnt=nums[i];
                    count=1;
                }
            }
        }
        return cnt;
    }

}
