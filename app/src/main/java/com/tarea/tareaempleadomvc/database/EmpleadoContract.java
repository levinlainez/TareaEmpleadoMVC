package com.tarea.tareaempleadomvc.database;

import android.provider.BaseColumns;

public class EmpleadoContract {

    public static abstract class EmpleadoEntry implements BaseColumns{

        //PLANTILLA DE LA TABLA ALUMNOS

        public static final String TABLE_NAME = "EMPLEADO";

        public static final String NOMBRE = "NOMBRE";
        public static final String APELLIDO = "APELLIDO";
        public static final String EDAD = "EDAD";
        public static final String DIRECCION = "DIRECCION";
        public static final String PUESTO = "PUESTO";
    }
}
