package zyz.algorithm.type.DynamicProgramming.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zyz
 * @title: 不同的二叉搜索树 II
 * @seq: 26
 * @address: https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * @idea:
 *
 */

class TreeNode{

    public TreeNode()
    {

    }
    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    int value;
    TreeNode left;
    TreeNode right;

}
public class UniqueBinarySearchTreesII_26 {


    public static void main(String[] args) {
       List<Integer> list=new ArrayList<>();
       list.add(null);
        System.out.println(list.size());
    }
    public List<TreeNode> generateTrees(int n) {

        return f(1,n);
    }
    public static List<TreeNode> f(int start,int end)
    {

        List<TreeNode> allNodes = new LinkedList<>();
        if (start>end)  {
            allNodes.add(null);
            return allNodes;
        }

        List<TreeNode> leftTress;
        List<TreeNode> rightTress;
        TreeNode node;
        for(int i=start;i<=end;++i)
        {
            leftTress=f(start,i-1);
            rightTress=f(i+1,end);
            
            for(int k=0;k<leftTress.size();++k)
            {
                for (int t=0;t<rightTress.size();++t)
                {
                    node=new TreeNode();
                    node.left=leftTress.get(k);
                    node.right=leftTress.get(t);
                    allNodes.add(node);
                }
            }

        }
        return allNodes;
    }

}
