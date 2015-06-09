package com.kondeti.arrays;

import java.util.Arrays;

public class PythagoreanTriplet {

	public boolean isTriplet(int[] a) {
		if (a.length < 3)
			return false;
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			a[i] = a[i] * a[i];
		}

		for (int j = a.length - 1; j > -1; j--) {
			for (int k = 0, l = j - 1; k < l;) {
				if (a[k] + a[l] == a[j])
					return true;
				else if (a[k] + a[l] < a[j])
					k++;
				else
					l--;
			}

		}
		return false;
	}

	public static void main(String[] args) {
		int[] a = { 3, 1, 4, 6, 7 };
		PythagoreanTriplet pythagoreanTriplet = new PythagoreanTriplet();
		System.out.println(pythagoreanTriplet.isTriplet(a));
	}
}
