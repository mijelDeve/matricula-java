package views;

import javax.swing.*;
import java.awt.*;

public class SidebarView extends JPanel {
    private JLabel lblUsuario;
    private JButton btnMisDatos;
    private JButton btnMatricula;
    private JButton btnGestionPagos;

    public SidebarView() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(200, 300));

        lblUsuario = new JLabel("Usuario: ");
        lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        
        btnMisDatos = new JButton("Mis Datos");
        btnMatricula = new JButton("Matrícula");
        btnGestionPagos = new JButton("Gestión de Pagos");

        btnMisDatos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGestionPagos.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(lblUsuario);
        add(Box.createVerticalStrut(20));
        add(btnMisDatos);
        add(btnMatricula);
        add(btnGestionPagos);
    }

    // Métodos de acceso para los botones
    public JButton getBtnMisDatos() {
        return btnMisDatos;
    }

    public JButton getBtnMatricula() {
        return btnMatricula;
    }

    public JButton getBtnGestionPagos() {
        return btnGestionPagos;
    }

    // Método de acceso para lblUsuario
    public JLabel getLblUsuario() {
        return lblUsuario;
    }
}
