package sorting.divideAndConquer.threeWayQuicksort;

import sorting.AbstractSorting;
import util.Util;

public class ThreeWayQuickSort<T extends Comparable<T>> extends AbstractSorting<T> {
	private void partition (T[] array, int leftIndex, int rightIndex, Integer pivoL, Integer pivoR) {
	}

	private void quickSort (T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			Integer pivoL = 0, pivoR = 0;
			partition(array, leftIndex, rightIndex, pivoL, pivoR);
			System.out.println(String.format("%o %o", new Integer[]{pivoL, pivoR}));
			leftIndex++;
//			quickSort(array, leftIndex, pivoL-1);
//			quickSort(array, pivoR+1, rightIndex);
		}
	}

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		quickSort(array, leftIndex, rightIndex);
	}

}
