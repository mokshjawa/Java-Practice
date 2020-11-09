/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
  spend_per_day = [10,20,60,80,30,50,70,30,60] -> [60, 80, 30, 50, 70]
  58.0
  
  maximum-average subarray
  constraint: length >= 3
 
 */

class Solution {
  public static void main(String[] args) {
    int[] arr = new int[]{10,20,60,80,30,50,70,30,60};
    // expects 58.0
    System.out.println(findMaxAvgSubarray(arr, 3));
    
    arr = new int[]{10,20};
    // expects -infinity
    System.out.println(findMaxAvgSubarray(arr, 3));
    
    arr = new int[]{10,20,30};
    // expects 20
    System.out.println(findMaxAvgSubarray(arr, 3));
    
    arr = new int[]{100,20,60,80,30,50,70,30,60};
    // expects 65.0
    System.out.println(findMaxAvgSubarray(arr, 3));
  }
  
  public static double findMaxAvgSubarray(int[] nums, int k)   {
    int len = nums.length;
    double max = Double.NEGATIVE_INFINITY;
    int maxStart = 0;
    int maxEnd = -1;
    
    for (int i = 0; i <= len - k; i++) {
      double sum = 0;
      int counter = 0;
      
      // get first k - 1 elements
      while (counter < k - 1) {
        sum += nums[i + counter];
        counter++;
      }
      
      // go all the way to end and check every time
      while (i + counter < len) {
        sum += nums[i + counter];
        counter++;
        
        double newAvg = sum / counter;
        
        if (newAvg > max) {
          max = newAvg;
          maxStart = i;
          maxEnd = i + counter;
        }
      } 
    }
    
    System.out.println("(start, end): " + maxStart + ", " + maxEnd);
    
    return max;
  }
}