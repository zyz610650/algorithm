package zyz.algorithm.array.DynamicProgramming.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zyz
 * @title: 解码方法
 * @seq: 24
 * @address: https://leetcode-cn.com/problems/decode-ways/
 * @idea:
 */
public class DecodeWays_24 {


    public static void main(String[] args) {
        String s = "1";
        System.out.println( numDecodings(s));


    }

    //这个是错误思路
    //错在 想根据dp[i-1]来获得dp[i]值的时候,如果i-1和i-2已经结合在一起了，在i-1和i-2的基础上又加上了i,这样重复了一种结果
    //解决思路有两个:1.记录前i-1个数组对应的所有编码，这样时间复杂度变为了n^2
    //解决思路2: 正确的DP: 根据前i-1个字符的组合想要得到前i个字符的组合有两种路径
    // 1>数字i对应的字母单独作为一个字母  2>数字i对应的字母和i-1结合，这个算法就是这点重复计算了,这时候应该用的是i-1和i-2还没结合时前i-2个数字对应
    //字母的组合 即 dp[i]=dp[i−2]
    public static  int numDecodings1(String s) {
        int len=s.length();
        int[] dp=new int[len];
        int tmp=0;
        dp[0]=1;
        for(int i=1;i<len;i++)
        {

            if(s.charAt(i)=='0') continue;
            tmp=s.charAt(i)-'0';
            if(s.charAt(i+1)=='0')
            {
                if(i==0)        dp[0]=1;
                else dp[i]=dp[i-1];
            }else if((tmp*10+(s.charAt(i+1)-'0'))<=26){
                if(i==0)  dp[0]=2;
                else dp[i]=dp[i-1]*2;
            }
        }
    for(int i=0;i<len;i++) System.out.print(dp[i]+" ");
        System.out.println();
        return dp[len-2];
    }

    //只能由位置 i 的单独作为一个 item，设为 a，转移的前提是 a 的数值范围为 [1,9][1,9]，转移逻辑为 f[i] = f[i - 1]f[i]=f[i−1]。
    //只能由位置 i 的与前一位置（i-1）共同作为一个 item，设为 b，转移的前提是 b 的数值范围为 [10,26][10,26]，转移逻辑为 f[i] = f[i - 2]f[i]=f[i−2]。
    //位置 i 既能作为独立 item 也能与上一位置形成 item，转移逻辑为 f[i] = f[i - 1] + f[i - 2]f[i]=f[i−1]+f[i−2]。
   //滚动数组优化空间的代码
    public static  int numDecodings(String s) {
        int len=s.length();
        if(s.charAt(0)=='0') return 0;
        char[] ch=s.toCharArray();
        int a=1,b=1,c=0;

        if (len==1) return a;
        if(((ch[0]-'0')*10+ch[1]-'0')<=26&&ch[1]!='0') b=2;
        else if(((ch[0]-'0')*10+ch[1]-'0')>26&&ch[1]=='0') return 0;
        if (len==2) return b;
        for(int i=2;i<len;i++)
        {
            c=0;
            if(ch[i-1]!='0'&&((ch[i-1]-'0')*10+ch[i]-'0')<=26) c+=a;
            if(ch[i]!='0') c+=b;
            if(c==0) return 0;
            a=b;b=c;

        }
        return c;
    }

//加个哨兵 减少对初始条件的考虑 这里加的哨兵意思是  初始时第一曾循环 i=0时对应的时b a是哨兵的值为1 这样代码效率提升了好多 并且简洁
    public static  int numDecodings2(String s) {
        int len=s.length();
        if(s.charAt(0)=='0') return 0;
        char[] ch=s.toCharArray();
        int a=1,b=1,c=1;
        for(int i=1;i<len;i++)
        {
            c=0;
            if(ch[i-1]!='0'&&((ch[i-1]-'0')*10+ch[i]-'0')<=26) c+=a;
            if(ch[i]!='0') c+=b;
            if(c==0) return 0;
            a=b;b=c;

        }
        return c;

    }
}
