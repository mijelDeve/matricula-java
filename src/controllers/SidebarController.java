package controllers;

import models.AlumnoModel;
import views.SidebarView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidebarController {
    private AlumnoModel alumnoModel;
    private SidebarView sidebarView;

    // Constructor que recibe AlumnoModel y SidebarView
    public SidebarController(AlumnoModel alumnoModel, SidebarView sidebarView) {
        this.alumnoModel = alumnoModel;
        this.sidebarView = sidebarView;

        // CARGAR DATOS DEL USUARIO EN EL SIDEBAR
        alumnoModel.cargarDatosAlumno(2);

        // Actualizar la vista con los datos del modelo
        updateView();

        // Configurar listeners para los botones
        sidebarView.getBtnMisDatos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMisDatos();
            }
        });

        sidebarView.getBtnMatricula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarMatricula();
            }
        });

        sidebarView.getBtnGestionPagos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarGestionPagos();
            }
        });
    }

    private void updateView() {
        sidebarView.getLblUsuario().setText(
            "Usuario: " + alumnoModel.getNombre() + " " + alumnoModel.getApellido()
        );
    }

    private void mostrarMisDatos() {
        JOptionPane.showMessageDialog(sidebarView, 
            "Nombre: " + alumnoModel.getNombre() + "\n" +
            "Apellido: " + alumnoModel.getApellido() + "\n" +
            "Email: " + alumnoModel.getEmail(),
            "Mis Datos",
            JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarMatricula() {
        JOptionPane.showMessageDialog(sidebarView, 
            "Funcionalidad de Matrícula no implementada aún.", 
            "Matrícula", 
            JOptionPane.WARNING_MESSAGE);
    }

    private void mostrarGestionPagos() {
        JOptionPane.showMessageDialog(sidebarView, 
            "Funcionalidad de Gestión de Pagos no implementada aún.", 
            "Gestión de Pagos", 
            JOptionPane.WARNING_MESSAGE);
    }
}
