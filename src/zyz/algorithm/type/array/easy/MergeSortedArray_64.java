package zyz.algorithm.type.array.easy;

/**
 * @author zyz
 * @title: 合并两个有序数组
 * @seq: 88
 * @address: https://leetcode-cn.com/problems/merge-sorted-array/
 * @idea:
 */
public class MergeSortedArray_64 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1,m,nums2,n);
    }
    //需要会这个方法
    public static  void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1,j=n-1,tail=m+n-1;
        while(i>=0&&j>=0) nums1[tail--]=nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
        while(j>0) nums1[tail--]=nums2[j--];

    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        while(i<m&&j<n)
        {
            if(nums1[i]>nums2[j])
            {
                for(int k=m;k>i;k--)
                {
                    nums1[k]=nums1[k-1];
                }
                m++;
                nums1[i]=nums2[j++];
            }
            i++;
        }
        while(j<n)
        {
            nums1[i++]=nums2[j++];
        }
    }
}
