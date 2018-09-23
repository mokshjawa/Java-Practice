/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3 
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*/

class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        if (amount <= 0)
        {
            return 0;
        }
        
        int[] mem = new int[amount + 1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        
        mem[0] = 0;
        
        for (int coin : coins)
        {
            for (int i = coin; i <= amount; i++)
            {
                if (mem[i - coin] != Integer.MAX_VALUE)
                {
                    mem[i] = Math.min(mem[i - coin] + 1, mem[i]);
                }
            }
        }
        
        return mem[amount] == Integer.MAX_VALUE ? -1 : mem[amount];
    }
}
