package zyz.algorithm.list.medium;

/**
 * @author zyz
 * @title: 删除链表的倒数第 N 个结点
 * @seq: 05
 * @address: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/$
 * @idea: 考察快慢指针
 */
 class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next) {this.val=val;this.next=next;}
}
public class RemoveNode_05 {
    public static void main(String[] args) {
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 这种方法对于头节点的删除，只能通过创建一个空节点来删除
        ListNode pre=new ListNode();
        ListNode start=pre;
        pre.next=head;
        ListNode last=pre;
        while (n!=0)
        {
            n--;
            last=last.next;
        }

        while(last.next!=null){
            last=last.next;
            pre=pre.next;
        }
        pre.next=pre.next.next;
        return start.next;
    }
    //这个解法不好 没有使用一趟扫描实现
    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode node;
        int len=1;
        node=head;
        while (node.next!=null)
        {
            node=node.next;
            len++;
        }
        int k=len-n+1;//正数第k个节点

        if (k<0) throw new RuntimeException("链表长度不能小于n");
        if (k==1){
            head=head.next;
            return head;
        }
        node=head;
         int i=2;
         while (i<k){
             i++;
             node=node.next;
         }
        node.next=node.next.next;
        return head;
    }
}
