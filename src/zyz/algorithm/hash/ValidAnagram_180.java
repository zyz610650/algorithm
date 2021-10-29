package zyz.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 有效的字母异位词
 * @seq: 242
 * @address: https://leetcode-cn.com/problems/valid-anagram/
 * @idea:
 */
public class ValidAnagram_180 {

	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length()) return false;
		Map <Character,Integer> map=new HashMap <> ();
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt (i);
			map.put(c,map.getOrDefault(c,0)+1);
		}

		for(int i=0;i<t.length();i++)
		{
			char ch=t.charAt(i);
			Integer k=map.get(ch);
			if(k==null||k<1) return false;
			map.put(ch,k-1);
		}
		return true;
	}
}
