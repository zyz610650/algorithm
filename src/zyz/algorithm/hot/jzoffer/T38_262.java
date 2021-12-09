package zyz.algorithm.hot.jzoffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zyz
 * @title: 剑指 Offer 38. 字符串的排列
 * @seq: 38
 * @address: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * @idea:
 *  直接对String操作速度比较慢,尽量避免 比如用char[]数组来代替直接对String类型的操作
 */
public class T38_262 {

	Set <String> set;
	public String[] permutation1(String s) {
		set=new HashSet <> ();
		boolean[] flag=new boolean[s.length()];
		dfs1(s,0,"",flag);
		String[] arr=set.toArray (new String[0]);
		return arr;
	}

	void dfs1(String s,int index,String str,boolean[] flag)
	{
		if(index==s.length())
		{
			set.add(str);
			return;
		}
		for(int i=0;i<s.length();i++)
		{
			if(flag[i]) continue;
			flag[i]=true;
			dfs1(s,index+1,str+s.charAt(i),flag);
			flag[i]=false;
		}
	}


	public String[] permutation(String s) {
		set=new HashSet<>();
		boolean[] flag=new boolean[s.length()];
		dfs(s,0,new StringBuilder (),flag);
		String[] arr=set.toArray (new String[0]);
		return arr;
	}

	void dfs(String s,int index,StringBuilder str,boolean[] flag)
	{
		if(index==s.length())
		{
			set.add(str.toString ());
			return;
		}
		for(int i=0;i<s.length();i++)
		{
			if(flag[i]) continue;
			flag[i]=true;
			str.append(s.charAt(i));
			dfs(s,index+1,str,flag);
			str.deleteCharAt (str.length ()-1);
			flag[i]=false;
		}
	}
}
