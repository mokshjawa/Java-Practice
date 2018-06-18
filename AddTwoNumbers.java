/*
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
       return addWithCarryOver(l1, l2, 0); 
    }
    
    public ListNode addWithCarryOver(ListNode l1, ListNode l2, int c)
    {
        if (l1 == null && l2 == null)
        {
            if (c == 0)
            {
                return null;
            }
            else
            {
                return new ListNode(c);
            }
        }
        else
        {
            int temp = c;
            int carryOver = 0;
            boolean null1 = false;
            boolean null2 = false;
            
            if (l1 != null)
            {
                temp += l1.val;
            }
            else
            {
                null1 = true;
            }
            
            if (l2 != null)
            {
                temp += l2.val;
            }
            else
            {
                null2 = true;
            }
            
            if (temp >= 10)
            {
                temp %= 10;
                carryOver = 1;
            }
            
            ListNode digit = new ListNode(temp);
            
            if (null1 || null2)
            {
                if (null1 && null2)
                {
                    digit.next = addWithCarryOver(null, null, carryOver);
                }
                else if (null1)
                {
                    digit.next = addWithCarryOver(null, l2.next, carryOver);
                }
                else if (null2)
                {
                    digit.next = addWithCarryOver(l1.next, null, carryOver);
                }
            }
            else
            {
                digit.next = addWithCarryOver(l1.next, l2.next, carryOver);
            }
            
            return digit;
        }
    }
}