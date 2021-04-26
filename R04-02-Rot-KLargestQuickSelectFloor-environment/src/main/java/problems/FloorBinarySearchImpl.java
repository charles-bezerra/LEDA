package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {
	private int partition(Integer[] array, int left, int right) {
		int pivot = left;
		int pivotValue = array[left];

		int j = pivot;

		for (int i = left+1; i<=right; i++) {
			if (array[i].compareTo(pivotValue) <= 0) {
				Util.swap(array, i, ++j);
			}
		}

		pivot=j;

		Util.swap(array, left, pivot);
		return pivot;
	}

	private void quickSort(Integer[] array, int left, int right) {
		if (left < right) {
			int pivot = partition(array, left, right);
			quickSort(array, left, pivot-1);
			quickSort(array, pivot+1, right);
		}
	}

	private Integer binarySearch (Integer[] array, int left, int right, Integer x, Integer y) {
		if (left <= right) {
			int middle = (left+right)/2;
			Integer middleValue = array[middle];

			if (middleValue.equals(x)) {
				return array[middle];
			}
			if (x.compareTo(middleValue) < 0) {
				return binarySearch(array, left, middle-1, x, null);
			}
			else {
				return binarySearch(array, middle+1, right, x, middleValue);
			}
		}
		else {
			return y;
		}
	}

	@Override
	public Integer floor(Integer[] array, Integer x) {
		quickSort(array, 0, array.length-1);
		return binarySearch(array, 0, array.length-1, x, null);
	}
}
