package lv.vea.design.patterns.tasks.second;

import lv.vea.design.patterns.tasks.second.exceptions.EmptyArrayException;
import lv.vea.design.patterns.tasks.second.exceptions.UnsortedArrayException;

public class Search {

	/**
	 * Find the first occurrence of x in sorted array a.
	 * 
	 * @param x value to find
	 * @param a array sorted in increasing order (a[0] <= a[1] <= ... <= a[n-1])
	 * @return lowest i such that a[i]==x, or -1 if x not found in a.
	 */
	public static int find(int x, int[] a) {
		if (!isSorted(a)) {
			throw new UnsortedArrayException("Given array is not sorted");
		}
		return binarySearchOther(a, 0, a.length - 1, x);
	}

	public static int binarySearchOther(int[] a, int start, int end, int target) {
		int middle = (start + end) / 2;
		if (end < start) {
			throw new EmptyArrayException("Given array is empty");
		}

		if (target == a[middle]) {
			return middle;
		} else if (target < a[middle]) {
			return binarySearchOther(a, start, middle - 1, target);
		} else {
			return binarySearchOther(a, middle + 1, end, target);
		}
	}

	public static boolean isSorted(int[] data) {
		for (int i = 1; i < data.length; i++) {
			if (data[i - 1] > data[i]) {
				return false;
			}
		}
		return true;
	}
}
