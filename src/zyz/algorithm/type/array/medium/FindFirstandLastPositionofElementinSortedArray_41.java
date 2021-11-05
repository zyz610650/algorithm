package zyz.algorithm.type.array.medium;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 在排序数组中查找元素的第一个和最后一个位置
 * @seq: 34
 * @address: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @idea:
 */
public class FindFirstandLastPositionofElementinSortedArray_41 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,8,10};
        int target =8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
       int[] arr=new int[2];
        int n=nums.length;
        arr[0]=arr[1]=-1;
        binarySearch(nums,target,0,n-1,arr);
        return arr;
    }
    public static void binarySearch(int[] nums,int target,int low,int high,int[] arr)
    {
        int mid;
        while(low<=high)
        {
            mid=(low+high)/2;
            if(nums[mid]==target)
            {
                arr[0]=arr[0]==-1?mid:Math.min(arr[0],mid);
                arr[1]=Math.max(arr[1],mid);
                binarySearch(nums,target,low,mid-1,arr);
                binarySearch(nums,target,mid+1,high,arr);
                return;
            }
            if(target<nums[mid]) high=mid-1;
            else low=mid+1;
        }
    }


    // 寻找左边第一个边界 和右边最后一个边界 没我的方法好
    public int[] searchRange1(int[] nums, int target) {
        int left = left_bound(nums, target);
        int right =  right_bound(nums, target);
        int[] a = {left,right};
        return a;
    }
    //寻找左边第一个等于target的值
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {

                // 别返回，锁定左侧边界
                right = mid - 1;

                // nums[mid] == target时  确定了mid可能是一个边界 这时候从 left->mid-1找下一个nums[mid] == target
                //找不到时 最后可能会出现nums[right]!=target and  left=right+1   nums[left] == target的情况
                // 所以 left >= nums.length || nums[left] != target 说明Nums里面没有target
            }
        }

        // 最后要检查 left 越界的情况  最后结束时一定有right=left+1 and  nums[right]!=target

        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }


    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 别返回，锁定右侧边界
                left = mid + 1;
                //最后 left=right+1   这样right最后就是 等于target的下标了  跟上面同理
            }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

}
