package zyz.algorithm.hot.jzoffer;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 剑指 Offer 17. 打印从1到最大的n位数
 * @seq: 17
 * @address: https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * @idea:
 */
public class T17_240 {
	int[] arr;
	int cnt=0;

	/**
	 * 大数求法
	 * @param n
	 * @return
	 */
	public int[] printNumbers(int n) {
		arr=new int[(int)(Math.pow (10,n))-1];
		cnt=0;

		String str;
		for(int i=1;i<=9;i++)
		{
			str=i+"";
			dfs(1,n,str);
		}
		Arrays.sort(arr);
		return arr;
	}

	public void dfs(int index,int n,String str)
	{
		arr[cnt++]=Integer.valueOf(str);
		if(index==n)
		{
			return;
		}
		for(int i=0;i<=9;i++)
		{
			dfs(index+1,n,str+i);
		}
	}
	public int[] printNumbers1(int n) {

		int res=1;
		int q=0;
		res=0;
		while(n>0)
		{
			res=res*10+9;
			n--;
		}
		int[] arr=new int[res];
		for(int i=1;i<=res;i++) arr[i-1]=i;
		return arr;
	}
}
