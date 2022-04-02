package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			for (int i = 1; i <= rightIndex; i++) {
				if (array[i-1].compareTo(array[i]) >= 0) {
					Util.swap(array, i-1, i);
				}
			}

			sort(array, leftIndex+1, rightIndex);
		}
	}
}
