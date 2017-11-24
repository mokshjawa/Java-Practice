/* 
given an undirected tree with N nodes (numbered from 1 to N), write a function to find the length of the longest path where all nodes have the same lable.

Input: A[] (length N) where A[i] = label value of (i + 1)th node
       E[] (length (N-1) * 2) where every pair represent undirected edge 
*/

class Solution {
    public int solution(int[] A, int[] E) {
        // write your code in Java SE 8
        int maxPath = 0;
        
        for (int i = 0; i < A.length; i++)
        {
           maxPath = Math.max(findLongestPath(i+1, A[i], A, E), maxPath);
           // System.out.println((i+1) + " max path : " + maxPath );
        }
        return maxPath;
    }
    
    public static int findLongestPath(int J, int label, int[] A, int[] E)
    {
        // int degree = numOccur(J, E);
        int[] connected = findConnectedNodes(J, E);
        // System.out.print(J + "'s Connections:");
        // printArray(connected);
        int maxPath = 0;
        
        for (int i = 0; i < connected.length; i++)
        {
            if (A[connected[i] - 1] == label)
            {
                int[] newE = removeUsedEdge(J, connected[i], E);
                maxPath = Math.max((1 + findLongestPath(connected[i], label, A, newE)), maxPath);
            }
        }
        
        return maxPath;
            
    }
    
    public static int[] removeUsedEdge(int J, int C, int[] E)
    {
        // System.out.print("Original array: ");
        // printArray(E);
        int[] tgt = new int[E.length - 2];
        int index = 0;
        
        for (int i = 0; i < E.length; i++)
        {
            if ((E[i] == J && i % 2 == 0 && E[i+1] == C) ||(E[i] == C && i % 2 == 0 && E[i+1] == J))
            {
                    // System.out.println("Found skipped edge!");
                    i++;
            }
            else
            {
               tgt[index] = E[i]; 
               index++;
            }
        }
        // System.out.print("Final array: ");
       //  printArray(tgt);
        return tgt;
    }
    
    public static int[] findConnectedNodes(int J, int[] E)
    {
        int[] tgt = new int[numOccur(J, E)];
        // System.out.println(J + " degree : " + tgt.length);
        int index = 0;
        
        for (int i = 0; i < E.length; i++)
        {
            if (E[i] == J)
            {
                if (i % 2 == 0)
                {
                    tgt[index] = E[i+1];
                }
                else
                {
                    tgt[index] = E[i-1];
                }
                index++;
            }
        }
        
        return tgt;
    }
    
    //public static int getLabel(int J, int[] A)
    
    public static int numOccur(int J, int[] E)
    {
        int counter = 0;
        for (int i = 0; i < E.length; i++)
        {
            if (J == E[i])
            {
                counter++;
            }
        }
        return counter;
    }
    
    /*
    public static void printArray(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + ", ");
        }
        System.out.println();
    }
    */
    
    // # occurences of node in E = degree of node
}


