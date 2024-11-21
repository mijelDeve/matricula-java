package controllers;

import models.CursoModel;
import views.CursosTable;

import java.util.List;

public class CursosController {
    private CursosTable cursosTable;

    public CursosController(CursosTable cursosTable) {
        this.cursosTable = cursosTable;
    }

    public void cargarCursos() {
        // Obtener los datos desde el modelo (puedes hacer la llamada a la base de datos aquí)
        List<CursoModel> cursos = CursoModel.cargarDatosCursos();
        
        // Pasar los cursos a la vista
        cursosTable.setCursos(cursos);
    }
}
