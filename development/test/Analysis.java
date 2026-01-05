package empresa;

//Analise dos resultados do exame utilizando instruções de controle aninhados 
import java.util.Scanner;

public class Analysis {

	public static void main(String[] args) {
		//criar um scanner para obter entrada a partir da janela de comando 
		Scanner input = new Scanner(System.in);
		
		//inicializando variaveis nas declaraçoes 
		int passes = 0;
		int failures = 0;
		int studentCounter = 1;
		
		// processa 10 alunos utilizando o loop controlado por contador
		while (studentCounter <= 10) {
			//solicita ao usuario uma entrada e obtem valor fornecido pelo  usuario
			System.out.println("Enter result (1 = pass, 2 = fail): ");
			int result = input.nextInt();
			
			//if..else esta aninhado no corpo a instrução while
			if (result ==1)
				passes = passes + 1;
			else 
				failures = failures + 1;
			
			//incrementa studentCounter ate o loop terminar
			studentCounter = studentCounter + 1;
		}
		// fase de termino: prepara e exibe o resultados
		System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);
		
		//determina se mais de 8 alunos foram aprovados
		if (passes > 8)
			System.out.println("Bonus to instructor!");
	}

}
