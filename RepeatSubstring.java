/*
find number of times A must be stated so B is a substring of it.
return -1 if B can never be substring
*/

class Solution {
    public int solution(String A, String B) {        
        String a2 = "";
        for (int i = 1; i <= ((B.length() / A.length()) + 1); i++)
        {
            a2 = a2 + A;
            if (a2.contains(B))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    /*
    public static boolean isSubstring(String x, String y)
    {
        for (int i = 0; i < x.length() - y.length(); i++)
        {
            if (x.substring(i, i + y.length()).equals(y))
            {
                return true;
            }
        }
        return false;
    }
    */
}