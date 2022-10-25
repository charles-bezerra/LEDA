package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do
 * intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até
 * A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do
 * pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {
	private void orderPivot(T[] array, int leftIndex, int rightIndex) {
		int medianIndex = (leftIndex + rightIndex) / 2;

		if (array[leftIndex].compareTo(array[medianIndex]) > 0) {
			Util.swap(array, leftIndex, medianIndex);
		}
		if (array[medianIndex].compareTo(array[rightIndex]) > 0) {
			Util.swap(array, medianIndex, rightIndex);
		}
		if (array[leftIndex].compareTo(array[medianIndex]) > 0) {
			Util.swap(array, leftIndex, medianIndex);
		}
	}

	private int partition(T[] array, int leftIndex, int rightIndex) {
		T pivot = array[rightIndex];
		int i = rightIndex;
		for (int j = rightIndex - 1; j > leftIndex; j--) {
			if (array[j].compareTo(pivot) >= 0) {
				Util.swap(array, --i, j);
			}
		}
		Util.swap(array, rightIndex, i);
		return i;
	}

	private void quickSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			orderPivot(array, leftIndex, rightIndex);
			int pivotIndex = partition(array, leftIndex, rightIndex);
			quickSort(array, leftIndex, pivotIndex - 1);
			quickSort(array, pivotIndex + 1, rightIndex);
		}
	}

	public void sort(T[] array, int leftIndex, int rightIndex) {
		// if (array != null && array.length > 1) {
		// quickSort(array, leftIndex, rightIndex);
		// }
		orderPivot(array, leftIndex, rightIndex);
	}
}
