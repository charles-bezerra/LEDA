package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		boolean verify_arg = Util.isValidArgument(array, leftIndex, rightIndex);

		if (verify_arg && leftIndex <= rightIndex) {
			T key = array[leftIndex];
			int j = leftIndex;

			while (j > 0 && key.compareTo(array[j-1]) < 0) {
				Util.swap(array, j, j-1);
				j--;
			}

			sort(array, leftIndex+1, rightIndex);
		}
	}
}
