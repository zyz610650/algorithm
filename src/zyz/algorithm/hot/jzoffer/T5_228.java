package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 05. 替换空格
 * @seq: 5
 * @address: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @idea:
 */
public class T5_228 {

	public String replaceSpace(String s) {
		// return s.replaceAll(" ","%20");
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
			{
				sb.append("%20");
			}else{
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
