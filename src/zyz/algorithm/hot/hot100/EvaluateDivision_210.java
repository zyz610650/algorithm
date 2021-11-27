package zyz.algorithm.hot.hot100;

import java.util.*;

/**
 * @author zyz
 * @title: 除法求值
 * @seq: 399
 * @address: https://leetcode-cn.com/problems/evaluate-division/
 * @idea:
 *
 */
public class EvaluateDivision_210 {

	public static void main (String[] args) {


	}

	class Node{
		String key;
		double val;
		public Node(String key,double val)
		{
			this.key=key;
			this.val=val;
		}
	}
	Map<String,List<Node>> map;
	public double[] calcEquation1(List< List <String> > equations, double[] values, List<List<String>> queries) {
		map=new HashMap <> ();
		double[] res=new double[queries.size()];
		List<Node> list1;
		List<Node> list2;
		for(int i=0;i<equations.size();i++)
		{
			String str1=equations.get(i).get(0);
			String str2=equations.get(i).get(1);
			list1=map.getOrDefault(str1,new ArrayList <> ());
			list2=map.getOrDefault(str2,new ArrayList<>());
			list1.add(new Node(str2,values[i]));
			list2.add(new Node(str1,1.0/values[i]));
			map.put(str1,list1);
			map.put(str2,list2);
		}

		for(int i=0;i<queries.size ();i++)
		{
			res[i]=dfs(queries.get(i).get(0),1,queries.get(i).get(1),new HashSet <> ());
		}
		return res;

	}

	public double dfs(String next, double val, String des, Set <String> set)
	{
		if(set.contains (next)||!map.containsKey(next)) return -1.0;

		if(des.equals(next)) return val;

		set.add(next);
		List<Node> list = map.get(next);
		for(int i=0; i<list.size();i++)
		{
			Node node=list.get(i);
			double res=dfs(node.key,val*node.val,des,set);
			if(res!=-1.0) return res;
		}
		return -1.0;
	}


	// floyd
	// 为什么k 在外面
	public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {

		Map<String,Integer> map=new HashMap<>();
		int cnt=0;
		for(int i=0;i<equations.size();i++)
		{
			List<String> list=equations.get(i);
			if(!map.containsKey(list.get(0)))
				map.put(list.get(0),cnt++);
			if(!map.containsKey(list.get(1)))
				map.put(list.get(1),cnt++);
		}
		double[][] graph=new double[cnt][cnt];
		for(int i=0;i<cnt;i++)
		{
			//System.out.println (Arrays.toString (graph[i]));
			Arrays.fill(graph[i],-1);
		}

		for(int i=0;i<equations.size();i++)
		{
			List<String> list=equations.get(i);
			int c1=map.get(list.get(0));
			int c2=map.get(list.get(1));
			graph[c1][c2]=values[i];
			graph[c2][c1]=1/values[i];
		}

// 注意这里k在外面
		for(int k=0;k<cnt;k++)
		{
			for(int i=0;i<cnt;i++)
			{
				for(int j=0;j<cnt;j++)
				{
					if(graph[i][k]>0&&graph[k][j]>0)
					{
						graph[i][j]=graph[i][k]*graph[k][j];
					}
				}
			}
		}
		double[] res=new double[queries.size()];
		Arrays.fill(res,-1);
		for(int i=0;i<queries.size();i++)
		{
			List<String> list=queries.get(i);
			if(map.containsKey(list.get(0))&& map.containsKey(list.get(1)))
			{
				//               Arrays.fill(graph[i],-1);是因为这里可能获得到两者之间没有路径的节点
				res[i]=graph[map.get(list.get(0))][map.get(list.get(1))];
			}
		}
		return res;
	}

	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int nvars = 0;
		Map<String, Integer> variables = new HashMap<String, Integer>();

		int n = equations.size();
		for (int i = 0; i < n; i++) {
			if (!variables.containsKey(equations.get(i).get(0))) {
				variables.put(equations.get(i).get(0), nvars++);
			}
			if (!variables.containsKey(equations.get(i).get(1))) {
				variables.put(equations.get(i).get(1), nvars++);
			}
		}
		int[] f = new int[nvars];
		double[] w = new double[nvars];
		Arrays.fill(w, 1.0);
		for (int i = 0; i < nvars; i++) {
			f[i] = i;
		}

		for (int i = 0; i < n; i++) {
			int va = variables.get(equations.get(i).get(0)), vb = variables.get(equations.get(i).get(1));
			merge(f, w, va, vb, values[i]);
		}
		int queriesCount = queries.size();
		double[] ret = new double[queriesCount];
		for (int i = 0; i < queriesCount; i++) {
			List<String> query = queries.get(i);
			double result = -1.0;
			if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
				int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
				int fa = findf(f, w, ia), fb = findf(f, w, ib);
				if (fa == fb) {
					result = w[ia] / w[ib];
				}
			}
			ret[i] = result;
		}
		return ret;
	}

	public static void merge (int[] f , double[] w , int x , int y , double val) {
		int fx = findf(f, w, x);
		int fy = findf(f, w, y);
		f[fx] = fy;
		w[fx] = val * w[y] / w[x];

		System.out.println ("x: "+x +" y: "+y+" fx: "+ fx+" fy: "+fy+ " val : "+val +" w[x]: "+w[x]+" w[y]: "+w[y]+" w[fx]: "+w[fx] +" f[fx]： "+ f[fx]);
	}

	public static int findf (int[] f , double[] w , int x) {
		if (f[x] != x) {
			int father = findf(f, w, f[x]);
			w[x] = w[x] * w[f[x]];
			f[x] = father;
		}
		return f[x];
	}

	/**
	 * 并查集
	 * @param equations
	 * @param values
	 * @param queries
	 * @return
	 */

	public  double[] calcEquation4(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Map<String,Integer> map=new HashMap();
		int cnt=0;
		for(int i=0;i<equations.size();i++)
		{
			List<String> list = equations.get(i);
			if(!map.containsKey(list.get(0)))
				map.put(list.get(0),cnt++);
			if(!map.containsKey(list.get(1)))
				map.put(list.get(1),cnt++);
		}

		int[] f=new int[cnt];
		double[] w=new double[cnt];
		for(int i=0;i<cnt;i++)
		{
			f[i]=i;
			w[i]=1.0;
		}
		for(int i=0;i<equations.size();i++)
		{
			List<String> list=equations.get(i);
			int x=map.get(list.get(0));
			int y=map.get(list.get(1));

			merge(x,y,f,w,values[i]);
		}

		double[] res=new double[queries.size()];
		Arrays.fill(res,-1.0);
		for(int i=0;i<queries.size();i++)
		{

			List<String> list=queries.get(i);
			if(map.containsKey(list.get(0))&&map.containsKey(list.get(1)))
			{
				int x=map.get(list.get(0));
				int y=map.get(list.get(1));
				int fx=findf(x,f,w);
				int fy=findf(y,f,w);
				if(fx==fy)
				{
					res[i]=w[x]/w[y];
				}
			}
		}
		return res;

	}

	void merge(int x,int y,int[] f,double[] w,double val)
	{
		int fx=findf(x,f,w);
		int fy=findf(y,f,w);
		f[fx]=fy;
		w[fx]=val*w[y]/w[x];
	}

	int findf(int x,int[] f,double[] w)
	{
		if(x==f[x]) return x;

		int fa=findf(f[x],f,w);
		w[x]=w[x]*w[f[x]];
		f[x]=fa;
		return fa;
	}

// https://www.cnblogs.com/ukcxrtjr/p/11194356.html

	// https://zhuanlan.zhihu.com/p/93647900/
//	void find(int x)
//	{
//		return x==f[x]? x:(f[x]=find(f[x]));
//	}
//
//	void merge(int x,int y)
//	{
//		int fx=f[x],fy=f[y];
//		if(fx==fy) return;
//		if(w[fx]<w[fy])
//		{
//			f[fx]=fy;
//		}else{
//			f[fy]=fx;
//			if(w[fx]==w[fy]) w[fx]++;
//		}
//
//	}
}
