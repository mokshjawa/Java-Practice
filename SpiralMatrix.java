/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*?

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        List<Integer> tgt = new ArrayList<>();
        
        if (matrix.length == 0)
        {
            return tgt;
        }
        
        int minRow = 0;
        int maxRow = matrix.length - 1;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;
        
        int index = 0;
        int total = matrix.length * matrix[0].length;
        
        while (index < total)
        {
            for (int i = minCol; i <= maxCol; i++)
            {
                tgt.add(matrix[minRow][i]);
                index++;
            }
            
            for (int i = minRow + 1; i <= maxRow; i++)
            {
                tgt.add(matrix[i][maxCol]);
                index++;
            }
            
            if (index >= total)
            {
                break;
            }
            
            for (int i = maxCol - 1; i >= minCol; i--)
            {
                tgt.add(matrix[maxRow][i]);
                index++;
            }
            
            for (int i = maxRow - 1; i > minRow; i--)
            {
                tgt.add(matrix[i][minCol]);
                index++;
            }
            
            minRow++;
            maxRow--;
            minCol++;
            maxCol--;
        }
        
        return tgt;   
    }
}
