import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseTrackerApp extends JFrame implements MouseListener, MouseMotionListener {

    private JLabel statusLabel;
    private JPanel panel;

    public MouseTrackerApp() {
        // Configurações básicas da janela (JFrame)
        setTitle("Monitor de Eventos do Mouse");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Inicializa o painel e o rótulo de status
        panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        statusLabel = new JLabel("Aguardando ação do mouse...", SwingConstants.CENTER);

        // Adiciona os Listeners ao painel
        // O próprio objeto "this" (a janela/classe atual) implementa os métodos de listener
        panel.addMouseListener(this);
        panel.addMouseMotionListener(this);

        // Adiciona componentes à janela
        add(panel, BorderLayout.CENTER);
        add(statusLabel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    // Métodos obrigatórios da interface MouseListener:

    @Override
    public void mouseClicked(MouseEvent e) {
        statusLabel.setText("Clicou em: [" + e.getX() + ", " + e.getY() + "]");
        System.out.println("Evento: mouseClicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        statusLabel.setText("Pressionou o botão em: [" + e.getX() + ", " + e.getY() + "]");
        System.out.println("Evento: mousePressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        statusLabel.setText("Botão liberado em: [" + e.getX() + ", " + e.getY() + "]");
        System.out.println("Evento: mouseReleased");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        statusLabel.setText("Mouse entrou na área do painel.");
        panel.setBackground(Color.WHITE);
        System.out.println("Evento: mouseEntered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        statusLabel.setText("Mouse saiu da área do painel.");
        panel.setBackground(Color.LIGHT_GRAY);
        System.out.println("Evento: mouseExited");
    }

    // Métodos obrigatórios da interface MouseMotionListener:

    @Override
    public void mouseDragged(MouseEvent e) {
        statusLabel.setText("Arrastando em: [" + e.getX() + ", " + e.getY() + "]");
        System.out.println("Evento: mouseDragged");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        statusLabel.setText("Movendo para: [" + e.getX() + ", " + e.getY() + "]");
        // Este evento dispara muitas vezes, melhor não imprimir no console sempre.
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        // Garante que a GUI seja criada na thread de despacho de eventos da AWT (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MouseTrackerApp();
            }
        });
    }
}
