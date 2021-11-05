package zyz.algorithm.type.DynamicProgramming.medium;

/**
 * @author zyz
 * @title: 不同的二叉搜索树
 * @seq: 25
 * @address: https://leetcode-cn.com/problems/unique-binary-search-trees/
 * @idea:
 *   这个题目的要求是中序序列为1.。。n有序的，只有二叉查找树的中序遍历是有序的
 *   二叉查找树的性质:
 *   它或者是一棵空树，或者是具有下列性质的二叉树：
 *   若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *   若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *   它的左、右子树也分别为二叉排序树。二叉搜索树作为一种经典的数据结构，它既有链表
 *
 *   该题就是问1-n能组成多少个二叉查找树
 *    特兰数问题中都会存在一种匹配关系，如进出栈匹配，括号匹配等，
 *    一旦计数问题中存在这种关系，那我们就需要去考虑这是否是卡特兰数问题。
 *    此外，我们还可以记住序列前四项：1, 1, 2, 5，这些将有利于我们联想到卡特兰数。
 *

 *   //卡特兰数Cn满足以下递推关系：
 *    Cn+1 = C0Cn + C1Cn-1 + ··· + CnC0
 *    因为C0=0 C1=1 这是固定的 所以C2可以根据C0 C1推出来 所以 C2 C3 ... Cn都是可是固定的
 *
 *    C0=1； Cn+1=(2*(2*n+1)/n+2)Cn
 */
public class UniqueBinarySearchTrees_25 {

    public static void main(String[] args) {
        int n=3;
        System.out.println(numTress1(n));
    }
    //DP
    public static int numTrees(int n) {

        int[] G =new int[n+1];
        G[0]=1;
        G[1]=1;
        // i代表长度为i 的序列 j代表以j为根
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                G[i]+=G[j-1]*G[i-j];
            }
        }
        for (int i=0;i<n;i++) System.out.print(G[i]+" ");
        return G[n];
    }
    //公式法
    public static long numTress1(int n)
    {

        long C = 1;
        for (int i = 0; i < n; ++i) {
           C=C *((2 * (2 * i + 1)) / (i + 2));     //错误
         C=C *(2 * (2 * i + 1)) / (i + 2);
        }


        return C;
    }
}
