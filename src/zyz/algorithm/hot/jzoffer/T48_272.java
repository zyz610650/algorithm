package zyz.algorithm.hot.jzoffer;

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
		System.out.println (lengthOfLongestSubstring(str));
	}
	public static int lengthOfLongestSubstring(String s) {
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
}
