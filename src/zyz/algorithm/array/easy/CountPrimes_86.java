package zyz.algorithm.array.easy;

import java.util.Arrays;

/**
 * @author zyz
 * @title: 计数质数
 * @seq: 204
 * @address: https://leetcode-cn.com/problems/count-primes/
 * @idea:
 */

// 质数是指在大于1的自然数中，除了1和它本身以外不再有其他因数的自然数。
//
//    任意素数x的倍数有：2x, 3x, 4x, ..., x*x, (x+1)*x, ...
//
//            任意小于x*x的倍数都被之前的素数筛过滤过，如：2 过滤 2x, 4x, ...，3 过滤 3x, ...
//
//            所以从x*x开始过滤之后的倍数，所以x只需遍历到sqrt(N)
public class CountPrimes_86 {
    public static void main(String[] args) {
        System.out.println(countPrimes1(10));
    }
    // 超时
    public static int countPrimes(int n) {
        int cnt=0;
        boolean flag;
        for(int i=2;i<=n;i++)
        {
            flag=true;
            if((i&2)==1) continue;
            for(int j=2;j<=i/2;j++)
            {
                if(i%j==0) {
                    flag=false;
                    break;
                }
            }
            if(flag)
            {
                System.out.println(i);
                cnt++;
            }
        }
        return cnt;
    }

    public static int countPrimes1(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i  < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = 2*i ; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }
    //埃氏筛
    public static int countPrimes2(int n)
    {
        int cnt=0;
        boolean[] isPrime=new boolean[n+1];
        Arrays.fill(isPrime,true);
        for (int i=2;i*i<n;i++)
        {
            if (isPrime[i])
            {
                for (int j=i*i;j<n;j+=i)
                    isPrime[j]=false;
            }
        }
        for (int i=2;i<n;i++)
        {
            if (isPrime[i]) cnt++;
        }
        return cnt;
    }

}
