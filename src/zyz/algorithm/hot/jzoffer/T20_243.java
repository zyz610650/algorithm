package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 20. 表示数值的字符串
 * @seq: 20
 * @address: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * @idea:
 */
public class T20_243 {
	static int index;

	public static void main (String[] args) {
		String s="0";
		System.out.println (isNumber (s));
	}
	public static boolean isNumber(String s) {
		String str=s.trim();
		str=str+"|";
		if(str==null||str.length()==0) return false;

		index=0;
		boolean isNum=scanInteger(str);
		char ch=str.charAt(index);
		if(ch=='.')
		{
			index++;
			isNum=scanUnsignInteger(str)||isNum;
		}
		ch=str.charAt(index);
		if(ch=='E'||ch=='e')
		{
			index++;
			isNum=scanInteger(str)&&isNum;
		}
		return isNum&&str.charAt(index)=='|';

	}

	public static boolean scanInteger(String str)
	{
		char ch=str.charAt(index);

		if(ch=='+'||ch=='-') index++;
		return scanUnsignInteger(str);
	}
	public static boolean scanUnsignInteger(String str)
	{
		int begin=index;
		for(;index<str.length();)
		{
			char ch=str.charAt(index);
			if(ch>='0'&&ch<='9') index++;
			else break;
		}
		return begin<index;
	}
}
