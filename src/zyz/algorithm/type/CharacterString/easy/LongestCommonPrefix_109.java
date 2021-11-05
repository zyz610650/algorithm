package zyz.algorithm.type.CharacterString.easy;

/**
 * @author zyz
 * @title: 最长公共前缀
 * @seq: 14
 * @address: https://leetcode-cn.com/problems/longest-common-prefix/
 * @idea:
 */
public class LongestCommonPrefix_109 {

    public static void main(String[] args) {
//        String[] strs = {"dog","racecar","car"};
        String[] strs = {"dog","dogger","dog"};
        StringBuilder sb=new StringBuilder();
        StringBuilder sp=new StringBuilder();
        sb=sp;

        System.out.println(longestCommonPrefix(strs));
    }

    // 用 charAt  击败100% 比substring效率高的多
    public static String longestCommonPrefix(String[] strs)
    {
        int len=strs[0].length();
        for(int i=0;i<strs.length;i++)
        {
            len=Math.min(len,strs[i].length());
        }
        int l=1;
        char ch;
        for(int i=0;i<len;i++)
        {

            ch=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++)
            {
                if (ch!=strs[j].charAt(i)) return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,len);
    }
    // substring 暴暴力23.75%
    public static String longestCommonPrefix2(String[] strs) {
        int len=strs[0].length();
        for(int i=0;i<strs.length;i++)
        {
            len=Math.min(len,strs[i].length());
        }

        for(int i=1;i<=len;i++)
        {
            if(!judge1(strs,i)) return strs[0].substring(0,i-1);
        }

        return strs[0].substring(0,len);
    }
    static  boolean judge1(String[] strs,int len)
    {
        String str=strs[0].substring(0,len);
        for(int i=1;i<strs.length;i++)
            if(!strs[i].substring(0,len).equals(str)) return false;
        return true;
    }


    // 二分 才9.02%。。
    public static String longestCommonPrefix1(String[] strs) {
        int len=strs[0].length();
        for(int i=0;i<strs.length;i++)
        {
            len=Math.min(len,strs[i].length());
        }
        int t= binarySearch(0,len-1,strs);
        return strs[0].substring(0,t+1);
    }

    static  int binarySearch(int low,int high,String[] strs)
    {
        int mid;
        int ans=-1;
        while(low<=high)
        {
            System.out.println("low: "+low+" high: "+high);
            mid=(high-low)/2+low;
            if(mid<ans) break;
            if(judge(strs,mid))
            {
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if (high<low&&ans==-1) return-1;
        return ans;
    }
    static  boolean judge(String[] strs,int len)
    {
        String str=strs[0].substring(0,len+1);
        for(int i=1;i<strs.length;i++)
            if(!strs[i].substring(0,len+1).equals(str)) return false;
        return true;
    }
}
