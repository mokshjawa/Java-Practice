/*
You are given a binary tree as a sequence of parent-child pairs. 
For example, the tree represented by the node pairs below:
(A,B) (A,C) (B,G) (C,H) (E,F) (B,D) (C,E)
Below is the recursive definition for the S-expression of a tree:
S-exp(node) = ( node->val 
(S-exp(node->first_child))(S-exp(node->second_child))), if node != NULL
                         = "", node == NULL 
   where, first_child->val < second_child->val (lexicographically smaller)

This tree can be represented in a S-expression in multiple ways. 

The lexicographically smallest way of expressing this is as follows:
(A(B(D)(G))(C(E(F))(H)))

We need to translate the node-pair representation into an S-expression 
(lexicographically smallest one), and report any errors that do not conform to the definition of a binary tree.
The list of errors with their codes is as follows:
Error Code          Type of error
E1                 More than 2 children
E2                 Duplicate Edges
E3                 Cycle present
E4                 Multiple roots
E5                 Any other error
*/

// Complete the SExpression function below.
    static String SExpression(String nodes)
    {
        boolean[][] graph = new boolean[26][26];
        Set<Character> node = new HashSet<>();

        boolean E2 = checkE2(nodes, graph, node);

        boolean E1 = checkE1(graph);

        if (E1)
        {
            return "E1";
        }
        else if (E2)
        {
            return "E2";
        }

        int numRoots = 0;
        char root = ' ';

        for (Character n : node)
        {
            for (int i = 0; i < 26; i++)
            {
                if (graph[i][n - 'A'])
                {
                    break;
                }

                if (i == 25)
                {
                    numRoots++;
                    root = n;

                    if (dfs(n, graph, new boolean[26]))
                    {
                        return "E3";
                    }
                }
            }
        }

        if (numRoots == 0)
        {
            return "E3";
        }
        else if (numRoots > 1)
        {
            return "E4";
        }
        else if (root == ' ')
        {
            return "E5";
        }

        return helper(root, graph);
    }

    private static char addIntChar(int x, char c)
    {
        return (char) (x + c);
    }

    private static boolean checkE1(boolean[][] graph)
    {
        for (int i = 0; i < 26; i++)
        {
            int count = 0;

            for (int j = 0; j < 26; j++)
            {
                if (graph[i][j])
                {
                    count++;
                }
            }

            if (count > 2)
            {
                return true;
            }
        }

        return false;
    }

    private static boolean checkE2(String nodes, boolean[][] graph, Set<Character> node)
    {
        for (int i = 1; i < nodes.length(); i += 6)
        {
            int parent = nodes.charAt(i) - 'A';
            int child = nodes.charAt(i + 2) - 'A';

            if (graph[parent][child])
            {
                return true;
            }

            graph[parent][child] = true;

            node.add(addIntChar(parent, 'A'));
            node.add(addIntChar(parent, 'A'));
        }

        return false;
    }

    private static boolean dfs(char node, boolean[][] graph, boolean[] visited)
    {
        if (visited[node - 'A'])
        {
            return true;
        }

        visited[node - 'A'] = true;

        for (int i = 0; i < 26; i++)
        {
            if (graph[node - 'A'][i])
            {
                if (dfs(addIntChar(i, 'A'), graph, visited))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static String helper(char root, boolean[][] graph)
    {
        String l = "";
        String r = "";

        for (int i = 0; i < 26; i++)
        {
            if (graph[root - 'A'][i])
            {
                l = helper(addIntChar(i, 'A'), graph);

                for (int j = i + 1; j < 26; j++)
                {
                    if (graph[root - 'A'][j])
                    {
                        r = helper(addIntChar(j, 'A'), graph);
                        break;
                    }
                }
                break;
            }
        }

        return "(" + root + l + r + ")";
    }

