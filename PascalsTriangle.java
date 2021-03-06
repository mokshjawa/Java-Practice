/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/


class Solution {
    public List<List<Integer>> generate(int numRows) 
    {
        List<List<Integer>> tgt = new ArrayList<>();
        
        for (int i = 1; i <= numRows; i++)
        {
            List<Integer> curr = new ArrayList<>();
            
            if (i == 1)
            {
                curr.add(1);
            }
            else
            {
                curr.add(1);
                
                if (i > 2)
                {
                    List<Integer> pastRow = tgt.get(i - 2);
                
                    for (int j = 1; j <= i - 2; j++)
                    {
                        curr.add(j, (pastRow.get(j-1) + pastRow.get(j)));
                    }   
                } 
                
                curr.add(1);
            }
            
            tgt.add(curr);
        }
        
        return tgt;
    }
}