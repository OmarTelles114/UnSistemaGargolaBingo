import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VerificacionCarta extends JFrame {
    public VerificacionCarta(int[][] carta, ArrayList<Integer> numerosSalidos, Patron patron, PantallaJuego pantallaJuego) {
        setTitle("Verificar Carta Potencial");
        setSize(600, 600);
        setLayout(new BorderLayout());

        JPanel cartaPanel = new JPanel(new GridLayout(6, 5));

        // Agregar encabezado de columnas B-I-N-G-O
        String[] letras = {"B", "I", "N", "G", "O"};
        for (String letra : letras) {
            JLabel label = new JLabel(letra, SwingConstants.CENTER);
            label.setFont(new Font("Serif", Font.BOLD, 18));
            cartaPanel.add(label);
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                JLabel label;
                if (i == 2 && j == 2) {
                    label = new JLabel("FREE", SwingConstants.CENTER);
                    label.setBackground(Color.GREEN);
                } else {
                    label = new JLabel(String.valueOf(carta[i][j]), SwingConstants.CENTER);
                    label.setBackground(numerosSalidos.contains(carta[i][j]) ? Color.GREEN : Color.LIGHT_GRAY);
                }

                label.setOpaque(true);
                label.setFont(new Font("Serif", Font.BOLD, 16));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cartaPanel.add(label);
            }
        }

        add(cartaPanel, BorderLayout.CENTER);

        boolean victoria = patron.verificarPatron(carta, numerosSalidos);

        JPanel botonesPanel = new JPanel();
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> {
            if (victoria) {
                pantallaJuego.terminarJuego();
                JOptionPane.showMessageDialog(this, "¡La carta ha ganado!");
            }
            dispose();
        });

        botonesPanel.add(btnCerrar);
        add(botonesPanel, BorderLayout.SOUTH);
    }
}