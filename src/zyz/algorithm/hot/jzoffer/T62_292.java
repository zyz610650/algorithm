package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 62. 圆圈中最后剩下的数字
 * @seq: 62
 * @address: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * @idea:
 *
 * 最后一层循环第m个数的位置 一定为0
 * 最后只剩下一个元素，假设这个最后存活的元素为 num, 这个元素最终的的下标一定是0 （因为最后只剩这一个元素）
 *
 * 问题1： 假设我们已经知道11个人时，胜利者的下标位置为6。那下一轮10个人时，胜利者的下标位置为多少？
 * 答： 其实吧，第一轮删掉编号为3的人后，之后的人都往前面移动了3位，胜利这也往前移动了3位，所以他的下标位置由6变成3。
 * 每杀死一个人，整体往前移动m个数是为了假设下一次开始数m个数是从0开始
 *
 * f(11,3)=6
 * 假设最后存活下来的人在第一轮的坐标为6,杀掉第3个人(i=2)的人，杀掉后下一次从i=3的位置开始计数下一轮，这时候还剩10个人，这时候如果想从0计算最后存活下来的人的坐标，就得从把下一轮开始计数位置(也就是i=3)那个位置的坐标向左移动3，这时候整体向左移3，最后存活下来的坐标也就变成了3，也会是10个人的时候坐标变成了3
 * https://blog.csdn.net/u011500062/article/details/72855826
 *
 */
public class T62_292 {


	public int lastRemaining(int n, int m) {
		int index=0;
		for(int i=2;i<=n;i++)
		{
			index=(index+m)%i;
		}
		return index;

	}
	public int f(int n,int m)
	{
		if(n==1) return 0;
		int x=f(n-1,m);
		return (m+x)%n;
	}
}
