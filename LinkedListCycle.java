/*
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
        {
            return false;
        }
        
        HashSet<ListNode> visited = new HashSet<>();
        
        for (ListNode i = head; i != null; i = i.next)
        {
            if (visited.contains(i))
            {
                return true;
            }
            else
            {
                visited.add(i);
            }
        }
        
        return false;
        
    }
}