package models;

import utils.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlumnoModel {
    private int id;
    private String nombre;
    private String apellido;
    private String email;

    // Constructor vacío
    public AlumnoModel() {}

    // Constructor con los datos del alumno
    public AlumnoModel(int id, String nombre, String apellido, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método para obtener los datos del alumno desde la base de datos
    public void cargarDatosAlumno(int alumnoId) {
        Connection connection = ConexionBD.getConnectionBD();
        if (connection != null) {
            try {
                // SQL query para obtener los datos del alumno
                String query = "SELECT * FROM Alumno WHERE id_alumno = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, alumnoId);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    this.id = resultSet.getInt("id_alumno");
                    this.nombre = resultSet.getString("nombre");
                    this.apellido = resultSet.getString("apellido");
                    this.email = resultSet.getString("email");
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
     public boolean login(String email, String password) {
        System.out.println("Login");
        System.out.println(email);
        System.out.println(password);

       if (!email.equals(password)) {
            System.err.println("No coincide el email y password");
            return false;
        }
         
        Connection connection = ConexionBD.getConnectionBD();
        if (connection != null) {
            try {
                String query = "SELECT COUNT(*) FROM Alumno WHERE email = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, email);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0; // Retorna true si encuentra al alumno
                }
                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                System.err.println(e);
                e.printStackTrace();
            }
        }
        return false;
    }
}
