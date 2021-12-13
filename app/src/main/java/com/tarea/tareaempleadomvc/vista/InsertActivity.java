package com.tarea.tareaempleadomvc.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tarea.tareaempleadomvc.R;
import com.tarea.tareaempleadomvc.database.AdminBD;
import com.tarea.tareaempleadomvc.modelo.Empleado;

public class InsertActivity extends AppCompatActivity {



    Button btnInsertar;
    EditText nombre;
    EditText apellido;
    EditText edad;
    EditText direccion;
    EditText puesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        btnInsertar = (Button) findViewById(R.id.btn_insert_alumno);
        nombre = (EditText) findViewById(R.id.ct_nombre);
        apellido = (EditText) findViewById(R.id.ct_apellido);
        edad = (EditText) findViewById(R.id.ct_grado);
        direccion = (EditText) findViewById(R.id.ct_grupo);
        puesto = (EditText) findViewById(R.id.ct_turno);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AdminBD adminBD = new AdminBD(getApplicationContext());
                SQLiteDatabase database = adminBD.getWritableDatabase();
                adminBD.guardarEmpleado(database, new Empleado(
                        nombre.getText().toString(),
                        apellido.getText().toString(),
                        edad.getText().toString(),
                        direccion.getText().toString(),
                        puesto.getText().toString()));

                Toast.makeText(getApplicationContext(), "Se agrego correctamente el registro!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}