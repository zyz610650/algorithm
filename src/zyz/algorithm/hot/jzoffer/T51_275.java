package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 51. 数组中的逆序对
 * @seq: 51
 * @address: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * @idea:
 *
 */
public class T51_275 {

	public int reversePairs(int[] nums) {

		return mergeSort(nums,0,nums.length-1);
	}

	public int mergeSort(int[] nums,int left,int right)
	{
		if(left>=right) return 0;
		int mid=left+((right-left)>>1);
		int l=mergeSort(nums,left,mid);
		int r=mergeSort(nums,mid+1,right);
		return merge(nums,left,mid,right)+l+r;
	}

	public int merge(int[] nums,int left,int mid,int right)
	{
		int[] tmp=new int[right-left+1];
		int i=left,j=mid+1;
		int index=0;
		int cnt=0;
		while(i<=mid&&j<=right)
		{
			if(nums[i]<=nums[j])
			{
				tmp[index++]=nums[i++];
			}else{
				cnt+=(mid-i+1);
				tmp[index++]=nums[j++];
			}
		}
		while(i<=mid)
		{
			tmp[index++]=nums[i++];
		}
		while(j<=right)
		{
			tmp[index++]=nums[j++];
		}
		for(int k=0;k<index;k++)
		{
			nums[left++]=tmp[k];
		}
		return cnt;
	}
}
