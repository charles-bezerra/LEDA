package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {
	public int[] minAndMaxValue (Integer[] array) {
		int minValue = 0, maxValue = 0;

		if (array.length>0) {
			minValue = array[0];
			maxValue = minValue;
		}

		for (Integer integer : array) {
			if (integer > maxValue) {
				maxValue = integer;
			}
			if (integer < minValue) {
				minValue = integer;
			}

		}

		return new int[]{minValue, maxValue};
	}

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int[] values = minAndMaxValue(array);
		int minValue = values[0];
		int maxValue = values[1];

		if (minValue < maxValue) {
			int[] c = new int[maxValue-minValue+1];
			Integer[] b = new Integer[array.length];

			for (int i = 0; i < array.length; i++){
				c[array[i] - minValue] += 1;
			}

			for (int i = 1; i < c.length; i++) {
				c[i] += c[i-1];
			}

			for(int i = array.length-1; i >= 0; i--) {
				b[ c[array[i] - minValue ] - 1 ] = array[i];
				c[ array[i] - minValue ] -= 1;
			}

			System.arraycopy(b, 0, array, 0, b.length);
		}
	}
}
