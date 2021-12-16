package zyz.algorithm.hot.jzoffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 剑指 Offer 50. 第一个只出现一次的字符
 * @seq: 50
 * @address: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @idea:
 *
 */
public class T50_274 {

	public char firstUniqChar(String s) {
		Map<Character,Integer> map=new LinkedHashMap<>();
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			int index=map.getOrDefault(ch,0);
			map.put(ch,index+1);
		}
		for(Map.Entry <Character,Integer> entry:map.entrySet())
		{
			if(entry.getValue ()==1) return entry.getKey ();
		}
		return ' ';
	}
}
