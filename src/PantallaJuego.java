import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class PantallaJuego extends JFrame {
    private Tombola tombola;
    private Patron patron;
    private JTextArea historialArea;
    private JLabel bolaActual;
    private JLabel rectanguloBingo;
    private JButton btnSacarBola, btnVerificarCarta;
    private boolean juegoTerminado = false;

    public PantallaJuego(Patron patron) {
        this.patron = patron;
        this.tombola = new Tombola();
        setTitle("Juego de Bingo");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear panel superior para el rectángulo de Bingo y la bola
        JPanel panelSuperior = new JPanel(new BorderLayout());

        // Rectángulo de Bingo
        rectanguloBingo = new JLabel("BINGO", SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.setColor(Color.WHITE);
                g.setFont(new Font("Serif", Font.BOLD, 36));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent()) / 2;
                g.drawString(getText(), x, y);
            }
        };
        rectanguloBingo.setPreferredSize(new Dimension(800, 100));

        // Bola actual en la esquina superior derecha
        bolaActual = new JLabel("", SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillOval(0, 0, getWidth(), getHeight());
                g.setColor(Color.BLACK);
                g.drawOval(0, 0, getWidth(), getHeight());
                g.setFont(new Font("Serif", Font.BOLD, 24));
                FontMetrics fm = g.getFontMetrics();
                String texto = getText();
                int x = (getWidth() - fm.stringWidth(texto)) / 2;
                int y = (getHeight() + fm.getAscent()) / 2;
                g.drawString(texto, x, y);
            }
        };
        bolaActual.setPreferredSize(new Dimension(100, 100));
        bolaActual.setVisible(false);  // Inicialmente oculto

        // Panel para posicionar la bola en la esquina superior derecha
        JPanel panelBola = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBola.add(bolaActual);

        // Agregar rectángulo y panel de bola al panel superior
        panelSuperior.add(rectanguloBingo, BorderLayout.CENTER);
        panelSuperior.add(panelBola, BorderLayout.EAST);

        add(panelSuperior, BorderLayout.NORTH);

        historialArea = new JTextArea();
        historialArea.setEditable(false);
        add(new JScrollPane(historialArea), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(1, 4));

        btnSacarBola = new JButton("Sacar Bola");
        btnVerificarCarta = new JButton("Verificar Carta Potencial");
        btnVerificarCarta.setEnabled(false);

        JButton btnMostrarHistorial = new JButton("Mostrar Historial");
        JButton btnMenuPrincipal = new JButton("Menú Principal");

        btnSacarBola.addActionListener(e -> sacarBola());
        btnVerificarCarta.addActionListener(e -> verificarCarta());
        btnMostrarHistorial.addActionListener(e -> mostrarHistorial());
        btnMenuPrincipal.addActionListener(e -> volverMenuPrincipal());

        panelInferior.add(btnSacarBola);
        panelInferior.add(btnVerificarCarta);
        panelInferior.add(btnMostrarHistorial);
        panelInferior.add(btnMenuPrincipal);

        add(panelInferior, BorderLayout.SOUTH);
    }

    private void sacarBola() {
        if (juegoTerminado) return;

        int bola = tombola.sacarBola();

        if (bola == -1) {
            JOptionPane.showMessageDialog(this, "Todas las bolas han sido sacadas. El juego terminó.");
            btnSacarBola.setEnabled(false);
            juegoTerminado = true;
            return;
        }

        // Mostrar la bola por primera vez
        if (!bolaActual.isVisible()) {
            bolaActual.setVisible(true);
        }

        bolaActual.setText(String.valueOf(bola));
        historialArea.append("Bola sacada: " + bola + "\n");

        if (tombola.getHistorial().size() >= 4) {
            btnVerificarCarta.setEnabled(true);
        }
    }

    // Los demás métodos permanecen igual que en la implementación original
    private void mostrarHistorial() {
        JFrame historialFrame = new JFrame("Historial de Números");
        historialFrame.setSize(600, 400);
        historialFrame.setLayout(new BorderLayout());
        JPanel historialPanel = new JPanel(new GridLayout(8, 15, 2, 2));
        historialPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ArrayList<Integer> historialNumeros = tombola.getHistorial();
        for (int num = 1; num <= 75; num++) {
            JLabel label = new JLabel(String.valueOf(num), SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setOpaque(true);
            if (historialNumeros.contains(num)) {
                label.setBackground(Color.GREEN);
            } else {
                label.setBackground(Color.LIGHT_GRAY);
            }
            historialPanel.add(label);
        }

        historialFrame.add(historialPanel, BorderLayout.CENTER);
        historialFrame.setLocationRelativeTo(this);
        historialFrame.setVisible(true);
    }

    private void verificarCarta() {
        int[][] carta = generarCartaAleatoria();
        new VerificacionCarta(carta, tombola.getHistorial(), patron, this).setVisible(true);
    }

    private void volverMenuPrincipal() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que quieres volver al menú principal?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
            new MenuPrincipal().setVisible(true);
        }
    }

    private int[][] generarCartaAleatoria() {
        Random random = new Random();
        int[][] carta = new int[5][5];
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 75; i++) numeros.add(i);
        java.util.Collections.shuffle(numeros);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 2 && j == 2) {
                    carta[i][j] = 0; // Espacio libre
                } else {
                    carta[i][j] = numeros.remove(0);
                }
            }
        }
        return carta;
    }

    public void terminarJuego() {
        juegoTerminado = true;
        btnSacarBola.setEnabled(false);
        btnVerificarCarta.setEnabled(false);
    }
}