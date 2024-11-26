package views;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import controllers.SeccionesCursoController;
import models.SeccionesCursoModel;
import java.util.List;


public class CursosTable extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public CursosTable() {
        setLayout(new BorderLayout());

        String[] columnNames = {"Nombre Curso", "Código Curso", "Créditos", "Código Sección", "Cupos", "Acción"};

        // Configuración del modelo de tabla
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que solo la columna de botones sea editable
                return column == 5;
            }
        };

        TableColumn actionColumn = table.getColumnModel().getColumn(4);
        actionColumn.setCellRenderer(new ButtonRenderer());
        actionColumn.setCellEditor(new ButtonEditor(new JCheckBox()));

        cargarDatosEnTabla();

        JPanel combinedPanel = new JPanel(new GridLayout(2, 1));

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Sin margen en la tabla
        combinedPanel.add(scrollPane);

        CalendarioPanel calendarioPanel = new CalendarioPanel();
        calendarioPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); // Sin margen en el calendario
        combinedPanel.add(calendarioPanel);

        add(combinedPanel, BorderLayout.CENTER);
    }

   private void cargarDatosEnTabla() {
        SeccionesCursoController controller = new SeccionesCursoController();
        List<SeccionesCursoModel> seccionesCurso = controller.obtenerSeccionesCurso();

        for (SeccionesCursoModel sc : seccionesCurso) {
            Object[] rowData = {
                sc.getNombreCurso(),
                sc.getCodigoCurso(),
                sc.getCreditos(),
                sc.getCodigoSeccion(),
                sc.getCupos(),
                "Agregar" // Botón para agregar
            };
            tableModel.addRow(rowData);
        }
    }

    // Renderer para la columna de botones
    private static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    private static class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener((ActionEvent e) -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Acción del botón
                System.out.println("Curso agregado al horario: " + label);
                // Aquí puedes añadir la lógica para actualizar el calendario
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }
}
