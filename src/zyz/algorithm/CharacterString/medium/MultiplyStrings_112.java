package zyz.algorithm.CharacterString.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyz
 * @title: 字符串相乘
 * @seq: 43
 * @address: https://leetcode-cn.com/problems/multiply-strings/
 * @idea:
 */
public class MultiplyStrings_112 {

    public static void main(String[] args) {
       String num1 = "408", num2 = "5";
        System.out.println(multiply(num1,num2));
    }
    // 把list换成数组速度块  因为少了List的get过程s
    public static String multiply(String num1, String num2) {


        char[] ch1=num1.toCharArray();
        char[] ch2=num2.toCharArray();
        if(ch1[0]=='0'||ch2[0]=='0') return "0";
        List<Integer> list1=new ArrayList<>();

        int n=0;
        for(int i=ch1.length-1;i>=0;i--)
        {
            List<Integer> list2=new ArrayList<>();
            for(int k=0;k<ch1.length-i-1;k++) list2.add(list1.get(k));
            for(int j=ch2.length-1;j>=0;j--)
            {
                n=(ch1[i]-'0')*(ch2[j]-'0');
                int t=ch1.length-1-i+ch2.length-1-j;
                if(t<list1.size()) {
                    list2.add(list1.get(t)+n);
                } else {
                    list2.add(n);
                }
            }
            list1=new ArrayList<>(list2);
        }
        StringBuilder sb=new StringBuilder();
        int pre=0;
        for(int i=0;i<list1.size();i++)
        {
            n=list1.get(i)+pre;
            pre=n/10;
            sb.append(n%10);
        }
        if(n/10>0)
            sb.append(n/10);
        return sb.reverse().toString();
    }
}
