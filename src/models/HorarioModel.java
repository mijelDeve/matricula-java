package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.ConexionBD;
import models.CursoCalendar;

public class HorarioModel {
    private String dia;
    private String horaInicio;
    private String horaFin;
    private SeccionesCursoModel curso;
    private String seccion;

    // Getters y Setters
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public SeccionesCursoModel getCurso() {
        return curso;
    }

    public void setCurso(SeccionesCursoModel curso) {
        this.curso = curso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public List<CursoCalendar> obtenerHorariosAlumno(int idAlumno) throws SQLException {
        List<CursoCalendar> cursosCalendar = new ArrayList<>();

        String query = "SELECT "
             + "h.dia, "
             + "h.hora_inicio, "
             + "c.nombre AS curso, "
             + "s.codigo_seccion "
             + "FROM Matricula m "
             + "JOIN Seccion s ON m.id_seccion = s.id_seccion "
             + "JOIN Horario h ON s.id_seccion = h.id_seccion "
             + "JOIN Curso c ON s.id_curso = c.id_curso "
             + "WHERE m.id_alumno = ?";

        try (Connection connection = ConexionBD.getConnectionBD();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idAlumno);
            ResultSet rs = ps.executeQuery();
            
            System.err.println("Resultado");

            while (rs.next()) {
                System.err.println(rs.getString("dia"));
                CursoCalendar curso = new CursoCalendar("","","");
                curso.setHora(rs.getString("hora_inicio"));
                curso.setNombre(rs.getString("curso"));
                curso.setSeccion(rs.getString("codigo_seccion"));
                curso.setDia(rs.getString("dia"));
                
                // Crear el objeto SeccionesCursoModel utilizando el constructor
                /*
                SeccionesCursoModel curso = new SeccionesCursoModel(
                    rs.getInt("id_seccion"),  // idSeccion
                    rs.getString("curso"),    // nombreCurso
                    rs.getString("codigo_curso"), // codigoCurso
                    rs.getInt("creditos"),    // creditos
                    rs.getString("codigo_seccion"), // codigoSeccion
                    rs.getInt("cupo")         // cupos
                );
                */
                
                // Establecer el curso en el objeto horario
                cursosCalendar.add(curso);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e);
            throw e; // Propagar la excepción si es necesario
        }

        return cursosCalendar;
    }
}
