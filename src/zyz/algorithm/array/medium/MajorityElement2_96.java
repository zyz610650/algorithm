package zyz.algorithm.array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 求众数 II
 * @seq:  229
 * @address: https://leetcode-cn.com/problems/majority-element-ii/
 * @idea:
 */
public class MajorityElement2_96 {

    public static void main(String[] args) {
        int[] nums={1,2};
        System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(int[] nums) {
        int p1=nums[0],p2=nums[0],cnt1=0,cnt2=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if (p1==nums[i])
            {
                cnt1++;
                continue;
            }
            if (p2==nums[i])
            {
                cnt2++;
                continue;
            }
            if(cnt1==0)
            {
                p1=nums[i];
                cnt1++;
                continue;
            }

            if(cnt2==0)
            {
                p2=nums[i];
                cnt2++;
                continue;
            }
            cnt1--;
            cnt2--;
        }

        cnt1=0;
        cnt2=0;
        for (int i=0;i<n;i++)
        {
            if (p1==nums[i]) cnt1++;
            if (p2==nums[i]) cnt2++;
        }
        System.out.println(p1+"  "+p2);
        List<Integer> list=new ArrayList<>();
        if (cnt1>n/3)  list.add(p1);
        if (cnt2>n/3)  list.add(p2);
        return list;
    }
}
