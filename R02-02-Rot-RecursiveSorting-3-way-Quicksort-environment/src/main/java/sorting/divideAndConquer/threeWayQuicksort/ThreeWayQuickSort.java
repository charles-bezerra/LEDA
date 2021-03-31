package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	private int[] partition (T[] array, int leftIndex, int rightIndex) {
		int i, j;

		int pivot = leftIndex;
		T pivotValue = array[pivot];
		i = leftIndex;

		for (int m = leftIndex+1; m <= rightIndex; m++) {
			if (array[m].compareTo(pivotValue) < 0) {
				Util.swap(array, m, ++i);
			}
		}

		Util.swap(array, pivot, i);

		pivotValue = array[i];
		j = i+1;

		for (int n = i+1; n <= rightIndex; n++) {
			if (array[n].compareTo(pivotValue) == 0) {
				Util.swap(array, n, j++);
			}
		}

		return new int[]{i, j};
	}

	private void quickSort (T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int[] middles = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, middles[0]-1);
			quickSort(array, middles[1]+1, rightIndex);
		}
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		quickSort(array, leftIndex, rightIndex);
	}

}
