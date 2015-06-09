package com.kondeti.arrays;

/*
 * 
 Maximum difference between two elements such that larger element appears after the smaller number
 Given an array arr[] of integers, find out the difference between any two elements such that larger 
 element appears after the smaller number in arr[]. 

 Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). 
 If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)

 Method 3 (Another Tricky Solution)
 First find the difference between the adjacent elements of the array and store all differences in an auxiliary array diff[] of size n-1.
 Now this problems turns into finding the maximum sum subarray of this difference array.
 Thanks to Shubham Mittal for suggesting this solution.
 */
public class MaxDifference {

	public static int maxDiff(int[] a) {
		int maxDiff = 0;
		for (int i = 1; i < a.length; i++) {
			a[i - 1] = a[i] - a[i - 1];
		}
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i - 1] > 0) {
				a[i] = a[i] + a[i - 1];

				if (a[i] > maxDiff) {
					maxDiff = a[i];
				}
			}
		}
		return maxDiff;
	}

	public static void main(String[] args) {
		int[] a = { 10, 22, 5, 75, 65, 80 };
		System.out.println(MaxDifference.maxDiff(a));
	}
}
