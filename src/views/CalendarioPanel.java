package views;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.HorarioModel;
import models.CursoCalendar;

public class CalendarioPanel extends JPanel {
    
    private List<CursoCalendar> cursosCalendar = new ArrayList<>();
    
    public CalendarioPanel() {
        setLayout(new GridLayout(1, 7));
        cargarHorarios(2); 
    }

    // Método para cargar los horarios
    public void cargarHorarios(int idAlumno) {
        try {
            cursosCalendar = new HorarioModel().obtenerHorariosAlumno(idAlumno);
            renderizarCalendario();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para renderizar los cursos en el calendario
    public void renderizarCalendario() {
        System.err.println("Volver a renderizar");
        removeAll();
        
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        Object[][] cursosPorDia = obtenerCursosPorDia(cursosCalendar);

        for (int i = 0; i < dias.length; i++) {
            JPanel diaPanel = new JPanel();
            diaPanel.setLayout(new BoxLayout(diaPanel, BoxLayout.Y_AXIS));
            diaPanel.setBorder(BorderFactory.createTitledBorder(dias[i])); // Título con el nombre del día

            // Añadir los cursos registrados debajo del día
            if (cursosPorDia[i].length > 0) {
                for (Object obj : cursosPorDia[i]) {
                    CursoCalendar curso = (CursoCalendar) obj;

                    // Crear un panel para cada curso
                    JPanel cursoPanel = new JPanel();
                    cursoPanel.setLayout(new BoxLayout(cursoPanel, BoxLayout.Y_AXIS));
                    cursoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Borde alrededor del curso
                    cursoPanel.setBackground(new Color(240, 240, 240)); // Fondo claro para distinguir

                    // Etiquetas del curso
                    JLabel nombreLabel = new JLabel(curso.getNombre());
                    JLabel seccionLabel = new JLabel("Sección: " + curso.getSeccion());
                    JLabel horaLabel = new JLabel("Hora: " + curso.getSeccion());

                    // Centrar las etiquetas
                    nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    seccionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                    horaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

                    // Añadir etiquetas al panel del curso
                    cursoPanel.add(nombreLabel);
                    cursoPanel.add(seccionLabel);
                    cursoPanel.add(horaLabel);

                    // Añadir el panel del curso al panel del día
                    diaPanel.add(Box.createVerticalStrut(5)); // Espaciado entre cursos
                    diaPanel.add(cursoPanel);
                }
            } else {
                // Agregar mensaje para días sin cursos
                JLabel noCursosLabel = new JLabel("Sin cursos");
                noCursosLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                diaPanel.add(noCursosLabel);
            }

            add(diaPanel);
        }

        // Actualizar la interfaz para mostrar los cambios
        revalidate();
        repaint();
    }

    // Método para obtener los cursos agrupados por día
    public Object[][] obtenerCursosPorDia(List<CursoCalendar> cursosCalendar) {
        Object[][] cursosPorDia = new Object[7][]; // 7 días: Lunes a Domingo

        // Inicializar las listas para cada día
        for (int i = 0; i < 7; i++) {
            cursosPorDia[i] = new Object[0]; // Inicializa el arreglo vacío para cada día
        }

        // Asignar los cursos a cada día según el valor de 'dia' en cada objeto CursoCalendar
        List<CursoCalendar>[] cursosPorDiaList = new List[7]; // Lista para agrupar los cursos por día
        for (int i = 0; i < 7; i++) {
            cursosPorDiaList[i] = new ArrayList<>();
        }

        // Agrupar los cursos por día
        for (CursoCalendar curso : cursosCalendar) {
            String dia = curso.getDia();

            switch (dia) {
                case "Lunes":
                    cursosPorDiaList[0].add(curso); // Lunes
                    break;
                case "Martes":
                    cursosPorDiaList[1].add(curso); // Martes
                    break;
                case "Miércoles":
                    cursosPorDiaList[2].add(curso); // Miércoles
                    break;
                case "Jueves":
                    cursosPorDiaList[3].add(curso); // Jueves
                    break;
                case "Viernes":
                    cursosPorDiaList[4].add(curso); // Viernes
                    break;
                case "Sábado":
                    cursosPorDiaList[5].add(curso); // Sábado
                    break;
                case "Domingo":
                    cursosPorDiaList[6].add(curso); // Domingo
                    break;
                default:
                    System.err.println("Día no reconocido: " + dia);
            }
        }

        // Convertir las listas en arreglos y asignarlos al arreglo cursosPorDia
        for (int i = 0; i < 7; i++) {
            List<CursoCalendar> cursosDelDia = cursosPorDiaList[i];
            cursosPorDia[i] = cursosDelDia.toArray(new Object[cursosDelDia.size()]);
        }

        return cursosPorDia;
    }
}
