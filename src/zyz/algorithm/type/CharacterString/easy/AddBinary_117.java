package zyz.algorithm.type.CharacterString.easy;

/**
 * @author zyz
 * @title: 二进制求和
 * @seq: 67
 * @address: https://leetcode-cn.com/problems/add-binary/
 * @idea:
 */
public class AddBinary_117 {
    public static void main(String[] args) {
        String a="111",b="1";
        System.out.println(addBinary(a,b));
    }
    public static String addBinary(String a, String b) {
        StringBuilder sbb=new StringBuilder(b);
        StringBuilder saa=new StringBuilder(a);
        char[] cha=saa.reverse().toString().toCharArray();
        char[] chb=sbb.reverse().toString().toCharArray();
        int t=0;
        int tmp=0;
        StringBuilder sb=new StringBuilder();
        while(t<cha.length&&t<chb.length)
        {

            tmp=cha[t]-'0'+chb[t]-'0'+tmp;
            t++;
            if(tmp==2)
            {
                sb.append(0);
                tmp=1;
            }else if (tmp==3)
            {
                sb.append(1);
                tmp=1;
            } else{
                sb.append(tmp);
                tmp=0;
            }
        }
        while(t<cha.length)
        {
            tmp=cha[t]-'0'+tmp;
            t++;
            if(tmp==2)
            {
                sb.append(0);
                tmp=1;
            }else if (tmp==3)
            {
                sb.append(1);
                tmp=1;
            } else{
                sb.append(tmp);
                tmp=0;
            }

        }
        while(t<chb.length)
        {
            tmp=chb[t]-'0'+tmp;
            t++;
            if(tmp==2)
            {
                sb.append(0);
                tmp=1;
            }else if (tmp==3)
            {
                sb.append(1);
                tmp=1;
            } else{
                sb.append(tmp);
                tmp=0;
            }
        }
        if(tmp!=0) sb.append(tmp);
        return sb.reverse().toString();
    }
}
