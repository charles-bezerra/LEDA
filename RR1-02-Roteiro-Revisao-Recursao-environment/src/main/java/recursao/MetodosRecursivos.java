package recursao;

public class MetodosRecursivos {
	private int calcularSomaArray(int[] array, int i) {
		int result = 0;

		if (i < array.length) {
			result = array[i] + calcularSomaArray(array, i + 1);
		}

		return result;
	}

	public int calcularSomaArray(int[] array){
		return calcularSomaArray(array, 0);
	}

	public long calcularFatorial(int n) {
		long result = 1;

		if (n != 0) {
			result = n * calcularFatorial(n-1);
		}

		System.out.println(n+"!" + " = " + result);
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;

		if (n != 1 && n != 2) {
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}

		return result;
	}

	private int countNotNull(Object[] array, int index) {
		int result = 0;
		if (index < array.length ) {
			if (array[index] != null) {
				result++;
			}
			result += countNotNull(array, index+1);
		}
		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNull(array, 0);
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;

		if (expoente != 0) {
			result = 2*potenciaDe2(expoente-1);
		}

		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if (n > 1) {
			result = razao + progressaoAritmetica(termoInicial, razao, n-1);
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;

		if (n > 1) {
			result = razao * progressaoGeometrica(termoInicial, razao, n - 1);
		}

		return result;
	}
}
