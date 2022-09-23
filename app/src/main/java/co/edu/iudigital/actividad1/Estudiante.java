package co.edu.iudigital.actividad1;

import com.orm.SugarRecord;

public class Estudiante extends SugarRecord {
    private String cedula;
    private String nombre;

    public Estudiante() {
    }

    public Estudiante(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
