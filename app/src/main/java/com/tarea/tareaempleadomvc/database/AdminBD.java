package com.tarea.tareaempleadomvc.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.tarea.tareaempleadomvc.database.EmpleadoContract.EmpleadoEntry;
import com.tarea.tareaempleadomvc.modelo.Empleado;

public class AdminBD extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "empleado.db";

    //Constructor de Sqlite
    public AdminBD(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    //OnCreate de SQLITE
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + EmpleadoContract.EmpleadoEntry.TABLE_NAME + " ("
                + EmpleadoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + EmpleadoEntry.NOMBRE + " TEXT NOT NULL,"
                + EmpleadoEntry.APELLIDO + " TEXT NOT NULL,"
                + EmpleadoEntry.EDAD + " TEXT NOT NULL,"
                + EmpleadoEntry.DIRECCION + " TEXT NOT NULL,"
                + EmpleadoEntry.PUESTO + " TEXT NOT NULL)");

        guardarEmpleado(sqLiteDatabase ,new Empleado( "Levin", "Mauricio", "29", "Valle", "Ingeniero"));
        guardarEmpleado(sqLiteDatabase ,new Empleado( "Maria", "Lopez", "19", "Choluteca", "Gerente"));
        guardarEmpleado(sqLiteDatabase ,new Empleado( "Francisco", "Mijares", "36", "Tegucigalpa", "Asistente"));
        guardarEmpleado(sqLiteDatabase ,new Empleado( "Fernando", "Rodriguez", "26", "San Pedro", "Recursos Humanos"));
        guardarEmpleado(sqLiteDatabase ,new Empleado( "Rosa", "Antonio", "29", "Choloma", "Secretaria"));
        guardarEmpleado(sqLiteDatabase ,new Empleado( "Beatriz", "Vazquez", "23", "Danli", "Supervisor"));
    }

    //On Upgrade  de SQLITE
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //GUARDAR ALUMNO
    public long guardarEmpleado(SQLiteDatabase db, Empleado empleado){
        return db.insert(
                EmpleadoEntry.TABLE_NAME,
                null,
                empleado.toContentValues());
    }

    //ELIMINAR ALUMNO
    public long eliminarEmpleado(String id){
        return getReadableDatabase()
                .delete(
                        EmpleadoEntry.TABLE_NAME,
                        EmpleadoEntry._ID + " = ?",
                        new String[]{id}
                        );
    }

    //ACTUALIZAR ALUMNO
    public long actualizarEmpleado(String id, String nombre, String apellido, String edad, String direccion, String puesto){

        ContentValues datos = new ContentValues();

        if (!nombre.equals("")){
            datos.put(EmpleadoEntry.NOMBRE, nombre);
        }
        if (!apellido.equals("")){
            datos.put(EmpleadoEntry.APELLIDO, apellido);
        }
        if (!edad.equals("")){
            datos.put(EmpleadoEntry.EDAD, edad);
        }
        if (!direccion.equals("")){
            datos.put(EmpleadoEntry.DIRECCION, direccion);
        }
        if (!puesto.equals("")){
            datos.put(EmpleadoEntry.PUESTO, puesto);
        }

        return getReadableDatabase()
                .update(EmpleadoEntry.TABLE_NAME,
                        datos,
                        EmpleadoEntry._ID + " = ?",
                        new String[]{id});
    }

    //OBTENER TODOS LOS ALUMNOS
    public Cursor getAllEmpleados(){
        return  getReadableDatabase()
                .query(
                        EmpleadoEntry.TABLE_NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null
                );
    }

    //OBTENER UN ALUMNO POR SU ID
    public  Cursor getEmpleadoById(String id){
        return getReadableDatabase()
                .query(
                        EmpleadoEntry.TABLE_NAME,
                        null,
                        EmpleadoEntry._ID + " LIKE ?",
                        new String[]{id},
                        null,
                        null,
                        null
                );
    }


}
