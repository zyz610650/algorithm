package zyz.algorithm.array.easy;

import java.nio.file.Path;
import java.util.*;

/**
 * @author zyz
 * @date 2021-06-21
 * @title: 两数之和
 * @seq: 01
 * @address: https://leetcode-cn.com/problems/two-sum/
 */


public class two_sum_01 {

    public static void main(String[] args) {

        int []nums = {3,2,4};
        int target = 6;
        int[] res;
        res=twoSum1(nums,target);
        System.out.println(res[0]+"  "+res[1]);
    }


    //这个方法不太行
    public static int[] twoSum0(int[] nums,int target)
    {
        Arrays.sort(nums);
        int[] res=new int[2];
         for (int i=0;i<nums.length;i++)
         {
             int index=binarySearch(nums,target-nums[i],i+1,nums.length-1);
             if (index!=-1)
             {
                 res[0]=i;
                 res[1]=index;
                 return res;
             }
         }

        return null;
    }

    public static int binarySearch(int[] array,int value,int low,int high)
    {
        int mid;
        int midVal;
        while(low<=high)
        {
             mid=(low+high)/2;
             midVal=array[mid];
             if (midVal<value)
             {
                 low=mid+1;
             }else if (midVal>value)
             {
                 high=mid-1;
             } else return mid;

        }
        return -1;
    }

    //Hash映射 注意hash映射时Key重复的问题
    public static int[] twoSum1(int[] nums,int target)
    {
        int[] res=new int[2];
        int tmp;
        Map<Integer, List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            tmp=target-nums[i];
            if (map.containsKey(tmp))
            {
                List list=map.get(tmp);
                res[0]=i;
                res[1]= (Integer) list.get(0);
                break;
            }
            List<Integer> list=new ArrayList<>();
            list.add(i);
            map.put(nums[i],list);
        }
        return res;
    }

    /**
     * 排序+双指针搜索  这里需要注意1>这里的这个搜索算法 2>排序后Index就变了，所以自己上面写的那个不太行，就是因为下标变了 返回的不是原下标
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int m=0,n=0,k,board=0;
        int[] res=new int[2];
        int[] tmp1=new int[nums.length];
        System.arraycopy(nums,0,tmp1,0,nums.length);
        Arrays.sort(nums);
        for(int i=0,j=nums.length-1;i<j;){
            if(nums[i]+nums[j]<target)
                i++;
            else if(nums[i]+nums[j]>target)
                j--;
            else if(nums[i]+nums[j]==target){
                m=i;
                n=j;
                break;
            }
        }
        for(k=0;k<nums.length;k++){
            if(tmp1[k]==nums[m]){
                res[0]=k;
                break;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(tmp1[i]==nums[n]&&i!=k)
                res[1]=i;
        }
        return res;
    }


}

