import javax.sound.sampled.*;

public class ListaDispositivosAudio {

    public static void main(String[] args) {
        System.out.println("--- Lista de Dispositivos de Áudio Disponíveis ---");
        
        // Obter informações de todos os mixers (dispositivos de áudio)
        Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();

        if (mixerInfos.length == 0) {
            System.out.println("Nenhum dispositivo de áudio encontrado.");
        } else {
            for (int i = 0; i < mixerInfos.length; i++) {
                Mixer.Info info = mixerInfos[i];
                System.out.println("\nDispositivo #" + (i + 1));
                System.out.println("  Nome:        " + info.getName());
                System.out.println("  Descrição:   " + info.getDescription());
                System.out.println("  Fabricante:  " + info.getVendor());
                System.out.println("  Versão:      " + info.getVersion());

                // Abrir o mixer para verificar as linhas de entrada/saída suportadas
                try {
                    Mixer mixer = AudioSystem.getMixer(info);
                    Line.Info[] sourceLines = mixer.getSourceLineInfo(); // Saída (Alto-falante/Fone)
                    Line.Info[] targetLines = mixer.getTargetLineInfo(); // Entrada (Microfone)
                    
                    if (sourceLines.length > 0) {
                        System.out.println("  Função:      Saída de Áudio (Playback)");
                    }
                    if (targetLines.length > 0) {
                        System.out.println("  Função:      Entrada de Áudio (Gravação)");
                    }
                    if (sourceLines.length == 0 && targetLines.length == 0) {
                         System.out.println("  Função:      Desconhecida/Outra");
                    }
                } catch (SecurityException | IllegalArgumentException e) {
                    System.out.println("  Acesso restrito.");
                }
            }
        }
    }
}
