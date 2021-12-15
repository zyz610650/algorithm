package zyz.algorithm.hot.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: @zyz
 */
public class T48_272 {

	public static void main (String[] args) {
		String str="aabaab!bb";

		System.out.println (	str.indexOf ("aa"));
		System.out.println (str);
		char ch='1';
		System.out.println (str+ch);
		System.out.println (lengthOfLongestSubstring1(str));
	}
	public static int lengthOfLongestSubstring1(String s) {
		int max=0;
		String str="";
		for(int i=0;i<s.length();i++)
		{
			char ch=s.charAt(i);
			int index=str.indexOf(ch);
			if(index!=-1)
			{
				str=str.substring(index+1,str.length());
				str+=ch;
			}else{
				str+=ch;
				max=Math.max(max,str.length ());
			}
		}
		return max;
	}


	/**
	 * dp
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		int n=s.length();
		Map <Character,Integer> map=new HashMap <> ();
		int max=0;
		int tmp=0;
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			int index=map.getOrDefault(ch,-1);
			map.put(ch,i);
			tmp=(i-index)>tmp?tmp+1:i-index;
			max=Math.max(max,tmp);
		}
		return max;
	}

}
