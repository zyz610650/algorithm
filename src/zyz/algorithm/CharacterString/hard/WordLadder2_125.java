package zyz.algorithm.CharacterString.hard;

import java.util.*;

/**
 * @author: @zyz
 * @title: 单词接龙 II
 * @seq: 126
 * @address: https://leetcode-cn.com/problems/word-ladder-ii/
 * @idea:
 */
public class WordLadder2_125 {
    static class Node{
        String word;
        List<String> list;
        Set<String> set;
        public Node(String word,List<String> list,Set<String> set)
        {
            this.word=word;
            this.list=list;
            this.set=set;
        }
    }
    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
       String[] str=new String[] {"hot","dot","dog","lot","log","cog"};
//        String beginWord = "a", endWord = "c";
//        String[] str=new String[] {"a","b","c"};
        List<String> strings = Arrays.asList(str);

        System.out.println(findLadders(beginWord,endWord,strings));
    }
// 超时
    public static List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> list=new ArrayList<>();
        Set<String> allWordSet = new HashSet<>(wordList);
        Queue<Node> queue=new LinkedList<>();
        if (!allWordSet.contains(endWord)) {
            return list;
        }

        boolean[] vis=new boolean[wordList.size()];
        Node node =new Node(beginWord,new ArrayList<>(),new HashSet<>());
        node.list.add(beginWord);

        queue.add(node);
        int count=wordList.size();

        while(!queue.isEmpty())
        {
            node=queue.poll();
            if (node.list.size()>count)  break;
            if(node.word.equals(endWord))
            {   count=node.list.size();
                list.add(node.list);
                continue;
            }
            char[] chs=node.word.toCharArray();

            for(int i=0;i<chs.length;i++)
            {
                char c=chs[i];
                for(char ch='a';ch<='z';ch++)
                {
                    chs[i]=ch;
                    String str=new String(chs);

                    if (!node.set.contains(str)&&allWordSet.contains(str))
                    {
                        Node newNode= new Node(str,new ArrayList<>(node.list),new HashSet<>(node.set));
                        newNode.list.add(str);
                        newNode.set.add(str);
                        queue.add(newNode);
                    }else {
                        node.set.add(str);
                    }
                }
                chs[i]=c;
            }

        }
        return list;
    }

    //方法一: 纯BFS AC
    // 我上面专门用一个类去保存List和String 应该是每次new之类得会超时
    //这里直接把路径当作Queue得节点去存储，就能记录当街的每条路径
    //之前一直纠结把当前访问节点，和到当前节点的所有路径怎么对应存储起来
    //用一个内部类去存储，超时
    //这里直接存储路径就能AC
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList, ans);
        return ans;
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int j = 0; j < size; j++) {
                List<String> p = queue.poll();
                //得到当前路径的末尾单词
                String temp = p.get(p.size() - 1);
                // 一次性得到所有的下一个的节点
                List<String> neighbors = getNeighbors(temp, dict);
                for (String neighbor : neighbors) {
                    //只考虑之前没有出现过的单词
                    if (!visited.contains(neighbor)) {
                        //到达结束单词
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                            p.add(neighbor);
                            ans.add(new ArrayList<String>(p));
                            p.remove(p.size() - 1);
                        }
                        //加入当前单词
                        p.add(neighbor);
                        queue.offer(new ArrayList<String>(p));
                        p.remove(p.size() - 1);
                        subVisited.add(neighbor);
                    }
                }
            }
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
    }

    private static List<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

    //方法2: BFS+DFS 单纯的DFS+BFS不行 必须得在dfs过程中做一些优化,比如一些某些节点在第三层又在第二层，则在第三层时就不需要在便利了
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans=new ArrayList<>();
        if (!wordList.contains(endWord))
        return ans;
        // 这里存储了最短路径中所有节点自己所在的最低层数 所以
        // 有      if (distance.get(beginWord)+1==distance.get(neighbor)){
        // 这点就是判断自己是不是在最短路径上 是的话才处理
        HashMap<String,Integer> distance=new HashMap<>();
        // 存放邻居
        HashMap<String,List<String>> map=new HashMap<>();
         bfs(beginWord,endWord,wordList,map,distance);
         List<String> temp=new ArrayList<>();
         temp.add(beginWord);
         dfs(beginWord,endWord,map,distance,temp,ans);
         return ans
;    }
    private static void dfs(String beginWord, String endWord, HashMap<String, List<String>> map,
                            HashMap<String, Integer> distance, List<String> temp, List<List<String>> ans)
    {
        if (beginWord.equals(endWord))
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        List<String> neighbors=map.get(beginWord);
        if (neighbors==null) return;
        for (String neighbor:neighbors)
        {
            if (distance.get(beginWord)+1==distance.get(neighbor)){
                temp.add(neighbor);
                dfs(neighbor,endWord,map,distance,temp,ans);
                temp.remove(temp.size()-1);
            }
        }
    }
    public static void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, List<String>> map,
                           HashMap<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean isFound = false;
        int depth = 0;
        Set<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                // 一次性得到所有的下一个的节点
                List<String> neighbors = getNeighbors(temp, dict);
                map.put(temp, neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor)) {
                        distance.put(neighbor, depth);
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                    }

                }
            }
            if (isFound) {
                break;
            }
        }


    }



}
