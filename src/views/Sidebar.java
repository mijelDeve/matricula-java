package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sidebar extends JPanel {
    private JLabel lblUsuario;
    private JButton btnMisDatos;
    private JButton btnMatricula;
    private JButton btnGestionPagos;

    public Sidebar(String nombreUsuario) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(200, 300));

        lblUsuario = new JLabel("Usuario: " + nombreUsuario);
        lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 16));
        
        btnMisDatos = new JButton("Mis Datos");
        btnMatricula = new JButton("Matrícula");
        btnGestionPagos = new JButton("Gestión de Pagos");

        btnMisDatos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMatricula.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGestionPagos.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnMisDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Sidebar.this, "Mis Datos seleccionados");
            }
        });

        btnMatricula.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Sidebar.this, "Matrícula seleccionada");
            }
        });

        btnGestionPagos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Sidebar.this, "Gestión de Pagos seleccionada");
            }
        });

        add(lblUsuario);
        add(Box.createVerticalStrut(20));
        add(btnMisDatos);
        add(btnMatricula);
        add(btnGestionPagos);
    }
}
