/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) 
    {
        List<List<Integer>> tgt = new ArrayList<>();
        backtrack(n, k, new ArrayList<>(), tgt);
        return tgt;
        
    }
    
    public void backtrack(int n, int k, List<Integer> temp, List<List<Integer>> res)
    {
        if (k == 0 || n == 0)
        {
            if (k == 0)
            {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        
        temp.add(n);
        backtrack(n - 1, k - 1, temp, res);
        temp.remove(temp.size() - 1);
        backtrack(n - 1, k, temp, res);
    }
}
