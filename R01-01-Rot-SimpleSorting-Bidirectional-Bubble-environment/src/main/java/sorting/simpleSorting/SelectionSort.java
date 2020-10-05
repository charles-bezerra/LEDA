package sorting.simpleSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex<rightIndex) {
			int minIndex = leftIndex;

			for (int j = leftIndex; j < rightIndex+1; j++) {
				if ( array[minIndex].compareTo(array[j]) > 0 )
					minIndex = j;
			}

			if (leftIndex != minIndex)
				Util.swap(array, leftIndex, minIndex);

			sort(array, leftIndex+1, rightIndex);
		}
	}

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length-1);
	}
}
