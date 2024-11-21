package views;

import controllers.SidebarController;
import controllers.CursosController;
import models.AlumnoModel;

import javax.swing.*;
import java.awt.*;

public class frmPrincipal extends JFrame {
    private SidebarView sidebarView;
    private SidebarController sidebarController;

    public frmPrincipal() {
        setTitle("Aula Virtual - Formulario Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());

        // MODELO ALUMNO INICIALIZADO
        AlumnoModel alumnoModel = new AlumnoModel();
        // SIDEBAR VIEW INICIALIZADO
        sidebarView = new SidebarView();
        // SIDEBAR CONTROLLER INICIALIZADO
        sidebarController = new SidebarController(alumnoModel, sidebarView);

        // AGREGAMOS SIDEBAR
        add(sidebarView, BorderLayout.WEST);

        // PANEL DERECHO INICIALIZADO
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        // TABLA DE CURSOS INICIALIZADO
        CursosTable cursosTable = new CursosTable();
        contentPanel.add(cursosTable, BorderLayout.CENTER);
        contentPanel.add(new JLabel("Bienvenido al Aula Virtual"), BorderLayout.NORTH);

        // CONTROLADOR DE CURSOS INICIALIZADO Y CARGAR CURSOS
        CursosController cursosController = new CursosController(cursosTable);
        cursosController.cargarCursos();  // Cargar los cursos en la tabla

        add(contentPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new frmPrincipal());
    }
}
