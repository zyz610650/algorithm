package zyz.algorithm.type.hash;

/**
 * @author zyz
 * @title: 实现 Trie (前缀树)
 * @seq: 208
 * @address: https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 * @idea:
 *
 */
public class ImplementPrefixTrie_TrieNode_179 {

	class Trie {
		int N=26;
		Trie[] children;
		boolean isEnd;
		public Trie() {
			children=new Trie[N];
			isEnd=false;
		}

		public void insert(String word) {
			char ch;
			Trie node=this;
			int index=0;
			for(int i=0;i<word.length();i++)
			{
				ch=word.charAt(i);
				index=ch-'a';
				if(node.children[index]==null)
				{
					node.children[index]=new Trie();
				}
				node=node.children[index];
			}
			node.isEnd=true;
		}

		public boolean search(String word) {

			Trie node=searchNode(word);
			return node!=null&&node.isEnd;
		}

		public boolean startsWith(String prefix) {
			Trie node = searchNode(prefix);
			return node!=null;
		}

		public Trie searchNode(String prefix)
		{
			char ch;
			Trie node=this;
			int index=0;
			for(int i=0;i<prefix.length();i++)
			{
				ch=prefix.charAt(i);
				index=ch-'a';
				if(node.children[index]==null)
				{
					return null;
				}
				node=node.children[index];
			}
			return node;
		}

	}
}
