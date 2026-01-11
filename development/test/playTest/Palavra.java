package empresa;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Palavra {
	private String palavraSecreta;
	private char[] letrasAdivinhadas;
	private List<String> bancoDePalavras = Arrays.asList("JAVA", "PROGRAMACAO", "DESENVOLVEDOR", "POLIMORFISMO", "ORIENTACAOOBJETOS", "BACKEND", "FULLSTACK");
	
	
	public Palavra() {
		selecionarPalavraAleatoria();
		this.letrasAdivinhadas = new char[palavraSecreta.length()];
		Arrays.fill(letrasAdivinhadas, '_');
	}
	
	private void selecionarPalavraAleatoria() {
		Random random = new Random();
		this.palavraSecreta = bancoDePalavras.get(random.nextInt(bancoDePalavras.size()));	
	}
	
	public boolean adivinharLetra(char letra) {
		boolean acertou = false;
		for (int i = 0; i < palavraSecreta.length(); i++) {
			if (palavraSecreta.charAt(i) == letra) {
				letrasAdivinhadas[i] = letra;
				acertou = true;
 			}
		}
		return acertou;
	}
	
	public boolean estaCompleta() {
		for (char c : letrasAdivinhadas) {
			if (c == '_') {
				return false;
			}
		}
		return true;
	}
	public String getPalavraSecreta() {
		return palavraSecreta;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (char c : letrasAdivinhadas) {
			builder.append(c).append(" ");
		}
		
		return builder.toString().trim();
		}

}
