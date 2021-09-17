package zyz.algorithm.CharacterString.medium;

/**
 * @author zyz
 * @title: 字符串转换整数 (atoi)
 * @seq: 8
 * @address: https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @idea:
 */
public class StringtoInteger_105 {

    public static void main(String[] args) {
        String s = "-91283472332";

        System.out.println(myAtoi(s));
//        mississispi         ispi     isp*.
//
//        mis*isp*.
    }
    // 因为 正数比负数少1 所以正数和负数需要刚开始就分开比较，而不是到最后再放一起比较
    // 该题的难点在于  912834723如果再扩大10倍一定大于MAX_VALUE，因为用int保存，值一定变得小于MAX_VALUE了
    //所以这里巧妙的转换到除10进行对比
    public static int myAtoi(String s) {

        int len=s.length();
        char[] chs=s.toCharArray();
        boolean flag=false;
        int f=1;
        int ans=0;
        for(char ch:s.toCharArray())
        {
            if(!flag&&ch==' ') continue;
            if(ch=='-'||ch=='+')
            {
                flag=true;
                if(ch=='-') f=-1;
            }
            else if((ch>='0'&&ch<='9'))
            {
                int cnt=(ch-'0');
                if (ans>Integer.MAX_VALUE/10||(ans==Integer.MAX_VALUE/10&&cnt>=Integer.MAX_VALUE%10))
                    return Integer.MAX_VALUE;
                if (ans<Integer.MIN_VALUE/10||(ans==Integer.MIN_VALUE/10&&cnt<=Integer.MIN_VALUE%10))
                    return Integer.MIN_VALUE;
                flag=true;
                ans=ans*10+cnt*f;
            }else break;

        }

        return ans;
    }

    public  static int myAtoi1(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }



}
//-91283472332
//-1089159116
//-2147483648