package zyz.algorithm.array.easy;

import java.util.Arrays;



/**
 * @author zyz
 * @title: 移除元素
 * @seq: 08
 * @address: https://leetcode-cn.com/problems/remove-element/
 * @idea:
 *   吉大数据结构那本小绿书上思想， 也可用双指针
 */

//   [0,1,2,2,3,0,4,2]
public class removeElement_08 {
    public static void main(String[] args) {
        int[] nums={0,1,2,2,3,0,4,2};
        int n= removeElement(nums,0);
        System.out.println(Arrays.asList(nums).toString());
    }


    public static int removeElement(int[] nums, int val) {
        int k=0,tmp;
        for (int i=0;i<nums.length;i++)
        {
            if (nums[i]==val) k++;
            else{
                tmp=nums[i-k];
                nums[i-k]=nums[i];
                nums[i]=tmp;


            }
        }
        return nums.length-k;
    }
}
