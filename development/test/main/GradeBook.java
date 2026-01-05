package empresa;

public class GradeBook {
	private String courseName; //nome de curso que este livro de nota respresenta
	private int[][] grades; //array bidimensional de notas de aluno 
	
	//construtor de dois argumentos inicializando o java courseName e array de notas
	public GradeBook(String coursename, int[][] grades) {
		this.courseName = courseName;
		this.grades = grades;
	}
	
	//metodo para configurar o nome do curso 
	public void setCoursename(String courseName) {
		this.courseName = courseName;
	}
	
	//metodo para recuperar o nome do curso 
	public String getCourseName() {
		return courseName;
	}
	//realiza varias operaçoes nos dados 
	public void processGrades() {
		//gera saida de array de notas
		outputGrades();
		
		//chama metodos getMinimum e getMaximum
		System.out.printf("%n%s %d%n%s %d%n%n", 
				"Lowest grade in the grade book is", getMinimum(),
				"Highest grade in the grade book is", getMaximum());
		
		//gera a saida de grafico de distrubiação de notas de todas as notas
		outputBarChart();
	}
		
		//localiza nota minima
		public int getMinimum() {
			//supoe que o primeiro elemento de array de notas e menor 
			int lowGrade = grades[0][0];
			//faz um loop pelas linhas do array de notas 
			for (int[] studentGrades : grades) {
				//faz um loop pelas colunas da linha atual 
				for (int grade : studentGrades) {
					//se a nota for menor que lowGrade, atribui a nota a lowGrade
					if (grade < lowGrade)
						lowGrade = grade;
				}
			}
			return lowGrade;
		}
		//localiza a nota maxima 
		public int getMaximum() {
			int highGrade = grades[0][0];
			//faz um loop pelas linhas do array de notas
			for (int[] studentGrades : grades) {
				//faz um loop pelas colunas da linha atual 
				for (int grade : studentGrades) {
					//se a nota for maior que highGrade. atribui essa nota a highGrade
					if (grade > highGrade)
						highGrade = grade;
				}
		    }
			
			return highGrade;
	      	}
			//determiona a media do conjunto particular de notas
			public double getAverage(int[] setOfGrades) {
				int total = 0;
				
				//soma notas de um aluno
				for (int grade : setOfGrades)
					total += grade;
				//retorn media de notas
				return (double) total / setOfGrades.length;
			}
			
			//gera a saida grafica de barras para exibir distribuicao total de notas
			public void outputBarChart() {
				System.out.println("Overall grade distribution:");
				
				//armazena frequencia de notas em cada intervalo de 10 notas
				int[] frequency = new int[11];
				
				//para cada nota em GradeBook, incrementa a frequencia apropriada 
				for (int[] studentGrades : grades) {
					for (int grade : studentGrades) 
						++frequency[grade /10];
				}
				//para cada frequencia de nota, imprime barra grafico 
				for (int count = 0; count < frequency.length; count++) {
					//gera saida do rotulo de barra ("00-09:"...."90-99: "
					if (count == 10)
						System.out.printf("%5d: ", 100);
					else
						System.out.printf("%02d-%02d: ",
								count * 10, count * 10 + 9);
					
					// imprimi a barra de asteriscos
					for (int stars = 0; stars < frequency[count]; stars++) 
						System.out.printf("*");
					
					System.out.println();
				}
				
			}
			//gera saida do conteudo do array de notas
			public void outputGrades() {
				System.out.printf("The grades are:%n%n");
				System.out.printf("            "); //a linha titulos de coluna
				
				//cria titulos de coluna para cada um dos testes
				for (int test = 0; test < grades[0].length; test++)
					System.out.printf("Test %d ", test + 1);
				
				System.out.println("Average"); //titulo da coluna de media do aluno 
				
				//cria linhas/colunas de texto de que representa as notas de array 
				for (int student = 0; student < grades.length; student++) {
					System.out.printf("Student %2d", student + 1);
					
					for (int test : grades[student]) //gera saida de notas do array de estudantes
						System.out.printf("%8d", test);
					
					//chama metodo getAverage para calcular a media do aluno:
					//passa linha de notas como o argumento para getAverage
					double average = getAverage(grades[student]);
					System.out.printf("%9.2f%n", average);
				}
			}
	}
