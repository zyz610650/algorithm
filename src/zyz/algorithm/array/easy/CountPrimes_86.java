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
        int cnt = 0;
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i  < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                cnt++;
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                if((long)i*i>n) continue;
                for (int j = i*i ; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数

        return cnt;
    }
    //优化过的埃氏筛  遍历到i*i
    //为什么埃式筛只需要剔除根号n以内的质数倍数
    //理由很简单。如果 n含有大于sqrt(n)的素因子，那么它一定也同时含有小于sqrt(n)的素因子
    //于是如果他不含小于sqrt(n)的素因子，那么它一定不会再有大于sqrt(n)的素因子
    // 就时一个合数一定可以分解为一个 素数*一个合数的质因子，这两个数一定是
    //一个<=sqrt(n)，一个>=sqrt(n),所以只需要把2-->sqrt(n)都计算一遍，大于sqrt(n)的就不用
    //再算了，因为枚举<=sqrt(n)的数已经把它举例过了
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
