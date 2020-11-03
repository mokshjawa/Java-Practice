// package whatever; // don't place package name!
import java.util.*;

/*

Given a big string and a list of small strings, 
find whether the big string can be represented
only by concatenation of smaller strings.

Example:
abccbacbb

abc
cc
ab
bac
b

True

*/

import java.io.*;

class MyCode {
  static Set<Integer> dp;
  
	public static void main (String[] args) {
		String big = "bacc";
    List<String> smallStrings = new ArrayList<>();
    smallStrings.add("abc");
    smallStrings.add("cc");
    smallStrings.add("ab");
    smallStrings.add("bac");
    smallStrings.add("b");
    
    dp = new HashSet<>();
    
    System.out.println(isConcatenation(big, smallStrings, 0));
	}
  
  public static boolean isConcatenation(String big, List<String> smallStrings, int index) {
    if (big.length() == index) {
      return true;
    }
    
    for (String small : smallStrings) {
      if (big.substring(index).indexOf(small) == 0) {
        int newIndex = index + small.length();
        
        if (!dp.contains(newIndex) && isConcatenation(big, smallStrings, newIndex)) {
          return true;
        }
      }
    }
    
    dp.add(index);
    return false;
  }
}
