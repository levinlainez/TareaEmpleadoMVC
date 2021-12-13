package com.tarea.tareaempleadomvc.controlador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


import com.tarea.tareaempleadomvc.database.EmpleadoContract;
import com.tarea.tareaempleadomvc.R;

public class EmpleadoCursorAdapter extends CursorAdapter {

    public EmpleadoCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_empleado, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //referencias interfaz
        TextView nombre = (TextView) view.findViewById(R.id.tv_nombre);
        TextView apellido = (TextView) view.findViewById(R.id.tv_apellido);
        TextView edad = (TextView) view.findViewById(R.id.tv_grado);
        TextView direccion = (TextView) view.findViewById(R.id.tv_grupo);
        TextView puesto = (TextView) view.findViewById(R.id.tv_turno);

        //obtencion de datos BD
        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(EmpleadoContract.EmpleadoEntry.NOMBRE));
        @SuppressLint("Range") String lastname = cursor.getString(cursor.getColumnIndex(EmpleadoContract.EmpleadoEntry.APELLIDO));
        @SuppressLint("Range") String degree = cursor.getString(cursor.getColumnIndex(EmpleadoContract.EmpleadoEntry.EDAD));
        @SuppressLint("Range") String group = cursor.getString(cursor.getColumnIndex(EmpleadoContract.EmpleadoEntry.DIRECCION));
        @SuppressLint("Range") String turn = cursor.getString(cursor.getColumnIndex(EmpleadoContract.EmpleadoEntry.PUESTO));

        //asignar datos
        nombre.setText(name);
        apellido.setText(lastname);
        edad.setText("Edad: " + degree);
        direccion.setText("Direccion: " + group);
        puesto.setText("Puesto: " + turn);

    }
}
