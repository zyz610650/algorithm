package zyz.algorithm.CharacterString.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 同构字符串
 * @seq: 205
 * @address: https://leetcode-cn.com/problems/isomorphic-strings/
 * @idea:
 */
class IsorphicStrings_134 {
	public static void main (String[] args) {
		String s ="paper" ,t="title";
		System.out.println (isIsomorphic(s,t));
	}


	public static boolean isIsomorphic(String s, String t) {
		if (s.length ()!=t.length ()) return false;
		Map <Character,Character> map=new HashMap <> ();
		Map <Character,Character> map1=new HashMap <> ();
		for(int i=0;i<s.length();i++)
		{
			char ch1=s.charAt(i);
			char ch2=t.charAt(i);
			Character t1=map.get (ch1);
			Character t2=map1.get (ch2);
			if((t1==null||t1==ch2)&&(t2==null||t2==ch1))
			{
				map.put (ch1,ch2);
				map1.put (ch2,ch1);
			}
			else return false;
		}
		return true;
	}
}
