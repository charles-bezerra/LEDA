package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

			@Override
			public void sort(T[] array, int leftIndex, int rightIndex) {
				if (leftIndex < rightIndex) {
					int minIndex = leftIndex;

					for (int j = leftIndex; j < rightIndex + 1; j++) {
						if (array[minIndex].compareTo(array[j]) > 0)
							minIndex = j;
					}

					if (leftIndex != minIndex)
						Util.swap(array, leftIndex, minIndex);

					sort(array, leftIndex + 1, rightIndex);
				}
			}

		@Override
		public void sort(T[] array) {
			sort(array, 0, array.length-1);
		}
}
