import javax.sound.sampled.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class AudioVolumeMonitor {

    public static void main(String[] args) {
        TargetDataLine line;
        
        try {
            // Define o formato de áudio desejado (PCM assinado, 44100 Hz, 16 bits, Mono)
            AudioFormat format = new AudioFormat(44100.0f, 16, 1, true, false);
            
            // Define a Info para o DataLine do tipo Target (entrada/gravação)
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);

            // Abre a linha de áudio padrão (microfone)
            line = (TargetDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start(); // Começa a capturar áudio

            System.out.println("Monitorando áudio do microfone... Pressione Ctrl+C para sair.");

            // Buffer para ler os dados do áudio
            int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
            byte[] buffer = new byte[bufferSize];

            while (true) {
                // Lê dados do microfone para o buffer
                int bytesRead = line.read(buffer, 0, buffer.length);

                if (bytesRead > 0) {
                    // Calcula o nível de volume a partir dos dados lidos
                    double volume = calculateVolume(buffer, bytesRead);
                    displayVolume(volume);
                }
            }

        } catch (LineUnavailableException e) {
            System.err.println("A linha de áudio não está disponível. Verifique seu microfone.");
            e.printStackTrace();
        }
    }

    /**
     * Calcula o nível de volume médio (RMS) a partir do buffer de bytes de áudio.
     * Assume formato de áudio PCM de 16 bits assinado.
     */
    private static double calculateVolume(byte[] audioBytes, int bytesRead) {
        long sum = 0;
        // Processa os bytes em pares (16 bits = 2 bytes por amostra)
        for (int i = 0; i < bytesRead; i += 2) {
            // Converte 2 bytes em um short (amostra de áudio)
            short sample = (short) ((audioBytes[i + 1] << 8) | (audioBytes[i] & 0xFF));
            sum += (long) sample * sample;
        }

        // Calcula a média quadrática (Root Mean Square - RMS)
        double rms = Math.sqrt(sum / (bytesRead / 2.0));
        
        // Retorna um valor de volume (amplitude média)
        return rms;
    }

    /**
     * Exibe visualmente o nível de volume no console.
     */
    private static void displayVolume(double volume) {
        // Mapeia o volume para uma escala simples (ex: 0 a 10000) para visualização
        int scale = (int) (volume / 200); 
        scale = Math.min(scale, 50); // Limita o tamanho da barra
        
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < scale; i++) {
            bar.append("#");
        }
        
        // Usa \r para reescrever a mesma linha do console (cria a ilusão de uma barra dinâmica)
        System.out.print("\rVolume: " + String.format("%.0f", volume) + " [" + bar + "]");
    }
}
