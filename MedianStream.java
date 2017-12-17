/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
*/

import java.util.Collections;

class MedianFinder {

    private ArrayList<Integer> nums;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new ArrayList<Integer>();
    }
    
    public void addNum(int num) 
    {
        nums.add(num);
    }
    
    public double findMedian() 
    {
        Collections.sort(nums);
        if (nums.size() % 2 != 0)
        {
            return (double) nums.get(nums.size() / 2); 
        }
        else
        {
            double med = (double) (nums.get(nums.size() / 2) + nums.get((nums.size() / 2) - 1)) / 2;
            System.out.println((nums.get(nums.size() / 2)));
            System.out.println((nums.get(nums.size() / 2) - 1));
            return med;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */