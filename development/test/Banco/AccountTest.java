package empresa;

import java.util.Scanner;

public class AccountTest {

	public static void main(String[] args) {
		Account account1 = new Account("Jane Green", 50.00);
		Account account2 = new Account("jonh Blue", -7.53);
		
		//account balanco - saldo da conta do banco exibir
		System.out.printf("%s balance: $%.2f %n",
				account1.getName(),account1.getBalance());
		System.out.printf("%s balance: $%.2f %n%n",
				account2.getName(),account2.getBalance());
		
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Enter deposit amount for account1: "); // prompt
		double depositAmount = input.nextDouble();
		System.out.printf("%nadding %.2f to account1 balance%n%n",
				depositAmount);
		account1.deposit(depositAmount);
		
		//exibe saldos
		System.out.printf("%s balance: $%.2f %n",
				account1.getName(),account1.getBalance());
		System.out.printf("%s balance: $%.2f %n%n",
				account2.getName(),account2.getBalance());
		
		System.out.printf("enter deposit amopunt for account2: ");
		depositAmount = input.nextDouble();
		System.out.printf("%nadding %.2f to account2 balance%n%n",
				depositAmount);
		account2.deposit(depositAmount);
		
		System.out.printf("%s balance: $%.2f %n",
				account1.getName(),account1.getBalance());
		System.out.printf("%s balance: $%.2f %n%n",
				account2.getName(),account2.getBalance());
		

	}

}
