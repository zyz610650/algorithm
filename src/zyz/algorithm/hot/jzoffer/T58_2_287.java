package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 58 - II. 左旋转字符串
 * @seq: 58_2
 * @address: https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * @idea:
 *
 */
public class T58_2_287 {

	public String reverseLeftWords(String s, int n) {
		String str1=s.substring(0,n);
		String str2=s.substring(n);
		return str2+str1;
	}
}
