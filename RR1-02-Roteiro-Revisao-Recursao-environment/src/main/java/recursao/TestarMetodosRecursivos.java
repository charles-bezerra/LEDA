package recursao;

public class TestarMetodosRecursivos {
	public static void main(String[] args) {
		MetodosRecursivos mr = new MetodosRecursivos();
		assert mr.calcularSomaArray(new int[]{5, 3, 4, 5}) == 17;
		assert mr.calcularFatorial(5) == 120;
		assert mr.countNotNull(new Integer[]{1, null, 2, 30, null}) == 2;

		assert mr.potenciaDe2(0) == 1;
		assert mr.potenciaDe2(2) == 4;
		assert mr.potenciaDe2(3) == 8;
		assert mr.potenciaDe2(4) == 16;

		assert mr.progressaoAritmetica(0, 3, 4) == 9;
		assert mr.progressaoAritmetica(1, 2, 3) == 5;

		assert mr.progressaoGeometrica(1, 3, 3) == 9;
	}
}
