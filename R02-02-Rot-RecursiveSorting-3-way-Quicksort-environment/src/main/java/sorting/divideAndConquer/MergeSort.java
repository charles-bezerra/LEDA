package sorting.divideAndConquer;

import sorting.AbstractSorting;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	public void merge (T[] array, int leftIndex, int rightIndex, int middle) {
		ArrayList<T> auxArray = new ArrayList<T>(rightIndex-leftIndex);

		int i = leftIndex;
		int j = middle+1;

		int x = 0;

		while (i <= middle && j <= rightIndex) {
			if (array[i].compareTo( array[j] ) < 0 ) {
				auxArray.add(x++, array[i++]);
			}
			else {
				auxArray.add(x++, array[j++]);
			}
		}

		while (i <= middle) {
			auxArray.add(x++, array[i++]);
		}

		while (j <= rightIndex) {
			auxArray.add(x++, array[j++]);
		}

		x = 0;

		for (int r = leftIndex; r <= rightIndex; r++) {
			array[r] = auxArray.get(x++);
		}
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middle = (rightIndex+leftIndex)/2;

			sort(array, leftIndex, middle);
			sort(array, middle+1, rightIndex);

			merge(array, leftIndex, rightIndex, middle);
		}
	}
}
