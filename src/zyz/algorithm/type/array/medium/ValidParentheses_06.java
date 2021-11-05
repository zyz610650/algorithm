package zyz.algorithm.type.array.medium;

/**
 * @author zyz
 * @title: 效的括号
 * @seq: 06
 * @address: https://leetcode-cn.com/problems/valid-parentheses/$
 * @idea:
 *        考察栈的应用
 */

public class ValidParentheses_06 {

    public static void main(String[] args) {
        String s = "]";
        System.out.println(s.charAt(0));
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {

        StringBuilder stack=new StringBuilder();

        int i=0;
        int k=0;
        char ch;
        while (i<s.length()){
            if (s.charAt(i)=='}'||s.charAt(i)==')'||s.charAt(i)==']')
            {
                k=stack.length()-1;
                if (k<0) return false;
                 ch= stack.charAt(k);
                 if (ch=='{'&&s.charAt(i)!='}') return false;

                 if (ch=='('&&s.charAt(i)!=')') return false;

                if (ch=='['&&s.charAt(i)!=']')  return false;

                stack.deleteCharAt(k);

            }else{
                stack.append(s.charAt(i));
            }
            i++;
        }
        if(stack.length()!=0) return  false;
        return true;
    }
}
