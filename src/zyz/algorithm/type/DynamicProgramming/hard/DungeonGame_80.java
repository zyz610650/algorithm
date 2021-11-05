package zyz.algorithm.type.DynamicProgramming.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zyz
 * @title: 地下城游戏
 * @seq: 174
 * @address: https://leetcode-cn.com/problems/dungeon-game/
 * @idea:
 *  DFS和BFS时间复杂度一致 以后能用DFS就不用BFS 都是O(n^2)
 *  DFS算法是一一个递归算法，需要借助一个递归工作栈，故它的空间复杂度为O ( N ) O(N)O(N)。
 * 遍历图的过程实质上是对每个顶点查找其邻接点的过程，其耗费的时间取决于所采用结构。
 *
 * 邻接表表示时，查找所有顶点的邻接点所需时间为O ( E ) O(E)O(E)，访问顶点的邻接点所花时间为O ( N ) O(N)O(N),此时，总的时间复杂度为O ( N + E ) O(N+E)O(N+E)。
 *
 * 邻接矩阵表示时，查找每个顶点的邻接点所需时间为O ( N ) O(N)O(N)，要查找整个矩阵，故总的时间度为O ( N 2 ) O(N^2)O(N
 * 2
 *
 *  时间复杂度和空间复杂度都是O(n) 一个需要一个栈 一个需要一个队列
 */
public class DungeonGame_80 {
    static class Node{
        int i;
        int j;
        int n;//代表生命值
        int life;
        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public Node() {
        }

        public Node(int i, int j, int n, int life) {
            this.i = i;
            this.j = j;
            this.n = n;
            this.life = life;
        }

        public Node(int i, int j, int n) {
            this.i = i;
            this.j = j;
            this.n = n;
        }

    }

    public static void main(String[] args) {
     // int[][] dungeon= {{-2,-3,3},{-5,-10,1},{10,30,-5}};
      int[][] dungeon= {{0,-3}};
        System.out.println(calculateMinimumHP2(dungeon));
    }
    // BFS和DFS都可以解决 但是需要一个额外的数组记录之前的记录用于剪枝 否则超时
    // BFS写法
    public static int calculateMinimumHP(int[][] dungeon) {
        int ans=Integer.MAX_VALUE;

        if (dungeon.length<=1&&dungeon[0].length<=1)
        {
            return ans=dungeon[0][0]<0?-dungeon[0][0]+1:1;
        }
        int[][] memo=new int[dungeon.length][dungeon[0].length];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);
        int[] dx={1,0};
        int[] dy={0,1};
        int x,y,n,life;

        Queue<Node> queue=new LinkedList<>();
        Node node=new Node(0,0,dungeon[0][0],0);
        if (node.n<0) node.life=-node.n;
        memo[0][0]=node.life;
        Node newNode;
        queue.add(node);
        int tmp=0;
        while (!queue.isEmpty())
        {
            node=queue.poll();

            for (int i=0;i<2;i++)
            {
                x=node.i+dx[i];
                y=node.j+dy[i];
                if (x>=dungeon.length||y>=dungeon[0].length) continue;
                n=node.n+dungeon[x][y];

                tmp=node.n+node.life+dungeon[x][y];
                life=node.life;
                if (tmp<0)
                {
                    life=node.life-tmp;
                }
                if(memo[x][y]!=-1&&(life>=memo[x][y]||life>=ans)) continue;
                if (x==dungeon.length-1&&y==dungeon[0].length-1)
                {
                    ans=Math.min(ans,life);
                    continue;
                }
                memo[x][y]=life;
               queue.add(new Node(x,y,n,life));
            }
        }
        if (ans<0) ans=0;
        return ans+1;
    }


    // DP
    public static int calculateMinimumHP1(int[][] dungeon)
    {
        int m=dungeon.length,n=dungeon[0].length;
        int[][] dp=new int[m+1][n+1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n- 1] = dp[m - 1][n] = 1;
        for (int i=m-1;i>=0;i--)
        {
            for (int j=n-1;j>=0;j--)
            {
                dp[i][j]=Math.max(Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
//滚动数组优化
    public static int calculateMinimumHP2(int[][] dungeon)
    {
        int m=dungeon.length,n=dungeon[0].length;
        int[]dp=new int[n+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[n-1] = dp[n] = 1;
        for (int i=m-1;i>=0;i--)
        {
            for (int j=n-1;j>=0;j--)
            {
                int k=Math.min(dp[j],dp[j+1])-dungeon[i][j];
                dp[j]=Math.max(Math.min(dp[j],dp[j+1])-dungeon[i][j],1);
                if (i==m-1&&j==n-1) dp[n]=Integer.MAX_VALUE;
            }
        }
        return dp[0];
    }
}
