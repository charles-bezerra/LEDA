package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {
	private Integer getK(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = array[0];
		for (int i = leftIndex; i <= rightIndex; i++)
			if (array[i].compareTo(max) > 0)
				max = array[i];
		return max;
	}

	private Integer getMin(Integer[] array, int leftIndex, int rightIndex) {
		Integer min = array[0];
		for (int i = leftIndex; i <= rightIndex; i++)
			if (array[i].compareTo(min) < 0)
				min = array[i];
		return min;
	}

	private void extendedCountSort(Integer[] array, int leftIndex, int rightIndex) {
		Integer k = getK(array, leftIndex, rightIndex);
		Integer min = getMin(array, leftIndex, rightIndex);
		Integer[] B = new Integer[array.length];

		int[] C = new int[k - min + 1];

		for (int i = leftIndex; i <= rightIndex; i++) {
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

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 1) {
			extendedCountSort(array, leftIndex, rightIndex);
		}
	}
}
