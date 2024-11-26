package controllers;

import models.HorarioModel;
import java.sql.SQLException;
import java.util.List;
import models.CursoCalendar;

public class HorarioController {

    public List<CursoCalendar> obtenerHorariosAlumno(int idAlumno) {
        try {
            HorarioModel horarioModel = new HorarioModel();
            return horarioModel.obtenerHorariosAlumno(idAlumno);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
