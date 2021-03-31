package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {
	public int partition (T[] array, int leftIndex, int right) {
		int pivot = leftIndex;
		T pivotValue = array[pivot];
		int i = leftIndex;

		for (int j = leftIndex+1; j <= right; j++) {
			if ( array[j].compareTo(pivotValue) <= 0 ) {
				Util.swap(array, j, ++i);
			}
		}

		Util.swap(array, pivot, i);

		return i;
	}

	public void quickSort (T[] array, int leftIndex, int rightIndex) {
		if ( leftIndex < rightIndex ) {
			int pivot = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivot-1);
			quickSort(array, pivot+1, rightIndex);
		}
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		quickSort(array, leftIndex, rightIndex);
	}
}
