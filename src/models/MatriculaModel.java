package models;

import utils.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;


public class MatriculaModel {

    public static boolean registrarMatricula(int idAlumno, int idSeccion) {
        Connection connection = ConexionBD.getConnectionBD();
        if (connection != null) {
            try {
                // SQL para insertar la matrícula
                String query = "INSERT INTO Matricula (id_alumno, id_seccion, fecha_matricula) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, idAlumno);
                statement.setInt(2, idSeccion);
                
                // Usamos la fecha y hora actual
                Timestamp fechaActual = Timestamp.valueOf(LocalDateTime.now());
                statement.setTimestamp(3, fechaActual);

                int rowsInserted = statement.executeUpdate();
                statement.close();
                return rowsInserted > 0; // Retorna true si se insertó al menos una fila
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
