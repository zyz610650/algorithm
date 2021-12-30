package zyz.algorithm.hot.txtop50;

/**
 * @author zyz
 * @title: 344. 反转字符串
 * @seq: 344
 * @address: https://leetcode-cn.com/problems/reverse-string/
 * @idea:
 */
public class T344_305 {

	public void reverseString(char[] s) {
		int len=s.length;
		for(int i=0;i<len/2;i++)
		{
			char ch=s[i];
			s[i]=s[len-i-1];
			s[len-i-1]=ch;
		}

	}
}
