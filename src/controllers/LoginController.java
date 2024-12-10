package controllers;

// Controlador/LoginController.java
import models.AlumnoModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.Login;
import views.frmPrincipal;

public class LoginController {
    private AlumnoModel alumnoModel;
    private Login loginView;

    public LoginController(AlumnoModel alumnoModel, Login loginView) {
        this.alumnoModel = alumnoModel;
        this.loginView = loginView;

        // Agregar acción al botón de login
        this.loginView.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String email = loginView.txtUsername.getText();
        String password = String.valueOf(loginView.txtPassword.getPassword());

        if (alumnoModel.login(email, password)) {
            JOptionPane.showMessageDialog(loginView, "¡Inicio de sesión exitoso!");
            loginView.dispose(); // Cerrar la ventana de login
            abrirFormularioPrincipal(); // Abre el formulario principal
        } else {
            JOptionPane.showMessageDialog(loginView, "Email o contraseña incorrectos.");
        }
    }

    private void abrirFormularioPrincipal() {
        frmPrincipal formularioPrincipal = new frmPrincipal();
        formularioPrincipal.setVisible(true);
    }
}
