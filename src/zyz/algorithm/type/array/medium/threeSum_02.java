package zyz.algorithm.type.array.medium;

import java.util.*;

/**
 * @author zyz
 * @date $
 * @title: 三数之和$
 * @seq: 02$
 * @address: https://leetcode-cn.com/problems/3sum/$
 */
public class threeSum_02 {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists=threeSum1(nums);
        System.out.println("asds");


    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> lists=new ArrayList<>();
       List<Integer> list;
        int[] maps= {-1, -1, -1};
        Arrays.sort(nums);
        int len=nums.length;
        for (int i=0;i<len;i++)
        {
            if (i!=0&&nums[i]==nums[i-1]) continue;
            for (int j=i+1;j<len;j++)
            {
                if (nums[j]==nums[j-1]&&j!=i+1) continue;
                for (int k=j+1;k<len;k++)
                {
                    if (nums[k]==nums[k-1]&&k!=j+1) continue;
                    if (nums[i]+nums[j]+nums[k]==0)
                    {
                        list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list;
        Arrays.sort(nums);
        int len=nums.length;
        int j=0,k=len-1;
        for(int i=0;i<len-2;i++)
        {
            while (i!=0&&nums[i]==nums[i-1]&&i<len-1) i++;
            j=i+1;
            k=len-1;
            while(j<k)
            {
                if (nums[j]+nums[k]+nums[i]>0)
                {
                    do {
                        k--;
                    } while (nums[k]==nums[k+1]&&k>j);
                }else if(nums[j]+nums[k]+nums[i]<0)
                {
                    do {
                        j++;
                    } while (nums[j]==nums[j-1]&&j<k) ;
                } else{
                    list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                    do {
                        k--;
                    } while (nums[k]==nums[k+1]&&k>j);
                }
            }
        }
        return lists;
    }

    //跟我的思想一样，但是代码比我的优美，其实只需要再sum==0时去重就可以了，因为！=时，下一个也不会重复，只有==时才需要考虑重复的问题
    public static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

}
