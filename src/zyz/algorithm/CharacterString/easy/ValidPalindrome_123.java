package zyz.algorithm.CharacterString.easy;

/**
 * @author:  zyz
 * @title:  验证回文串
 * @seq:    125
 * @address: https://leetcode-cn.com/problems/valid-palindrome/
 * @idea:
 */
public class ValidPalindrome_123 {

    public static void main(String[] args) {
        String str="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String s) {
        int len=s.length();
        int low=0,high=len-1;
        if(s.equals("")) return true;
        char[] chs=s.toCharArray();
        while(high>low)
        {
            while(low<high&&!((chs[low]>='0'&&chs[low]<='9')||(chs[low]>='a'&&chs[low]<='z')||(chs[low]>='A'&&chs[low]<='Z')))
                low++;
            while(low<high&&!((chs[high]>='0'&&chs[high]<='9')||(chs[high]>='a'&&chs[high]<='z')||(chs[high]>='A'&&chs[high]<='Z')))
                high--;
            if(chs[low]>='A'&&chs[low]<='Z') chs[low]=(char)((chs[low]-'A')+'a');
            if(chs[high]>='A'&&chs[high]<='Z') chs[high]=(char)((chs[high]-'A')+'a');
            if(  !(chs[low]== chs[high]))
            {
                System.out.println(chs[low]+" "+chs[high]);
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
