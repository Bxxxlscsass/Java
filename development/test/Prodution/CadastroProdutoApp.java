package empresa;

import java.util.Scanner;

public class CadastroProdutoApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		GerenciadorProdutos gerenciador = new GerenciadorProdutos();
		int opcao = 0;
		
		while (opcao != 3) {
			System.out.println("\n==== Menu de cadastro de produto ====\n");
			System.out.println("1. Cadastrar novo produto no sistema");
			System.out.println("2. Listar Produtos cadastrados no sistema");
			System.out.println("3. Sair do pedido");
			System.out.println("\nEscolha o numero para seguir em diante com o cadastro:");
		    
			
			if (scanner.hasNext()) {
				opcao = scanner.nextInt();
				scanner.nextLine();
				
				switch (opcao) {
				case 1:
					System.out.println("Digite no sistema o nome do produto: ");
					String nome = scanner.nextLine();
					System.out.println("Digite no sistema o preço do produto (use virgula/ponto): R$ ");
					double preco = scanner.nextDouble();
					System.out.println("Digite no sistema a quatidade em estoque: ");
					int quantidade = scanner.nextInt();
					
					scanner.nextLine();
					
					gerenciador.adicionarProduto(nome, preco, quantidade);
					break;
				case 2:
					gerenciador.listarProdutos();
				case 3:
					System.out.println("Saindo do sistema!");
				default:
					System.out.println("Opção invalida. Por favor tente novamente no menu do programa!");
				}
			} else {
				System.out.println("Entrada invalida. Por favor, digite no sistema novamente!");
				scanner.nextLine();
			}
		}
		
		scanner.close();
		

	}

}
