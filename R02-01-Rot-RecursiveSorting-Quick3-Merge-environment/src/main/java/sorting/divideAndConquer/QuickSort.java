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
	private int partition (T[] array, int leftIndex, int rightIndex) {
		int range = rightIndex - leftIndex + 1;
        int rand_pivot_index = (int)(Math.random() * range) + leftIndex;

        // troca o valor aleatório escolhido com a primeira posição
        Util.swap(array, leftIndex, rand_pivot_index);
		
		T pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}

		Util.swap(array, leftIndex, i);

		return i;
	}

	private void quickSort (T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivotIndex = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivotIndex-1);
			quickSort(array, pivotIndex+1, rightIndex);
		}
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 1) {
			quickSort(array, leftIndex, rightIndex);
		}
	}
}
