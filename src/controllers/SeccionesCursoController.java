package controllers;

import java.util.List;
import models.SeccionesCursoModel;

public class SeccionesCursoController {

    public List<SeccionesCursoModel> obtenerSeccionesCurso() {
        return SeccionesCursoModel.cargarDatosSeccionesCurso();
    }
}
