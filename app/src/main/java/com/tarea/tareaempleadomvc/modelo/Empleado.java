package com.tarea.tareaempleadomvc.modelo;

import android.content.ContentValues;

import com.tarea.tareaempleadomvc.database.EmpleadoContract;

public class Empleado {

    //Atributros
    private String nombre;
    private String apellido;
    private String edad;
    private String Direccion;
    private String puesto;

    //inicializacion - constructor
    public Empleado(String name, String lastname, String edad, String direccion, String puesto){
        this.nombre = name;
        this.apellido = lastname;
        this.edad = edad;
        this.Direccion = direccion;
        this.puesto = puesto;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        this.Direccion = direccion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public ContentValues toContentValues(){
        ContentValues contenedor = new ContentValues();
        contenedor.put(EmpleadoContract.EmpleadoEntry.NOMBRE, nombre);
        contenedor.put(EmpleadoContract.EmpleadoEntry.APELLIDO, apellido);
        contenedor.put(EmpleadoContract.EmpleadoEntry.EDAD, edad);
        contenedor.put(EmpleadoContract.EmpleadoEntry.DIRECCION, Direccion);
        contenedor.put(EmpleadoContract.EmpleadoEntry.PUESTO, puesto);
        return  contenedor;
    }
}
