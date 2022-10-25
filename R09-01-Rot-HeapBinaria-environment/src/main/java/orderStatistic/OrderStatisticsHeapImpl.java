package orderStatistic;

import java.util.PriorityQueue;

public class OrderStatisticsHeapImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Existem diversas formas de se calcular uma estatistica de ordem.
	 * Voce deve fazer isso usando uma heap restricoes:
	 * - nenhuma copia ou estrutura array auxiliar serah permitida, exceto o uso de
	 * uma PriorityQueue
	 * - caso a estatistica de ordem procurada nao exista no array o metodo deve
	 * retornar null
	 * 
	 * @param array
	 * @param k
	 * @return
	 */

	@Override
	public T getOrderStatistics(T[] array, int k) {
		T result = null;
		PriorityQueue<T> heap = new PriorityQueue<T>();

		for (T e : array) {
			heap.add(e);
		}

		if (k <= heap.size() && k > 0) {
			for (int i = 0; i < k; i++) {
				result = heap.remove();
			}
		}

		return result;
	}

}
