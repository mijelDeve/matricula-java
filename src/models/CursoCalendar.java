package models;

public class CursoCalendar {
    String nombre;
    String seccion;
    String hora;
    String dia;

    public CursoCalendar(String nombre, String seccion, String hora) {
        this.nombre = nombre;
        this.seccion = seccion;
        this.hora = hora;
        this.dia = dia;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    
    public String getHora() {
        return hora;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }
    
    public String getDia() {
        return dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
