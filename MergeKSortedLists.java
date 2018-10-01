/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) 
    {
        if (lists == null || lists.length == 0)
        {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2)
            {
                if (o1.val < o2.val)
                {
                    return -1;
                }
                else if (o1.val > o2.val)
                {
                    return 1;
                }
                else
                {
                    return 0;
                }
            }
        });
        
        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        
        for (ListNode l : lists)
        {
            if (l != null)
            {
                pq.offer(l);
            }
        }
        
        while (!pq.isEmpty())
        {
            tail.next = pq.poll();
            tail = tail.next;
            
            if (tail.next != null)
            {
                pq.offer(tail.next);
            }
        }
        
        return temp.next;
    }
}
