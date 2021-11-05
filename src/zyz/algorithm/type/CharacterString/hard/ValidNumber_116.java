package zyz.algorithm.type.CharacterString.hard;

/**
 * @author zyz
 * @title: 有效数字
 * @seq: 65
 * @address: https://leetcode-cn.com/problems/valid-number/
 * @idea:
 */
public class ValidNumber_116 {
    public static void main(String[] args) {
        String s=".1";
        System.out.println(isNumber(s));
    }

    /**
     * 暴力
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        char[] chs=s.toCharArray();
        boolean flag=false;
        boolean flage=false;
        for(int i=0;i< chs.length;i++)
        {
            if(chs[i]>='0'&&chs[i]<='9') continue;
            if(chs[i]=='+'||chs[i]=='-')
            {
                if (i==0) continue;
                if (chs[i-1]=='e'||chs[i-1]=='E') continue;
            }
            if (chs[i]=='.')
            {
                if(flag) return false;
                flag=true;
                if(i==0&&i+1<chs.length&&(chs[i+1]>='0'&&chs[i+1]<='9')) continue;
                if(i!=0&&(chs[i-1]>='0'&&chs[i-1]<='9')) continue;
                if(i!=0&&i+1<chs.length&&(chs[i+1]>='0'&&chs[i+1]<='9')) continue;
            }
            if (chs[i]=='e'||chs[i]=='E')
            {
                flag=true;
                if(flage) return false;
                flage=true;
                if (i==0||(chs[i-1]=='-'||chs[i-1]=='+')) return false;;
                if(i+1>=chs.length) return false;
                if(chs[i+1]>='0'&&chs[i+1]<='9') continue;
                if((chs[i+1]=='+'||chs[i+1]=='-')&&(i+2<s.length())&&(chs[i+2]>='0'&&chs[i+2]<='9')) continue;
            }
            return false;
        }
        return true;
    }
}
