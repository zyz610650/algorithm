package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 67. 把字符串转换成整数
 * @seq: 67
 * @address: https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * @idea:
 *
 */
public class T67_297 {
	public static void main (String[] args) {
		System.out.println (Integer.MIN_VALUE);
		System.out.println (-Integer.MAX_VALUE);
	}
	public int strToInt(String str) {

		str=str.trim();
		if(str.length()==0) return 0;
		boolean flag=false;
		char ch;
		long res=0;
		int i=0;
		if(str.charAt(0)=='-')
		{
			flag=true;i++;
		}
		if(str.charAt(0)=='+')
		{
			i++;
		}
		for( ;i<str.length();i++)
		{
			ch=str.charAt(i);
			if(ch>='0'&&ch<='9')
			{
				res=res*10+ch-'0';
			}else break;
			if(res>Integer.MAX_VALUE) break;
		}
		if(res>Integer.MAX_VALUE)
		{
			if(flag) return Integer.MIN_VALUE;
			else return Integer.MAX_VALUE;
		}
		if(flag) res*=-1;
		return (int)res;
	}
}
