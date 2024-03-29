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
		boolean varg = Util.isValidArgument(array, leftIndex, rightIndex);

		if (varg && leftIndex < rightIndex) {
			int i_smaller=leftIndex;

			for (int i = leftIndex; i <= rightIndex; i++)
				if (array[i].compareTo(array[i_smaller]) < 0)
					i_smaller = i;

			Util.swap(array, i_smaller, leftIndex);
			sort(array, leftIndex+1, rightIndex);
		}
	}
}
