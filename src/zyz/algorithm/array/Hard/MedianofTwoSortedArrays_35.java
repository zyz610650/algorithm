package zyz.algorithm.array.Hard;

import java.awt.print.PrinterJob;
import java.util.Arrays;
import java.util.Arrays;

/**
 * @author zyz
 * @title: 寻找两个正序数组的中位数
 * @seq: 04
 * @address: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * @idea:
 *
 *  这道题比较好 其中二分法是求第k小数的模板 需要再做
 *
 */
public class MedianofTwoSortedArrays_35 {

    public static void main(String[] args) {

       int[] nums1 = {1,3}, nums2 = {2};
        System.out.println(findMedianSortedArrays3(nums1,nums2));



    }


    //方法一 合并数组 时间复杂度大 时间复杂度：遍历全部数组 (m+n)(m+n) 空间复杂度：开辟了一个数组，保存合并后的两个数组 O(m+n)O(m+n)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int i=0,j=0,t=0;
       int[] nums=new int[m+n];
       while (i<m&&j<n)
       {
           if (nums1[i]<nums2[j]) nums[t++]=nums1[i++];
           else nums[t++]=nums2[j++];
       }
       while (i<m)
       {
           nums[t++]=nums1[i++];
       }
        while (j<n)
        {
            nums[t++]=nums2[j++];
        }
//        System.out.println(nums[t/2]);
//        System.out.println(nums[t/2-1]);
//       System.out.println(nums1rrays.toString(nums));
        if (t%2!=0) return nums[t/2];
        else  return (nums[t/2]+nums[t/2-1])/2.0;

    }

    // 方法二: 双指针 时间复杂度：遍历 len/2+1 次，len=m+n，所以时间复杂度依旧是 O(m+n)O(m+n)。 总共 8 个变量，所以空间复杂度是 O(1）O(1）。
    // 主要的思路是 找到第len/2个数  若是奇数个数 则中位数是 第len/2 否则是 len/2和len/2-1的和÷2
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        boolean f1=true,f2=true;//f1 true x是 nums1 false  x是nums2
        int left=0,right=0,x=0,y=0;

       for(int i=0;i<=(m+n)/2;i++)
       {
           right=left;
           if (x<m&&y<n)
           {
               if (nums1[x]<=nums2[y]) left=nums1[x++];
               else left=nums2[y++];
           }
           else if(x<m){
               left=nums1[x++];
           }else {
               left=nums2[y++];
           }
       }
       if (((m+n)&1)==0) return  (left+right)/2.0;
       else return left>right?left:right;


    }
    //它这个也是双指针 但是细节的处理比我的巧妙
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) { //这点处理比较巧妙
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }


    //方法三 二分法 最优 是求两个数组中第k小数的模板
    // 这个方法主要考虑的是 要找到第 kk 个元素，我们可以比较 \text{nums1}[k/2-1]nums1[k/2−1]
    // 和 \text{nums2}[k/2-1]nums2[k/2−1]，其中 // 表示整数除法。由于 {nums1}[k/2-1]nums1[k/2−1] 和 {nums2}[k/2-1]nums2[k/2−1] 的前面分别有 \text{nums1}[0\,..\,k/2-2]nums1[0..k/2−2] 和 \text{nums2}[0\,..\,k/2-2]nums2[0..k/2−2]，即 k/2-1k/2−1 个元素，对于 \text{nums1}[k/2-1]nums1[k/2−1] 和 \text{nums2}[k/2-1]nums2[k/2−1] 中的较小值，最多只会有 (k/2-1)+(k/2-1) \leq k-2(k/2−1)+(k/2−1)≤k−2 个元素比它小，那么它就不能是第 kk 小的数了。
    //  若 nums1[k/2−1]>nums2[k/2−1] nums1的前k/2-1个数和nums2的前k/2-1个数 一定没有第k/2小的数，因为 (k/2−1)+(k/2−1)+1(这个1是nums2[k/2−1])≤k−2+1个元素比nums1[k/2−1]小，
    // 这时候nums2[k/2−1]一定不是第k/2小的数，因为上面一定有 nums1[k/2−1]比它大，二 nums1[k/2−2]和nums2[k/2−1]的大小关系不知道
    // 若nums1[k/2−2]>nums2[k/2−1] 则nums1[k/2−2]也有可能是第k/2大的数，所以只去除nums2的前k/2-1个数
    //同理nums1[k/2−3] nums1[k/2−4] ..也都有可能 只要比nums2[k/2−1]都有可能
    //
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        if ((len&1)==1)
        {
            //第 len/2+1个数 len/2+1不是下标
            return getElem(nums1,nums2,len/2+1);
        }else {
            System.out.println(2);
            return (getElem(nums1,nums2,len/2)+getElem(nums1,nums2,len/2+1))/2.0;
        }
    }

    public static int getElem(int[] nums1,int[] nums2,int k)
    {
        int m=nums1.length,n=nums2.length;
        int index1=0,index2=0;
        int half,newIndex1,newIndex2;
        while (true)
        {
            if (index1==m) return nums2[index2+k-1];
            if (index2==n) return nums1[index1+k-1];
            if (k==1) return Math.min(nums1[index1],nums2[index2]);

            half=k/2;
            newIndex1=Math.min(index1+half-1,m-1);
            newIndex2=Math.min(index2+half-1,n-1);
            if (nums1[newIndex1]>=nums2[newIndex2])
            {
                k-=(newIndex2-index2+1);
                index2=newIndex2+1;
            }
            else {
                k-=(newIndex1-index1+1);
                index1=newIndex1+1;
            }
        }

    }
}

