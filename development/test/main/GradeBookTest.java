package empresa;

public class GradeBookTest {

	public static void main(String[] args) {
		//array bidimensional de notas de aluno 
		int[][] gradesArray = {{87, 96, 70},
				               {68, 87, 90},
				               {94, 100, 90},
				               {100, 81, 82},
				               {83, 65, 85},
				               {78, 87, 65},
				               {85, 75, 83},
				               {91, 94, 100},
				               {76, 72, 84},
				               {87, 93, 73}};
		
		GradeBook myGradeBook = new GradeBook(
				"CS101 Introdution to Java Programming", gradesArray);
		System.out.printf("Welcome programming to the grade book for%n%s%n%n",
				myGradeBook.getCourseName());
		myGradeBook.processGrades();
	}
	
}//fim da classe GradeBookTest 


