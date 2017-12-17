/*
Cracking the Coding Interview: Problem 1.1
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
*/

/*
Note that doing without any additional data structures would likely require either brute force (check for every letter if it matches to 
another letter) or by sorting the String (provided the input could be manipulated) and then comparing neighboring elements for equality
*/

class Solution
{
	public boolean isUnique(String s)
	{
		if (s.length() > 256)
		{
			return false;
		}
		// only 256 unique characters possible

		boolean[] appeared = new boolean[256];

		for (int i = 0; i < s.length(); i++)
		{
			int value = s.charAt(i);
			if (appeared[value])
			{
				return false;
				// we know its already appeard
			}
			appeared[value] = true;
		}
		return true;
	}
}