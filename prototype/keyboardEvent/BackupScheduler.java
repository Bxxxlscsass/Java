import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BackupScheduler {

    public static void main(String[] args) {
        // Diretório de origem que você quer fazer backup da função
        String origem = "C:\\Users\\efcosxp\\Documentos\\aaaa"; 
        // Diretório de destino (pode ser um pendrive ou drive de rede)
        String destino = "D:\\Backup\\Projetos_Backup"; 

        // Comando Robocopy para Windows:
        // /E: Copia subdiretórios, incluindo vazios
        // /Z: Copia arquivos em modo reiniciável (bom para grandes arquivos)
        // /MT: Usa multithreading para velocidade
        // /XD: Exclui diretórios especificados (opcional)
        String[] comandoBackup = {
            "CMD", "/C", "ROBOCOPY", 
            origem, destino, "/E", "/Z", "/MT:16"
        };

        try {
            System.out.println("Iniciando backup via Robocopy...");
            
            // Cria o processo para executar o comando do sistema
            ProcessBuilder pb = new ProcessBuilder(comandoBackup);
            pb.redirectErrorStream(true); // Redireciona erros para a saída padrão
            Process process = pb.start();

            // Capturar e imprimir a saída do comando em tempo real (para debug)
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar o processo terminar
            int exitCode = process.waitFor();
            System.out.println("\nBackup concluído com código de saída: " + exitCode);
            
            if (exitCode > 7) { // Códigos maiores que 7 no Robocopy indicam falhas graves
                System.err.println("O backup teve problemas graves ou erros de arquivo.");
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Erro ao executar o comando de backup: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
