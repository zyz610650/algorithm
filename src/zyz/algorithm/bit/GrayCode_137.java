package zyz.algorithm.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 格雷编码
 * @seq: 89
 * @address: https://leetcode-cn.com/problems/gray-code/
 * @idea:
 */


public class GrayCode_137 {

	public static void main (String[] args) {
		int n=2;
		System.out.println (grayCode (n));
	}
	static List <Integer> list=new ArrayList <> ();

	public static  List<Integer> grayCode(int n) {
		if(n==0)
		{
			list.add(0);
			return list;
		}
		int a=0;
		int t=0;
		dfs(n,1,a,true);
		a=a|1;
		dfs(n,1,a,false);
		return list;
	}

	static void dfs(int n,int t,int a,boolean flag)
	{
		if(n==t)
		{
			list.add(a);
			return ;
		}
		a=a<<1;
		a=a&(1<<n-1);
		if (flag)
		{
			dfs(n,t+1,a,true);
			dfs(n,t+1,a|1,false);
		}else{
			dfs(n,t+1,a|1,true);
			dfs(n,t+1,a,false);
		}
	}

//	static List<Integer> res = new ArrayList<>();
//	public static List<Integer> grayCode(int n) {
//		backtrace(n,new StringBuffer(),new int[]{0,1});
//		return res;
//	}
//	public static void backtrace(int n, StringBuffer sb, int[] nums){
//		//判断条件，是否返回
//		if(sb.length() == n){
//			// 二进制转换为十进制
//			res.add(Integer.valueOf(sb.toString(),2));
//			return;
//		}
//		// 回溯第一个状态
//		sb.append(nums[0]);
//		//注意数组
//		backtrace(n,sb,new int[]{0,1});
//		sb.deleteCharAt(sb.length()-1);
//		// 回溯第二个状态
//		sb.append(nums[1]);
//		//注意数组
//		backtrace(n,sb,new int[]{1,0});
//		sb.deleteCharAt(sb.length()-1);
//	}


}
