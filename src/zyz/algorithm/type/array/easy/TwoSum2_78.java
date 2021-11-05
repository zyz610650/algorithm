package zyz.algorithm.type.array.easy;

/**
 * @author zyz
 * @title: 两数之和 II - 输入有序数组
 * @seq: 167
 * @address: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 * @idea:
 */
public class TwoSum2_78 {
    public int[] twoSum(int[] numbers, int target) {
        int n=numbers.length;
        int left=0,right=n-1;
        int[] arr=new int[2];
        while(left<right)
        {
            if(numbers[left]+numbers[right]==target)
            {

                arr[0]=left+1;
                arr[1]=right+1;
                return arr;
            }
            if(numbers[left]+numbers[right]<target) left++;
            else right--;
        }
        return arr;
    }
}
