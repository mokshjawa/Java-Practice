/*
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i. Solve it without using division and in O(n) time.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
*/

public class ProductArray
{
	public static void main(String[] args)
	{
		int[] array = {1, 2, 3, 4, 5};
		printArray(prodArray(array));
	}

	public static int[] prodArray(int[] array)
	{
		int n = array.length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] product = new int[n];

		left[0] = 1;
		right[n - 1] = 1;

		for (int i = 1; i < n; i++)
		{
			left[i] = left[i - 1] * array[i - 1];
		}

		for (int j = n - 2; j >= 0; j--)
		{
			right[j] = right[j + 1] * array[j + 1];
		}

		for (int p = 0; p < n; p++)
		{
			product[p] = left[p] * right[p];
		}

		return product;
	}

	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
} 