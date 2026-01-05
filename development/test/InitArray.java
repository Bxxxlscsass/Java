package empresa;

public class InitArray {

	public static void main(String[] args) {
		
		final int ARRAY_LENGTH = 10; //declarar constante
		int[] array = new int[ARRAY_LENGTH]; //cria o array 
		
		//calcular o valor do array
		for (int counter = 0; counter < array.length; counter++)
			array[counter] = 2 + 2 * counter;
		
		System.out.printf("%s%8s%n", "Index", "Value"); //titulos de colunas
		
		//gera saida do valor de cada elemento do array 
		for (int counter =0; counter < array.length; counter++)
			System.out.printf("%5d%8d%n", counter, array[counter]);

	}

}

