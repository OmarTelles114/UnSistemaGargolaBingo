import javax.swing.*;
import java.awt.*;

public class Configuracion extends JFrame {
    private MenuPrincipal menuPrincipal;
    private JButton selectedButton = null;

    public Configuracion(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        setTitle("Configuración de Patrones");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel patronesPanel = new JPanel(new GridLayout(8, 5, 5, 5));
        patronesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 1; i <= 38; i++) {
            JButton patronButton = new JButton("Patrón " + i);
            int patronNumero = i;
            patronButton.addActionListener(e -> {
                if (selectedButton != null) {
                    selectedButton.setBackground(null);
                }
                patronButton.setBackground(Color.LIGHT_GRAY);
                selectedButton = patronButton;
                seleccionarPatron(Patron.patronPorNumero(patronNumero));
            });
            patronesPanel.add(patronButton);
        }

        JButton btnVolver = new JButton("Volver al Menú");
        btnVolver.addActionListener(e -> {
            dispose();
            menuPrincipal.setVisible(true);
        });

        add(new JLabel("Seleccione un Patrón", SwingConstants.CENTER), BorderLayout.NORTH);
        add(new JScrollPane(patronesPanel), BorderLayout.CENTER);
        add(btnVolver, BorderLayout.SOUTH);
    }

    private void seleccionarPatron(boolean[][] patronEstructura) {
        Patron patron = new Patron(patronEstructura);
        menuPrincipal.setPatronSeleccionado(patron);
        JOptionPane.showMessageDialog(this, "Patrón seleccionado con éxito. Volviendo al menú principal.");
        dispose();
        menuPrincipal.setVisible(true);
    }
}