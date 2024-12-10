// Vista/LoginView.java
package views;
import javax.swing.*;
import models.AlumnoModel;
import controllers.LoginController;

public class Login extends JFrame {
    public JTextField txtUsername;      // Campo de texto para el usuario
    public JPasswordField txtPassword; // Campo de texto para la contraseña
    public JButton btnLogin;           // Botón para iniciar sesión

    public Login() {
        setTitle("Login");            // Título de la ventana
        setSize(300, 200);            // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Acción al cerrar
        setLayout(null);              // Layout personalizado

        // Etiqueta para el usuario
        JLabel lblUsername = new JLabel("Usuario:");
        lblUsername.setBounds(20, 30, 80, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(100, 30, 150, 25);
        add(txtUsername);

        // Etiqueta para la contraseña
        JLabel lblPassword = new JLabel("Contraseña:");
        lblPassword.setBounds(20, 70, 80, 25);
        add(lblPassword);

        // Campo de texto para la contraseña
        txtPassword = new JPasswordField();
        txtPassword.setBounds(100, 70, 150, 25);
        add(txtPassword);

        // Botón de login
        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBounds(100, 110, 150, 25);
        add(btnLogin);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AlumnoModel alumnoModel = new AlumnoModel(); // Crear instancia del modelo
                Login loginView = new Login();               // Crear instancia de la vista
                new LoginController(alumnoModel, loginView); // Vincular vista y modelo con el controlador

                loginView.setVisible(true); // Mostrar la ventana de login
            }
        });
    }
}
