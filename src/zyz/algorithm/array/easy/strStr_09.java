package zyz.algorithm.array.easy;

/**
 * @author zyz
 * @title: 实现 strStr()
 * @seq: 09
 * @address: https://leetcode-cn.com/problems/implement-strstr/$
 * @idea:  就是KMP 类似的还有BM算法
 * KMP讲解：https://www.cnblogs.com/yjiyjige/p/3263858.html
 *    证明取最大公共前后缀: https://blog.csdn.net/qq_21989927/article/details/109520767
 */
public class strStr_09 {

    public static void main(String[] args) {
        String haystack = "aaaaa", needle = "bba";
        System.out.println(strStr(haystack,needle));
    }
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;

    int[] next=getNext(needle.toCharArray());
    int i=0,j=0;
    while (j<needle.length()&&i<haystack.length())
        {
            if (j==-1||needle.charAt(j)==haystack.charAt(i)) // 当j为-1时，要移动的是i，当然j也要归0
            {
                i++;j++;
            }else{
                j=next[j]; //next[0] =-1 如果不为-1 这里就会出现死循环
            }
        }
        if (j==needle.length()) return i-j;
        else return -1;
    }
    public static int[] getNext(char[] p){
        int k=-1,j=0;
        int[] next=new int[p.length];
        next[0]=-1;
        while(j<p.length-1)
        {
            if (k==-1||p[k]==p[j])
            {
                next[++j]=++k;//数组中的第一个元素只要和模式串不匹配 他一定是需要移动到下标为0的位置的 所以next[1]一定=0
            }else{
                k=next[k];
            }
        }
        return next;
    }

}
