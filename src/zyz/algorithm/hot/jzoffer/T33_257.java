package zyz.algorithm.hot.jzoffer;

/**
 * @author zyz
 * @title: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * @seq: 33
 * @address: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @idea:
 */
public class T33_257 {
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
