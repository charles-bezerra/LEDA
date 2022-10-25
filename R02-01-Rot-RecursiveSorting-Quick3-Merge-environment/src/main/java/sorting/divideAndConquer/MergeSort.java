package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private void merge(T[] array, int leftIndex, int rightIndex, int middle) {
		T[] helper = (T[]) new Comparable[rightIndex-leftIndex+1];
		
		int iHelper = 0;
		int i = leftIndex;
		int j = middle+1;

		while (i <= middle && j <= rightIndex) {
			if (array[i].compareTo(array[j]) <= 0) {
				helper[iHelper++] = array[i++]; 
			} else {
				helper[iHelper++] = array[j++];
			}
		}

		while (i <= middle) {
			helper[iHelper++] = array[i++];
		}

		while (j <= rightIndex) {
			helper[iHelper++] = array[j++];
		}

		iHelper = 0;

		for (int x = leftIndex; x <= rightIndex; x++) {
			array[x] = helper[iHelper++];
		}
	}	

	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex)/2;
			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle+1, rightIndex);
			merge(array, leftIndex, rightIndex, middle);
		}
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 1) {
			mergeSort(array, leftIndex, rightIndex);
		}
	}
}
