package zyz.algorithm.CharacterString.hard;



import java.util.*;

/**
 * @author zyz
 * @title: 单词接龙
 * @seq: 127
 * @address: https://leetcode-cn.com/problems/word-ladder/
 * @idea:
 */
public class WordLadder_124 {

    public static void main(String[] args) {

        String beginWord = "hit", endWord = "cog";
       String[] str=new String[] {"hot","dot","dog","lot","log","cog"};
//        String beginWord = "a", endWord = "c";
//        String[] str=new String[] {"a","b","c"};
        List<String> strings = Arrays.asList(str);

        System.out.println(ladderLength(beginWord,endWord,strings));
    }
    // bfs
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<String>();
        String newWord;
        boolean[] vis=new boolean[wordList.size()];
        int times=0;
        queue.add(beginWord);
        while(!queue.isEmpty())
        {
            times++;
           int size=queue.size();
//            System.out.println("次:"+times);
           for (int k=0;k<size;k++)
           {
               newWord=queue.poll();
//               System.out.println(newWord+" ");
               if(newWord.equals(endWord)) return times;
//               System.out.print("add: ");
               for(int i=0;i<wordList.size();i++)
               {

                   if(!vis[i]&&check(newWord,wordList.get(i)))
                   {
                       queue.add(wordList.get(i));
                       vis[i]=true;
//                       System.out.print(wordList.get(i)+" ");
                   }
               }
           }
//            System.out.println();
        }
        return 0;
    }

    static  boolean  check(String word1,String word2)
    {
        int n=0;
        for(int i=0;i<word1.length();i++)
        {
            if(word1.charAt(i)==word2.charAt(i)) n++;
        }
        if (n==word1.length()-1)
        return true;
        else return false;
    }

    // 改进 双向BFS
    public static int ladderLength4(String beginWord, String endWord, List<String> wordList)
    {
        int index=wordList.indexOf(endWord);
        if (index==-1) return 0;
        Queue<String> q1=new LinkedList<>();
        Queue<String> q2=new LinkedList<>();
        boolean[] vis1=new boolean[wordList.size()];
        boolean[] vis2=new boolean[wordList.size()];
        int count=0;
        q1.add(beginWord);
        q2.add(endWord);
        vis2[index]=true;

        while (!q1.isEmpty()&&!q2.isEmpty())
        {
            count++;
        if (q1.size()>q2.size())
        {
            Queue<String> tmp=q1;
            boolean[] vis_tmp=vis1;
            q1=q2;
            q2=tmp;

            vis1=vis2;
            vis2=vis_tmp;
        }
        int size=q1.size();

        for (int i=0;i<size;i++)
        {
            String word=q1.poll();

            for(int j=0;j<wordList.size();j++)
            {
                if (!vis1[j]&&check(word,wordList.get(j)))
                {
                    // 两端遍历相遇，结束遍历，返回 count
                    if (vis2[j])
                        return count+1;
                    q1.add(wordList.get(j));
                    vis1[j]=true;
                }
            }
        }

        }
        return 0;
    }

    // 用indexOf很耗时
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<String>();
        String newWord;
//        boolean[] vis=new boolean[wordList.size()];
        Set<String> vis=new HashSet<>();
        int times=0;
        queue.add(beginWord);
        Set<String> allWordSet = new HashSet<>(wordList);
        while(!queue.isEmpty())
        {
            times++;
            int size=queue.size();

            for (int k=0;k<size;k++)
            {
              newWord=queue.poll();
                if(newWord.equals(endWord)) return times;
              char[] chs=newWord.toCharArray();

                for(int i=0;i<chs.length;i++)
                {
                    char c=chs[i];
                    for(char ch='a';ch<='z';ch++)
                    {
                        chs[i]=ch;
                        String str=new String(chs);
                        if (allWordSet.contains(str)&&!vis.contains(str))
                        {
                            queue.add(str);
                            vis.add(str);
                        }
                    }
                    chs[i]=c;
                    // 这一块用indexOf就超时
//                    int t=wordList.indexOf(str);
//                    if (t!=-1&&!vis[t])
//                    {
//                        queue.add(str);
//                        vis[t]=true;
//                    }
                }
            }
//            System.out.println();
        }
        return 0;
    }



}
