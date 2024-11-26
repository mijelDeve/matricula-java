package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.ConexionBD;


public class SeccionesCursoModel {
    private int idSeccion;
    private String nombreCurso;
    private String codigoCurso;
    private int creditos;
    private String codigoSeccion;
    private int cupos;

    // Constructor
    public SeccionesCursoModel(int idSeccion, String nombreCurso, String codigoCurso, int creditos, String codigoSeccion, int cupos) {
        this.idSeccion = idSeccion;
        this.nombreCurso = nombreCurso;
        this.codigoCurso = codigoCurso;
        this.creditos = creditos;
        this.codigoSeccion = codigoSeccion;
        this.cupos = cupos;
    }

    // Getters y setters
    public int getIdSeccion() {
        return idSeccion;
    }
    
    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }
    
    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public static List<SeccionesCursoModel> cargarDatosSeccionesCurso() {
        List<SeccionesCursoModel> seccionesCurso = new ArrayList<>();
        String query = """
            SELECT 
                c.nombre AS nombre_curso,
                c.codigo AS codigo_curso,
                c.creditos,
                s.id_seccion,
                s.codigo_seccion,
                s.cupo
            FROM 
                Curso c
            JOIN 
                Seccion s 
            ON 
                c.id_curso = s.id_curso
        """;

        try (Connection connection = ConexionBD.getConnectionBD();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String nombreCurso = resultSet.getString("nombre_curso");
                String codigoCurso = resultSet.getString("codigo_curso");
                int creditos = resultSet.getInt("creditos");
                String codigoSeccion = resultSet.getString("codigo_seccion");
                int cupos = resultSet.getInt("cupo");
                int idSeccion = resultSet.getInt("id_seccion");

                // Crear una instancia de SeccionesCursoModel y agregarla a la lista
                seccionesCurso.add(new SeccionesCursoModel(idSeccion, nombreCurso, codigoCurso, creditos, codigoSeccion, cupos));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return seccionesCurso;
    }
}
