package zyz.algorithm.array.DynamicProgramming;

/**
 * @author zyz
 * @title: 比特位计数
 * @seq: 17
 * @address: https://leetcode-cn.com/problems/counting-bits/
 * @idea:
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
        System.out.println(5&4);
    }
}
