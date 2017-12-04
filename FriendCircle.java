class Solution {
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int total = 0;
        
        // initilializing all variables to false
        for (int i = 0; i < visited.length; i++)
        {
            visited[i] = false;
        }
        
        for (int a = 0; a < visited.length; a++)
        {
            // friend has not been visited yet
            if (!visited[a])
            {
                visitPerson(a, visited, M);
                total++;
            }
        }
        
        return total;
    }
    
   public void visitPerson(int a, boolean[] visited, int[][] M)
   {
        if (!visited[a])
        {
            visited[a] = true;
            for (int b = 0; b < M[a].length; b++)
            {
                if (a != b && M[a][b] == 1)
                {
                    visitPerson(b, visited, M);    
                }
            }
        }
    }
}