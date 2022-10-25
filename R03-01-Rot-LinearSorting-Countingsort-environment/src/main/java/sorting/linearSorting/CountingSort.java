package sorting.linearSorting;

import sorting.AbstractSorting;
import util.Util;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {
	private Integer getK(Integer[] array, int leftIndex, int rightIndex) {
		Integer max = array[0];
		for (int i = leftIndex; i <= rightIndex; i++)
			if (array[i].compareTo(max) > 0)
				max = array[i];
		return max;
	}

	private void countSort(Integer[] array, int leftIndex, int rightIndex) {
		Integer k = getK(array, leftIndex, rightIndex);

		int[] C = new int[k + 1];
		Integer[] B = new Integer[array.length];

		for (int i = leftIndex; i <= rightIndex; i++) {
			C[array[i]] += 1;
		}

		for (int i = 1; i < C.length; i++) {
			C[i] += C[i - 1];
		}

		for (int j = array.length - 1; j >= 0; j--) {
			B[C[array[j]] - 1] = array[j];
			C[array[j]] -= 1;
		}

		System.arraycopy(B, 0, array, 0, array.length);
	}

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array != null && array.length > 1) {
			countSort(array, leftIndex, rightIndex);
		}
	}

}
