package zyz.algorithm.type.CharacterString.medium;

/**
 * @author zyz
 * @title: 比较版本号
 * @seq: 165
 * @address: https://leetcode-cn.com/problems/compare-version-numbers/
 * @idea:
 */
public class CompareVersionNumbers_129 {
    public static void main(String[] args) {
        String version1= "1.0";
        String version2= "1.0.0";
        System.out.println(compareVersion(version1,version2));

        System.out.println();

    }
    public static int compareVersion(String version1, String version2){
        String[] split1=version1.split("\\.");
        String[] split2=version2.split("\\.");
        int i=0,j=0;
        while(i<split1.length&&j< split2.length)
        {
            if (add(split1[i])>add(split2[j])) return 1;
            if (add(split1[i])<add(split2[j])) return -1;
            i++;
            j++;
        }
        while(i< split1.length)
        {
            int ans=add(split1[i]);
            if(ans==0) i++;
            else break;
        }
        while(j< split2.length)
        {
            int ans=add(split2[j]);
            if(ans==0) j++;
            else break;
        }
        if (i== split1.length&&j<split2.length) return -1;
        if (i< split1.length&&j==split2.length) return 1;

        return 0;
    }
    public static int  add(String s)
    {


        int ans=0;
        int i=0;
        while (i<s.length())
        {
            ans=ans*10+s.charAt(i)-'0';
            i++;
        }
        return  ans;
    }

    // 这个方法简便的多
    public int compareVersion2(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }


}
