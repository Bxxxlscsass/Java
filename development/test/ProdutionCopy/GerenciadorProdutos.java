package empresa;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorProdutos {
	private List<Produto> estoque;
	
	public GerenciadorProdutos() {
		this.estoque = new ArrayList<>();
	}
	
	public void adicionarProduto(String nome, double preco, int quantidade) {
		if (nome != null && !nome.trim().isEmpty() && preco > 0 && quantidade >= 0) {
			Produto novoProduto = new Produto(nome, preco, quantidade);
			estoque.add(novoProduto);
			System.out.println("======= Produto cadastrado com sucesso 100%! ======");
		} else {
			System.out.println("====== X Erro: Dados invaliddos para o produto cadastrado no sistema!======");
		}
	}
	
	public void listarProdutos() {
		if (estoque.isEmpty()) {
			System.out.println("O estoque está vazio, Adicionar produto no estoque!");
		} else {
			System.out.println("--- Estoque de Produtos no sistema! ---");
			for (Produto p : estoque) {
				System.out.println(p);
			}
			System.out.println("-------------------------");
		}
	}

}
