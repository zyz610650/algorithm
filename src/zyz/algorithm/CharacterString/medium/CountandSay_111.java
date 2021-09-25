package zyz.algorithm.CharacterString.medium;

/**
 * @author zyz
 * @title: 外观数列
 * @seq: 38
 * @address: https://leetcode-cn.com/problems/count-and-say/
 * @idea:
 *  递归和循环对时间的对比 :
 *  https://blog.csdn.net/ccutyear/article/details/52819123
 *
 *  这道题 递归比循环快的多
 */
public class CountandSay_111 {


    public String countAndSay1(int n) {
        StringBuilder sb=new StringBuilder();
        char[] chs;
        sb.append(1);
        int t=0;
        while(t<n-1)
        {
            chs=sb.toString().toCharArray();
            sb=new StringBuilder();
            int ans=1;
            for(int i=0;i<chs.length;i++)
            {
                if(i+1<chs.length&&chs[i+1]==chs[i]) {
                    ans++;
                } else {
                    sb.append(ans);
                    sb.append(chs[i]);
                    ans=1;
                }
            }
            t++;
        }
        return sb.toString();
    }

    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder();
        sb.append(1);
        String str;
        int t=0;
        while(t<n-1)
        {
            str=sb.toString();
            sb=new StringBuilder();
            int ans=1;
            for(int i=0;i<str.length();i++)
            {
                if(i+1<str.length()&&str.charAt(i+1)==str.charAt(i)) {
                    ans++;
                } else {
                    sb.append(ans);
                    sb.append(str.charAt(i));
                    ans=1;
                }
            }
            t++;
        }
        return sb.toString();
    }
}
