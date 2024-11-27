import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private static Patron patronSeleccionado = null;
    private static boolean configuracionSeleccionada = false;

    public MenuPrincipal() {
        setTitle("Gárgola de Bingo");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Titulo más grande y centrado
        JLabel titulo = new JLabel("Sistema de Gárgola de Bingo", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(titulo, BorderLayout.NORTH);

        JPanel botonesPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(0, 50, 50, 50));

        JButton btnIniciar = new JButton("Iniciar");
        JButton btnConfiguracion = new JButton("Configuración");
        JButton btnSalir = new JButton("Salir");

        btnIniciar.addActionListener(e -> {
            if (!configuracionSeleccionada) {
                JOptionPane.showMessageDialog(this, "Primero debes seleccionar una configuración.",
                        "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                dispose();
                new PantallaJuego(patronSeleccionado).setVisible(true);
            }
        });

        btnConfiguracion.addActionListener(e -> {
            dispose();
            new Configuracion(this).setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));

        botonesPanel.add(btnIniciar);
        botonesPanel.add(btnConfiguracion);
        botonesPanel.add(btnSalir);

        add(botonesPanel, BorderLayout.CENTER);
    }

    public void setPatronSeleccionado(Patron patron) {
        patronSeleccionado = patron;
        configuracionSeleccionada = true;
    }

    public static Patron getPatronSeleccionado() {
        return patronSeleccionado;
    }

    public static boolean isConfiguracionSeleccionada() {
        return configuracionSeleccionada;
    }
}