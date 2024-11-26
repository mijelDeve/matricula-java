package controllers;

import models.MatriculaModel;

public class MatriculaController {

    // Método para manejar la lógica de matrícula
    public boolean registrarMatricula(int idAlumno, int idSeccion) {
        return MatriculaModel.registrarMatricula(idAlumno, idSeccion);
    }
}
