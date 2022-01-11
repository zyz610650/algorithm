package zyz.algorithm.hot.top;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 350. 两个数组的交集 II
 * @seq: 350
 * @address: https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 * @idea:
 */
public class T350_321 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list=new ArrayList<>();
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;)
        {
            if(nums1[i]==nums2[j])
            {
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j])
                j++;
            else i++;
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=list.get(i);
        }
        return arr;
    }
}
