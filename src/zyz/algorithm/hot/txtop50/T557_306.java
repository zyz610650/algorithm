package zyz.algorithm.hot.txtop50;

/**
 * @author: @zyz
 */
public class T557_306 {
	public String reverseWords(String s) {
		String[] strs=s.split (" ");

		StringBuilder sb=new StringBuilder();
		for(int i=0;i<strs.length-1;i++)
		{
			StringBuilder st=new StringBuilder(strs[i]);
			sb.append(st.reverse().toString()).append(" ");

		}
		StringBuilder st=new StringBuilder(strs[strs.length-1]);
		sb.append(st.reverse().toString());
		return sb.toString();
	}
}
