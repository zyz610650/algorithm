package zyz.algorithm.hot.hot100;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zyz
 * @title: 删除无效的括号
 * @seq: 301
 * @address: https://leetcode-cn.com/problems/remove-invalid-parentheses/
 * @idea:
 */
public class RemoveInvalidParentheses_205 {
	static List <String> list=new ArrayList <> ();

	public static void main (String[] args) {
		String s = "()())()";
		System.out.println (removeInvalidParentheses (s));
	}

	//dfs
	public static List<String> removeInvalidParentheses(String s) {
		list.clear();
		int lc=0,rc=0;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='(') lc++;
			else if(s.charAt(i)==')'){
				if(lc==0) rc++;
				else lc--;
			}
		}

		dfs(s,0,lc,rc);
		return list;
	}

	public static void dfs(String str,int start,int lc,int rc)
	{
		if(lc==0&& rc==0 )
		{
			if(isValid(str)) list.add(str);
			return;
		}
		for(int i=start;i<str.length();i++)
		{
			if(i!=start && str.charAt(i) == str.charAt(i-1)) continue;
			if(lc+rc>str.length()-i) return;
			if(lc>0 &&str.charAt(i)=='(')
			{
				dfs(str.substring(0,i)+str.substring(i+1),i,lc-1,rc);
			}
			if(rc>0&&str.charAt(i)==')')
			{
				dfs(str.substring(0,i)+str.substring(i+1),i,lc,rc-1);
			}
		}

	}
	public static boolean isValid(String str)
	{
		int cnt=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(') cnt++;
			else if(str.charAt(i)==')'){
				cnt--;
				if(cnt<0) return false;
			}
		}
		return cnt==0;
	}

	/**
	 * bfs 我更觉得这就是枚举
	 * @param s
	 * @return
	 */
	public List<String> removeInvalidParentheses1(String s) {
		List<String> list=new ArrayList<>();
		Set <String> set=new HashSet <> ();

		set.add(s);

		while(true)
		{
			for(String str : set)
			{
				if(isValid(str)){
					list.add(str);
				}
			}
			if(list.size()>0) return list;
			Set<String> cntSet=new HashSet<>();
			for(String str: set)
			{
				for(int i=0;i<str.length();i++)
				{
					if(str.charAt(i)=='('||str.charAt(i)==')')
					{
						cntSet.add(str.substring(0,i)+str.substring(i+1));
					}
				}
			}
			set=cntSet;

		}

	}


}
