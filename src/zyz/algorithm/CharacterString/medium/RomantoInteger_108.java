package zyz.algorithm.CharacterString.medium;

/**
 * @author zyz
 * @title: 罗马数字转整数
 * @seq: 13
 * @address: https://leetcode-cn.com/problems/roman-to-integer/
 * @idea:
 */
public class RomantoInteger_108 {

    public static void main(String[] args) {

    }
    public static int romanToInt(String s) {
        int ans=0;
        char[] chs=s.replace("CM", "a")
                .replace("CD","b")
                .replace("XC", "c")
                .replace("XL","d")
                .replace("IX", "e")
                .replace("IV","f").toCharArray();
        int len=chs.length;

        int[] arr={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        char[] symbols = {'M', 'a', 'D', 'b', 'C', 'c', 'L', 'd', 'X', 'e', 'V', 'f', 'I'};
        int i=0;
        int t=0;
        while(i<len)
        {
            while(chs[i]!=symbols[t]) t++;
            ans+=arr[t];
            i++;
        }
        return ans;
    }

}
