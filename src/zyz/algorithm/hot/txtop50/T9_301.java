package zyz.algorithm.hot.txtop50;

/**
 * @author zyz
 * @title: 9. 回文数
 * @seq: 9
 * @address: https://leetcode-cn.com/problems/palindrome-number/
 * @idea:
 */
public class T9_301 {

	public boolean isPalindrome(int x) {
		if(x<0) return false;
		String str=x+"";
		int low=0,high=str.length()-1;
		while(low<high)
		{
			if(str.charAt(low)!=str.charAt(high)) return false;
			low++;
			high--;
		}
		return true;
	}
}
