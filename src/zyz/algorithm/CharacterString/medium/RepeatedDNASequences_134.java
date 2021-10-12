package zyz.algorithm.CharacterString.medium;

import java.util.*;

/**
 * @author zyz
 * @title: 重复的DNA序列
 * @seq: 187
 * @address: https://leetcode-cn.com/problems/repeated-dna-sequences/
 * @idea:
 */
public class RepeatedDNASequences_134 {
	public static void main ( String[] args ) {
		String s = "AAAAAAAAAAAAA";
		System.out.println (findRepeatedDnaSequences ( s ) );
	}
	public static List <String> findRepeatedDnaSequences1( String s) {

		Set <String> set=new HashSet<>();
		Map <String,Integer> map=new HashMap <> ();
		Integer v;
		for(int i=0;i<s.length()-9;i++)
		{
			String str=s.substring(i,i+10);
			map.computeIfAbsent (str,value->{
				return  0;
			});
			v=map.computeIfPresent(str,(key,value)->{

				return Integer.valueOf ( value+1 );
			});
			if(v>1)
			{
				set.add(str);
			}
		}

		return 	new ArrayList <> (set);

	}

	static final int L = 10;
	static Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
		put('A', 0);
		put('C', 1);
		put('G', 2);
		put('T', 3);
	}};

	public static List<String> findRepeatedDnaSequences2(String s) {
		List<String> ans = new ArrayList<String>();
		int n = s.length();
		if (n <= L) {
			return ans;
		}
		int x = 0;
		for (int i = 0; i < L - 1; ++i) {
			x = (x << 2) | bin.get(s.charAt(i));
		}
		System.out.println (x );
		Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
		for (int i = 0; i <= n - L; ++i) {
			x = ((x << 2) | bin.get(s.charAt(i + L - 1))) & ((1 << (L * 2)) - 1);
			cnt.put(x, cnt.getOrDefault(x, 0) + 1);
			if (cnt.get(x) == 2) {
				ans.add(s.substring(i, i + L));
			}
		}
		return ans;
	}

	public static List<String> findRepeatedDnaSequences(String s){

		List<String> list=new ArrayList <> (  );
		if(s.length()<10) return list;
		Map<Character, Integer> map = new HashMap<Character, Integer>() {{
			put('A', 0);
			put('C', 1);
			put('G', 2);
			put('T', 3);
		}};

		Map<Integer,Integer> cnt=new HashMap <> ();
		int x=0;
		//提前计算前L-1位 到下面那个循环只需要每次考虑移动一位即可
		for(int i=0;i<9;i++)
		{
			x=(x<<2)|map.get ( s.charAt ( i ) );
		}
		for(int i=9;i<s.length();i++)
		{
			x=(x<<2)|map.get ( s.charAt ( i ) );
			// 两者效果相同
			// 1048575二进制即： 00000000000011111111111111111111
			// x=x&1048575;
			// X<< 2 表示x的二进制向左移动2位
			// x&((1 << (L * 2)) - 1); 就是 1 向左移动20位 保证前12为0 后20位为1
			x=x&((1 << (L * 2)) - 1);
			System.out.println (x+" "+s.substring (i-9,i+1) );
			cnt.put ( x,cnt.getOrDefault (x,0)+1);
			if ( cnt.get (x)==2)  // 这点思路很妙 避免了多用Set判重
			{
				list.add (s.substring (i-9,i+1));
			}
		}
		return list;
	}

}
