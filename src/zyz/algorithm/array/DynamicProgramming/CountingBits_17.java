package zyz.algorithm.array.DynamicProgramming;

/**
 * @author zyz
 * @title: 比特位计数
 * @seq: 17
 * @address: https://leetcode-cn.com/problems/counting-bits/
 * @idea:
 *  偶数的二进制最后一位为0 奇数的二进制最后一位为1
 *   n-1的二进制+1=n的二进制 n的二进制比n-1的二进制多一个1
 *   x=x & (x−1)，该运算将 xx 的二进制表示的最后一个 1 变成 0
 *   如 6：0110 & 5：0101 =010 2    2： 010 & 1：0001 =0000
 *   n>>1==n/2
 * 输出二进制
 * void Fun(int num)
 * {
 * if(num ==1 || num == 0) //等于0 或是 1时,直接输出
 * {
 * printf("%d",num);
 * }
 * else
 * {
 * while(num/2>0)
 * {
 * printf("%d",num%2); //取余
 * num = num/2; //取整
 * }
 * }
 * }
 */
public class CountingBits_17 {
    public static void main(String[] args) {

        System.out.println(2/2==0?0:1);
    }

    /**
     * 利用 偶数的二进制最后一位为0 奇数的二进制最后一位为1
     * n>>1==n/2
     * @param n
     * @return
     */
    public int[] countBits2(int n) {
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dp[i]=dp[i>>1]+(i%2==0?0:1);
            // 判断i是不是偶数用 i&1 速度快
        }
        return dp;
    }

    /**
     *  利用x-1的二进制加一个1 = x的二进制
     *  x=x & (x−1)，该运算将 x的二进制表示的最后一个 1 变成 0
     *   如 6：0110 & 5：0101 =010 2    2： 010 & 1：0001 =0000
     * @param n
     * @return
     */
    public int[] countBits1(int n) {
        int[] bits=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            bits[i]=f(i);
        }
        return bits;
    }

    static int f(int n)
    {
        int t=0;
        while(n>0)
        {
            t++;
            n=n&(n-1);
        }
        return t;
    }
}
