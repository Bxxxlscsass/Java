package empresa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class JogoDaForca {
	private Palavra palavra;
	private int tentativasRestantes;;
	private Set<Character> letrasErradas;
	private Scanner scanner;
	
	public JogoDaForca() {
		this.palavra = new Palavra();
		this.tentativasRestantes = 6;
		this.letrasErradas = new HashSet<>();
		this.scanner = new Scanner(System.in);
	}
	
	public void iniciar() {
		System.out.println("Bem vindo ao Jogo da Forca digite uma letra no sistema!");
		
		while (tentativasRestantes > 0 && !palavra.estaCompleta()) {
			desenharForca();
			System.out.println("\nPalavra: " + palavra);
			System.out.println("Letras erradas: " + letrasErradas);
			System.out.println("Tentativas restantes: " + tentativasRestantes);
			
			char palpite = pedirPalpite();
			processarPalpite(palpite);
		}
		
		finalizarJogo();
	}
	
	private char pedirPalpite() {
		while (true) {
			System.out.println("Digite uma letra: ");
			String entrada = scanner.next().trim().toUpperCase();
			
			if (entrada.length() == 1 && Character.isLetter(entrada.charAt(0))) {
				return entrada.charAt(0);
			} else {
				System.out.println("Entrada invalida. Digite apenas uma letra no jogo!");
			}
		}
	}
	
	private void processarPalpite(char palpite) {
		if (palavra.adivinharLetra(palpite)) {
			System.out.println("==== Voce acertou uma letra! ====");
		} else if (letrasErradas.contains(palpite)) {
			System.out.println("essa letra ja foi tentada! Preste atenção na palavra.");
		} else {
			System.out.println("letra incorreta.");
			letrasErradas.add(palpite);
			tentativasRestantes--;
		}
	}
	
	private void desenharForca() {
		System.out.println("\n+-----+");
		System.out.println("|    |");
		System.out.println(tentativasRestantes <= 5 ?"|  O" : "|");
		System.out.println(tentativasRestantes <= 4 ?"| /|\\" : (tentativasRestantes <= 3 ?"| /|" : (tentativasRestantes <= 2 ? "|  |" : "|")));
		System.out.println(tentativasRestantes <= 1 ?"| / \\" : (tentativasRestantes <= 0 ?"| / " : "|"));
		System.out.println("|");
		System.out.println("==============");
	}
	
	private void finalizarJogo() {
		desenharForca();
		if (palavra.estaCompleta()) {
			System.out.println("\n PARABENS! Voce adivinhou a palavra: " + palavra.getPalavraSecreta());
		} else {
			System.out.println("\n QUE PENA! Voce perdeu. A palavra secreta era: "+ palavra.getPalavraSecreta());
		}
		scanner.close();
	}

}

