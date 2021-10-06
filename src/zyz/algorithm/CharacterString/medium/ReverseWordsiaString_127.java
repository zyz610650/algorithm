package zyz.algorithm.CharacterString.medium;

import java.util.Arrays;

/**
 * @author: @zyz
 */
public class ReverseWordsiaString_127 {
    public static void main(String[] args) {
        String s="  hello world  ";
        System.out.println(reverseWords(s));
    }
    public static  String reverseWords(String s) {
        String[] str=s.split(" ");
        System.out.println(Arrays.toString(str));
        StringBuilder sb=new StringBuilder();
        for(int i=str.length-1;i>=0;i--)
        {
            if (!str[i].equals(" "))
            sb.append(str[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
