package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 46. 把数字翻译成字符串
 * @seq: 46
 * @address: https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * @idea:
 *
 */
public class T46_270 {

	public static void main (String[] args) {
		System.out.println ("25".compareTo ("9"));
		System.out.println (translateNum(25));
	}
	int n=0;
	public static int translateNum(int num) {
		int a=1,b=1;
		String str=String.valueOf(num);
		for(int i=2;i<=str.length();i++)
		{
			String n=str.substring(i-2,i);
			if(n.compareTo("25")<=0&&n.compareTo("10")>=0)
			{
				int tmp=a+b;
				a=b;b=tmp;
			}else{
				a=b;
			}

		}
		return b;
	}

	public int translateNum2(int num) {
		int a=1,b=1,c;
		while(num>0)
		{
			int res=num%100;
			num=num/10;
			if(res<=25&&res>9)
			{
				c=a+b;
				a=b;
				b=c;
			}else{
				a=b;
			}
		}
		return b;
	}


	public int translateNum1(int num) {
		n=0;
		char[] ch=(num+"").toCharArray();
		f1(ch,0);
		return n;
	}
	public void f1(char[] chs,int i)
	{
		if(i==chs.length)
		{
			n++;
			return;
		}
		f1(chs,i+1);
		if(i>=chs.length-1) return;
		StringBuilder sb=new StringBuilder();
		String s2=sb.append(chs[i]).append(chs[i+1]).toString();
		if(Integer.valueOf(s2)<=25&&chs[i]!='0') f1(chs,i+2);
	}
}
