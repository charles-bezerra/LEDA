package sorting.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	private Integer[] vetorTamanho1;
	private Integer[] vetorEsquerdaOrdenado;
	private Integer[] vetorDireitaOrdenado;
	private Integer[] vetorArbirtrario;
	private Integer[] vetorDecrescente;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		this.vetorTamanho1 = new Integer[] { 1 };
		this.vetorEsquerdaOrdenado = new Integer[] { 1, 2, 3, 5, 8, 15, 20, 10, 3, 50, 40 };
		this.vetorDireitaOrdenado = new Integer[] { 20, 10, 50, 30, 15, 21, 1, 2, 3, 6, 11 };
		this.vetorArbirtrario = new Integer[] { 1, 1, 1, 1, 3, 4, 5, 6, 5, 5, 2 };
		this.vetorDecrescente = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new QuickSortMedianOfThree<>();
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if (array.length > 0) {
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSort01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */

	@Test
	public void testSort06() {
		genericTest(vetorTamanho1);
	}

	@Test
	public void testSort07() {
		genericTest(vetorEsquerdaOrdenado);
	}

	@Test
	public void testSort08() {
		genericTest(vetorDireitaOrdenado);
	}

	@Test
	public void testSort10() {
		genericTest(vetorArbirtrario);
	}

	@Test
	public void testSort11() {
		genericTest(vetorDecrescente);
	}

	@Test
	public void testSort12() {
		Integer[] arr1 = new Integer[] { 2, 3, 1 };
		Integer[] arr2 = new Integer[] { 1, 3, 2 };
		Integer[] arr3 = new Integer[] { 3, 1, 2 };
		Integer[] arr4 = new Integer[] { 3, 2, 1 };
		Integer[] arr5 = new Integer[] { 2, 1, 3 };
		Integer[] arr6 = new Integer[] { 1, 2, 3 };

		Integer[] arrOrdenad = new Integer[] { 1, 2, 3 };

		implementation.sort(arr1);
		assertArrayEquals(arrOrdenad, arr1);

		implementation.sort(arr2);
		assertArrayEquals(arrOrdenad, arr2);

		implementation.sort(arr3);
		assertArrayEquals(arrOrdenad, arr3);

		implementation.sort(arr4);
		assertArrayEquals(arrOrdenad, arr4);

		implementation.sort(arr5);
		assertArrayEquals(arrOrdenad, arr5);

		implementation.sort(arr6);
		assertArrayEquals(arrOrdenad, arr6);
	}
}