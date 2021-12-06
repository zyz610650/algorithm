package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * @seq: 32
 * @address: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @idea:
 */
public class T34_257 {
	public boolean verifyPostorder(int[] postorder) {
		return dfs(0,postorder.length-1,postorder);
	}
	public boolean dfs(int i,int j,int[] postorder)
	{
		if(i>=j) return true;
		int m=0;
		int p=i;
		while(postorder[p]<postorder[j]) p++;
		m=p;
		while(postorder[p]>postorder[j]) p++;
		return p==j&&dfs(i,m-1,postorder)&&dfs(m,j-1,postorder);

	}
}
