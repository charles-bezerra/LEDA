package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			for (int j = 0; j < rightIndex; j++) {
				if( array[j].compareTo(array[j+1]) > 0 ) Util.swap(array, j, j+1);
			}
			sort(array, leftIndex+1, rightIndex);
		}
	}

	@Override
	public void sort(T[] array) {
		sort(array, 0, array.length-1);
	}
}
