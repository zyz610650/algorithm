package zyz.algorithm.hot.txtop50;

/**
 * @author zyz
 * @title: 292. Nim 游戏
 * @seq: 292
 * @address: https://leetcode-cn.com/problems/nim-game/submissions/
 * @idea:
 * 我们继续推理，假设当前堆里只剩下五块、六块、或是七块石头，你可以控制自己拿取的石头数，总是恰好给你的对手留下四块石头
 *
 * 这的意思如果剩5 6 7 块我可以拿取对应的块数剩4个，这时候可以假设对手先手并且需要考虑一种策略使得能在这4块中取得胜利，前面得证
 * 如果刚好4块，先手的人必输，所以如果有5 6 7块那么自己必胜
 */
public class T292_304 {

	public boolean canWinNim(int n) {
		return n%4!=0;

	}
}
