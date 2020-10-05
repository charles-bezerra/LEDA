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
		if (leftIndex < rightIndex) {
			T key = array[leftIndex];
			int i = leftIndex-1;

			while (i>=0 && key.compareTo(array[i]) < 0) {
				array[i+1] = array[i];
				array[i] = key;
				i--;
			}

			sort(array, leftIndex+1, rightIndex);
		}
	}

	@Override
	public void sort(T[] array) {
		sort(array, 1, array.length-1);
	}
}
