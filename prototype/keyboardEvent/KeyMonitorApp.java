import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMonitorApp extends JFrame implements KeyListener {

    private JTextArea textAreaLog;
    private JLabel statusLabel;

    public KeyMonitorApp() {
        // Configurações da janela
        setTitle("Monitor de Teclas (KeyListener)");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Rótulo de status na parte inferior
        statusLabel = new JLabel("Pressione teclas do teclado...", SwingConstants.CENTER);
        add(statusLabel, BorderLayout.SOUTH);

        // Área de texto para logs (em um ScrollPane para melhor visualização)
        textAreaLog = new JTextArea();
        textAreaLog.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaLog);
        add(scrollPane, BorderLayout.CENTER);

        // Adiciona o KeyListener ao componente que deve receber o foco.
        // Neste caso, a própria área de texto é o foco principal.
        textAreaLog.addKeyListener(this);

        // Torna a janela visível e garante que o foco esteja no textAreaLog
        setVisible(true);
        textAreaLog.requestFocusInWindow();
    }

    // Métodos obrigatórios da interface KeyListener:

    /**
     * Chamado quando uma tecla é pressionada (evento de pressionar físico).
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // Obtém o código virtual da tecla (ex: VK_A, VK_ENTER, VK_SHIFT)
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        
        statusLabel.setText("Tecla Pressionada: " + keyText + " (Código: " + keyCode + ")");
        System.out.println("Evento keyPressed: " + keyText);
    }

    /**
     * Chamado quando uma tecla é liberada (evento de soltar físico).
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // Geralmente usado para resetar estados, como quando a tecla SHIFT é liberada
        System.out.println("Evento keyReleased: " + KeyEvent.getKeyText(e.getKeyCode()));
    }

    /**
     * Chamado quando uma *tecla de caractere* é digitada. 
     * Ignora teclas de ação (F1, Shift, Ctrl, Alt).
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // Obtém o caractere Unicode gerado (ex: 'a', '1', '@')
        char keyChar = e.getKeyChar();
        String logMessage = "Caractere digitado: '" + keyChar + "'\n";
        
        // Adiciona a mensagem à área de log na GUI
        textAreaLog.append(logMessage);
        
        // Move o cursor para o final para mostrar o log mais recente
        textAreaLog.setCaretPosition(textAreaLog.getDocument().getLength());
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KeyMonitorApp();
            }
        });
    }
}
