package zyz.algorithm.array.Hard;

/**
 * @author zyz
 * @title:
 * @seq:
 * @address:
 * @idea:
 */
public class test1 {
    public static void main(String[] args) {
        Integer i=3;
        Integer j=i;
        System.out.println(j==i);
        i=4;
        System.out.println(j==i);
        f(i);
        System.out.println(i);
    }
    public  static  void  f(Integer i)
    {
        System.out.println(i.toString());
        i=100;
        System.out.println(i);
    }
}
