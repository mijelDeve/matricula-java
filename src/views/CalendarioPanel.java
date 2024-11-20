package views;

import javax.swing.*;
import java.awt.*;

public class CalendarioPanel extends JPanel {
    public CalendarioPanel() {
        setLayout(new GridLayout(1, 7)); // Una fila para los días

        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        Object[][] cursosPorDia = {
            {new Curso("Matemáticas", "A", "8:00 AM")}, // Lunes
            {new Curso("Historia", "B", "10:00 AM"), new Curso("Ciencias", "C", "2:00 PM")}, // Martes
            {new Curso("Física", "A", "9:00 AM")}, // Miércoles
            {new Curso("Biología", "C", "11:00 AM")}, // Jueves
            {new Curso("Química", "B", "3:00 PM")}, // Viernes
            {}, // Sábado
            {}  // Domingo
        };

        for (int i = 0; i < dias.length; i++) {
            JPanel diaPanel = new JPanel();
            diaPanel.setLayout(new BoxLayout(diaPanel, BoxLayout.Y_AXIS));
            diaPanel.setBorder(BorderFactory.createTitledBorder(dias[i])); // Título con el nombre del día

            // Añadir los cursos registrados debajo del día
            if (cursosPorDia[i].length > 0) {
                for (Object obj : cursosPorDia[i]) {
                    Curso curso = (Curso) obj;

                    // Crear un panel para cada curso
                    JPanel cursoPanel = new JPanel();
                    cursoPanel.setLayout(new BoxLayout(cursoPanel, BoxLayout.Y_AXIS));
                    cursoPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // Borde alrededor del curso
                    cursoPanel.setBackground(new Color(240, 240, 240)); // Fondo claro para distinguir

                    // Etiquetas del curso
                    JLabel nombreLabel = new JLabel(curso.nombre);
                    JLabel seccionLabel = new JLabel("Sección: " + curso.seccion);
                    JLabel horaLabel = new JLabel("Hora: " + curso.hora);

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
    }

    // Clase auxiliar para manejar los datos del curso
    static class Curso {
        String nombre;
        String seccion;
        String hora;

        public Curso(String nombre, String seccion, String hora) {
            this.nombre = nombre;
            this.seccion = seccion;
            this.hora = hora;
        }
    }
}
