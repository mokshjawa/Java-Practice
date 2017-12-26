/*
Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."

For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively. Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.

Note: If there are several possible values for h, the maximum one is taken as the h-index.
*/

// NOTE: could use bucket sort too, probably more efficent run time (O(n) vs. O(nlogn))

/*
Current Solution:
Runtime - O(nlogn)
Space - O(1)
*/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++)
        {
            if (citations[i] >= citations.length - i)
            {
                return citations.length - i;
            }
        }
        return 0;
    }
}

/*
Alternate solution (bucket sort)
Runtime - O(n)
Space - O(n)
*/

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];

        for (int c : citations) 
        {
            if (c >= n) 
            {
                buckets[n]++;
            } 
            else 
            {
                buckets[c]++;
            }
        }

        int count = 0;
        for (int i = n; i >= 0; i--)
        {
            count += buckets[i];
            if(count >= i)
            {
                return i;
            }
        }

        return 0;
    }
}