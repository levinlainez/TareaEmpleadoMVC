package com.tarea.tareaempleadomvc.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.tarea.tareaempleadomvc.R;
import com.tarea.tareaempleadomvc.controlador.EmpleadoCursorAdapter;
import com.tarea.tareaempleadomvc.database.AdminBD;

public class DeleteActivity extends AppCompatActivity {
    ListView listaEmpleadosD;
    EditText alumnoD;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        listaEmpleadosD = (ListView) findViewById(R.id.list_alumnos_eliminar);
        alumnoD = (EditText) findViewById(R.id.ct_id_eliminar);
        btnDelete = (Button) findViewById(R.id.btn_eliminar_alumno);

        AdminBD adminBD = new AdminBD(getApplicationContext());
        listaEmpleadosD.setAdapter(new EmpleadoCursorAdapter(getApplicationContext(), adminBD.getAllEmpleados(), 0));

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adminBD.eliminarEmpleado(alumnoD.getText().toString());
                listaEmpleadosD.setAdapter(new EmpleadoCursorAdapter(getApplicationContext(), adminBD.getAllEmpleados(), 0));

                Toast.makeText(
                        getApplicationContext(),
                        "El alumno con el id: " +alumnoD.getText().toString()+ " ha sido eliminado.",
                        Toast.LENGTH_LONG)
                        .show();
            }
        });

    }
}