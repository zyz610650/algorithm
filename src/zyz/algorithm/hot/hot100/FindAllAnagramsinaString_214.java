package zyz.algorithm.hot.hot100;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 除法求值
 * @seq: 399
 * @address: https://leetcode-cn.com/problems/evaluate-division/
 * @idea:
 *  会 	滑动窗口+数组即可
 *
 *  什么情况下会想到滑动窗口法：
 *
 * 任何题目如果没有思路其实都可以想一下暴力解法。这道题暴力解法思路简单：
 *
 * 遍历任意i，j，使得i和j之间的子串长度，等于p串的长度。该子串称之为x。该步复杂度为O（n）。
 * 判断x是否与p是异位词。是的话，则把i加入答案中。该步复杂度为O（n）。
 * 暴力法的复杂度为O（n^2）。显然不高效。
 *
 * 可以发现第二步其实做了很多不必要的操作，例如[i, j]和[i+1, j+1]两个子串在暴力法第二步中，需要各遍历一次，完全没必要。其实[i+1, j+1]完全可以在[i, j]的基础上做判断，也就是去掉头部的字符（i位置），加上尾部的字符（j+1位置）。这样第一步的复杂度可以降到O(1)。整体复杂度降到O(n)。已经得到信息不重复使用就浪费了，没必要重新搜集近乎相同的信息。这就是滑动窗口法。
 *
 * 滑动窗口法的特点是，一连串元素的信息，可以用常数时间推断出，该串整体移位后，新串信息。
 *
 * 所有滑动窗口问题，如果能从暴力法优化的角度思考，都不难想到。
 *
 * refs :
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/438-zhao-dao-zi-fu-chuan-zhong-suo-you-z-nx6b/
 */
public class FindAllAnagramsinaString_214 {
	public static void main (String[] args) {
		String  s = "cbaebabacd", p = "abc";
		System.out.println (findAnagrams (s,p));
		String arr=new String ();
		StringBuilder sb=new StringBuilder ();
		String str=new String ("a");
		sb.toString ();
	}
	// 暴力
	public static List <Integer> findAnagrams(String s, String p) {
		List<Integer> list=new ArrayList <> ();
		if(p.length()>s.length()) return list;
		int pl=p.length();
		char[] arr=p.toCharArray();
		Arrays.sort(arr);
		for(int i=0;i<s.length()-pl+1;i++)
		{
			char[] tmp=s.substring(i,i+pl).toCharArray();
			Arrays.sort(tmp);
			if(Arrays.equals(arr,tmp)) list.add(i);
		}
		return list;
	}


	//滑动窗口+数组
	public static List <Integer> findAnagrams1(String s, String p) {
		List<Integer> list=new ArrayList <> ();
		if(p.length()>s.length()) return list;
		int pl=p.length();
		int sl=s.length();
		int[] sarr=new int[26];
		int[] parr=new int[26];
		for(int i=0;i<pl;i++)
		{
			parr[p.charAt(i)-'a']++;
			sarr[s.charAt(i)-'a']++;
		}
		if(Arrays.equals(parr,sarr)) list.add(0);
		for(int i=pl;i<sl;i++)
		{
			sarr[s.charAt(i)-'a']++;
			sarr[s.charAt(i-pl)-'a']--;
			if(Arrays.equals(parr,sarr)) list.add(i-pl+1);
		}

		return list;
	}


}
