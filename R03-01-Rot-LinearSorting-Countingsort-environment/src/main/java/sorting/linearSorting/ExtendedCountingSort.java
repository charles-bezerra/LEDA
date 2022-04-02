package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {
	public Integer foundMax (Integer[] array, int leftIndex, int rightIndex, Integer aux) {
		if (leftIndex <= rightIndex) {
			return foundMax(
					array,
					leftIndex+1,
					rightIndex,
					array[leftIndex] > aux  ? array[leftIndex] : aux
			);
		} else {
			return aux;
		}
	}

	public Integer foundMin (Integer[] array, int leftIndex, int rightIndex, Integer aux) {
		if (leftIndex <= rightIndex) {
			return foundMin(
					array,
					leftIndex+1,
					rightIndex,
					array[leftIndex] < aux  ? array[leftIndex] : aux
			);
		} else {
			return aux;
		}
	}

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > 0) {
			Integer max = foundMax(array, leftIndex, rightIndex, array[0]);
			Integer min = foundMin(array, leftIndex, rightIndex, array[0]);

			int[] C = new int[max - min + 1];
			Integer[] B = new Integer[array.length];

			for (int i = 0; i < C.length; i++) {
				C[i] = 0;
			}

			for (int i = 0; i < array.length; i++) {
				C[array[i] - min] += 1;
			}

			for (int i = 1; i < C.length; i++) {
				C[i] += C[i - 1];
			}

			for (int j = array.length - 1; j >= 0; j--) {
				B[C[array[j] - min] - 1] = array[j];
				C[array[j] - min] -= 1;
			}

			System.arraycopy(B, 0, array, 0, array.length);
		}
	}

}
