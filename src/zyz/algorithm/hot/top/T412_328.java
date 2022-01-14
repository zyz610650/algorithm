package zyz.algorithm.hot.top;

import java.util.ArrayList;
import java.util.List;


/**
 * @author zyz
 * @title: 412. Fizz Buzz
 * @seq: 412
 * @address: https://leetcode-cn.com/problems/fizz-buzz/
 * @idea:
 */
public class T412_328 {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            StringBuffer sb = new StringBuffer();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(i);
            }
            answer.add(sb.toString());
        }
        return answer;
    }


}
