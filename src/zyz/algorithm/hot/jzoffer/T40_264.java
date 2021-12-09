package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zyz
 * @title: 剑指 Offer 40. 最小的k个数
 * @seq: 40
 * @address: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * @idea:
 *
 */
public class T40_264 {

	public int[] getLeastNumbers1(int[] arr, int k) {
		PriorityQueue <Integer> queue=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++)
		{
			queue.add(arr[i]);
		}
		int[] ans=new int[k];
		for(int i=0;i<k;i++)
		{
			ans[i]=queue.poll();
		}

		return ans;
	}

	public int[] getLeastNumbers(int[] arr, int k) {
		if(k>=arr.length) return arr;
		return quicksort(arr,0,arr.length-1,k);
	}

	public int[] quicksort(int[] arr,int l,int h,int k)
	{
		int i=l,j=h;
		while(i<j)
		{
			while(j>i&&arr[j]>=arr[l]) j--;
			while(j>i&&arr[i]<=arr[l]) i++;
			swap(arr,i,j);
		}
		swap(arr,l,i);
		if(i>k) return quicksort(arr,l,i-1,k);
		if(i<k) return quicksort(arr,i+1,h,k);
		return Arrays.copyOf(arr,k);
	}

	public void swap(int[] arr,int i,int j)
	{
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
