/*
Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next number of days.

Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?

For example, if you know that prices for the next two days are , you should buy one share day one, and sell it day two for a profit of . If they are instead , no profit can be made so you don't buy or sell stock those days.

Function Description

Complete the stockmax function in the editor below. It must return an integer that represents the maximum profit achievable.

stockmax has the following parameter(s):

prices: an array of integers that represent predicted daily stock prices
*/

/*
     * Complete the 'maximumProfit' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY price as parameter.
     */

    public static long maximumProfit(List<Integer> price)
    {
        // Write your code here
        long tgt = 0L;
        int max = Integer.MIN_VALUE;

        for (int i = price.size() - 1; i >= 0; i--)
        {
            if (price.get(i) >= max)
            {
                max = price.get(i);
            }

            tgt += max - price.get(i);
        }

        return tgt;
    }

