package com.tarea.tareaempleadomvc.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.tarea.tareaempleadomvc.R;
import com.tarea.tareaempleadomvc.controlador.EmpleadoCursorAdapter;
import com.tarea.tareaempleadomvc.database.AdminBD;

public class QueryActivity extends AppCompatActivity {

    ListView listaAlumnos;
    Button btnConsultar;
    EditText etID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        listaAlumnos = (ListView) findViewById(R.id.list_alumnos);
        btnConsultar = (Button) findViewById(R.id.btn_consultar_consultar);
        etID = (EditText) findViewById(R.id.ct_id_consultar);

        AdminBD adminBD = new AdminBD(getApplicationContext());
        listaAlumnos.setAdapter(new EmpleadoCursorAdapter(getApplicationContext(), adminBD.getAllEmpleados(), 0));

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaAlumnos.setAdapter(new EmpleadoCursorAdapter(
                        getApplicationContext(),
                        adminBD.getEmpleadoById(etID.getText().toString()),
                        0));
            }
        });

    }
}