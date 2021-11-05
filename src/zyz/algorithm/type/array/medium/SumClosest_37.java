package zyz.algorithm.type.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 接近的三数之和
 * @seq: 16
 * @address: https://leetcode-cn.com/problems/3sum-closest/
 * @idea:
 */
public class SumClosest_37 {
    public static void main(String[] args) {

       int[] nums = {-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33};
       int target = 0;
        System.out.println( threeSumClosest(nums,target));
    }

    //这思路是错的，应该先固定一个数转换成两数之和的思路去做，这样会漏掉情况
    //[-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33] 比如i在-3的位置 j在6 按照该思路J一直跑到4 漏掉5 6 -11 这种情况
    public static int threeSumClosest1(int[] nums, int target) {

        int len=nums.length;
        int i=0,j=len-1;
        int tmp=target-nums[0]-nums[1]-nums[2];
        int tar=nums[0]+nums[1]+nums[2];
        int t=0;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        while(i!=j)
        {
            for(int k=0;k<len;k++)
            {
                if(k==i||k==j) continue;
                t=target-nums[i]-nums[j]-nums[k];
                if(Math.abs(tmp)>Math.abs(t))
                {
                    tmp=Math.abs(t);
                    tar=nums[i]+nums[j]+nums[k];
                }
                if(tmp==0) return tar;
            }
            int m=nums[i]+nums[j];
            if(m>=target) j--;
            else i++;
        }
        return tar;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

}
