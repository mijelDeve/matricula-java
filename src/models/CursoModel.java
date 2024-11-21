package models;

import utils.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoModel {
    private int id;
    private String nombre;
    private String codigo;
    private int creditos;

    // Constructor
    public CursoModel(int id, String nombre, String codigo, int creditos) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {
        return nombre;
    }

    // Método para cargar datos desde la base de datos
    public static List<CursoModel> cargarDatosCursos() {
        List<CursoModel> cursos = new ArrayList<>();
        String query = "SELECT id_curso, nombre, codigo, creditos FROM Curso";

        try (Connection connection = ConexionBD.getConnectionBD();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id_curso");
                String nombre = resultSet.getString("nombre");
                String codigo = resultSet.getString("codigo");
                int creditos = resultSet.getInt("creditos");

                // Crear una instancia de CursoModel y agregarla a la lista
                cursos.add(new CursoModel(id, nombre, codigo, creditos));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cursos;
    }
}
