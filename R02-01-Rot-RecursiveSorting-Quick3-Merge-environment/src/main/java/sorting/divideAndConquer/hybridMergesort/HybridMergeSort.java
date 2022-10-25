package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de
 * forma
 * que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados.
 * E a cada chamada
 * interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 * INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	private void insertionSort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			T key = array[i];
			int j = i - 1;

			while (j >= leftIndex && array[j].compareTo(key) > 0) {
				Util.swap(array, j + 1, j);
				j--;
			}
		}
	}

	private void merge(T[] array, int leftIndex, int rightIndex, int middle) {
		T[] helper = (T[]) new Comparable[rightIndex - leftIndex + 1];
		int iHelper = 0;
		int i = leftIndex;
		int j = middle + 1;

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

	private void hybridMergesort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			if ((rightIndex - leftIndex + 1) <= SIZE_LIMIT) {
				HybridMergeSort.INSERTIONSORT_APPLICATIONS++;
				insertionSort(array, leftIndex, rightIndex);
			} else {
				HybridMergeSort.MERGESORT_APPLICATIONS++;
				int middle = (leftIndex + rightIndex) / 2;
				hybridMergesort(array, leftIndex, middle);
				hybridMergesort(array, middle + 1, rightIndex);
				merge(array, leftIndex, rightIndex, middle);
			}
		}
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {
		HybridMergeSort.INSERTIONSORT_APPLICATIONS = 0;
		HybridMergeSort.MERGESORT_APPLICATIONS = 0;

		if (array != null && array.length > 1) {
			hybridMergesort(array, leftIndex, rightIndex);
		}
	}
}
