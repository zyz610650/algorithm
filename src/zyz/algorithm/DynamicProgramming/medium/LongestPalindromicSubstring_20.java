package zyz.algorithm.DynamicProgramming.medium;

/**
 * @author zyz
 * @title: 最长回文子串
 * @seq: 20
 * @address: https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @idea:
 *    1.dp[i][j]:i->j 是否是回文字串
 *    2.dp[i-1][j+1]=s[i]==s[j]?dp[i][j]:false;
 *    3. 初始:dp[0] dp[s.length-1] dp[i][s.lentgh-1]
 */
public class LongestPalindromicSubstring_20 {
    public static void main(String[] args) {
        String s="bbbab";

        System.out.println(longestPalindrome1(s));

    }
    //方法1: dp
    public static String longestPalindrome(String s) {
        int len=s.length();
        boolean [][] dp=new boolean[len][len];
        int max=1;
        int dx=0,dy=0;
        //初始化 l:代表字串长度
        for(int i=0;i<len;i++)
        {
            dp[i][i]=true;
        }

        //最外层循环是字串长度
        for(int l=1;l<len;l++)
        {
            for(int i=0;i<len;i++)
            {
                if (i+l>=len) break;
                if(l==1&&s.charAt(i)==s.charAt(i+l))
                {
                    dp[i][i+l]=true;
                }
                else if(s.charAt(i)==s.charAt(i+l))
                {
                    dp[i][i+l]=dp[i+1][i+l-1];
                }
                if(dp[i][i+l]&&max<l+1)
                {
                    max=l+1;
                    dx=i;
                    dy=i+l;
                }

            }
        }
//        System.out.println(dx+" "+dy);
//        Utils.print2Arr(dp);
        return s.substring(dx,dy+1);
    }
    //方法2: 中心扩散
    public static String longestPalindrome1(String s) {
        if (s == null || s.length() < 1){
            return "";
        }

        // 初始化最大回文子串的起点和终点
        int start = 0;
        int end   = 0;

        // 遍历每个位置，当做中心位
        for (int i = 0; i < s.length(); i++) {
            // 分别拿到奇数偶数的回文子串长度
            int len_odd = expandCenter(s,i,i);
            int len_even = expandCenter(s,i,i + 1);
            // 对比最大的长度
            int len = Math.max(len_odd,len_even);
            // 计算对应最大回文子串的起点和终点   end - start+1才是子串的长度 这里用 end - start保证得到的最大子串时后面的 比如
            // bbbab len > end - start得到的时 bab  len > end - start+1 得到的是bbb
            if (len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        // 注意：这里的end+1是因为 java自带的左闭右开的原因
        return s.substring(start,end + 1);
    }


    /**
     *
     * @param s             输入的字符串
     * @param left          起始的左边界
     * @param right         起始的右边界
     * @return              回文串的长度
     */
    private static int expandCenter(String s,int left,int right){
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1
        return right - left - 1;
    }

}
