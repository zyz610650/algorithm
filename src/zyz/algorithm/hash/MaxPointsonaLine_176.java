package zyz.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zyz
 * @title: 直线上最多的点数
 * @seq: 149
 * @address: https://leetcode-cn.com/problems/max-points-on-a-line/
 * @idea:
 *  之前使用一个点来y/x求斜率判重是不对的，y/x相当于 y-0/x-0,因该是 y-y1/x-x1 确定一条线
 */
public class MaxPointsonaLine_176 {
	public static void main (String[] args) {
	int[][] points = {{7,3},{19,19},{-16,3},{13,17},{-18,1},{-18,-17},{13,-3},{3,7},{-11,12},{7,19},{19,-12},{20,-18},{-16,-15},{-10,-15},{-16,-18},{-14,-1},{18,10},{-13,8},{7,-5},{-4,-9},{-11,2},{-9,-9},{-5,-16},{10,14},{-3,4},{1,-20},{2,16},{0,14},{-14,5},{15,-11},{3,11},{11,-10},{-1,-7},{16,7},{1,-11},{-8,-3},{1,-6},{19,7},{3,6},{-1,-2},{7,-3},{-6,-8},{7,1},{-15,12},{-17,9},{19,-9},{1,0},{9,-10},{6,20},{-12,-4},{-16,-17},{14,3},{0,-1},{-18,9},{-15,15},{-3,-15},{-5,20},{15,-14},{9,-17},{10,-14},{-7,-11},{14,9},{1,-1},{15,12},{-5,-1},{-17,-5},{15,-2},{-12,11},{19,-18},{8,7},{-5,-3},{-17,-1},{-18,13},{15,-3},{4,18},{-14,-15},{15,8},{-18,-12},{-15,19},{-9,16},{-9,14},{-12,-14},{-2,-20},{-3,-13},{10,-7},{-2,-10},{9,10},{-1,7},{-17,-6},{-15,20},{5,-17},{6,-6},{-11,-8}};
		System.out.println (maxPoints(points));
	}

	public static int maxPoints(int[][] points) {

		int max=0;
		for(int i=0;i<points.length;i++)
		{
			Map <String,Integer> map=new HashMap <> ();
			int x=points[i][0],y=points[i][1];
			for(int j=i+1;j<points.length;j++)
			{
				int x0=points[j][0],y0=points[j][1];
				String key=gcd(x-x0,y-y0);
				map.put(key,map.getOrDefault(key,0)+1);
				max=Math.max(max,map.get(key));
			}

		}
		return max+1;
	}

	public static String gcd(int x,int y)
	{
		if(x==0) return x+"x";
		if(y==0) return y+"y";
		int tmp=0;
		int a=x,b=y;
		while(a!=0)
		{
			tmp=b%a;
			b=a;
			a=tmp;
		}
		return x/b+"@"+y/b;

	}
}
