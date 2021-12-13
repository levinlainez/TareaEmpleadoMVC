package com.tarea.tareaempleadomvc.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tarea.tareaempleadomvc.R;
import com.tarea.tareaempleadomvc.database.AdminBD;

public class UpdateActivity extends AppCompatActivity {
    EditText idActualizar;

    EditText nombre;
    EditText apellido;
    EditText grado;
    EditText grupo;
    EditText turno;

    Button btnActualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        //relacion de graficos con clase
        idActualizar = (EditText) findViewById(R.id.ct_id_actualizar);
        nombre = (EditText) findViewById(R.id.ct_nombre_act);
        apellido = (EditText) findViewById(R.id.ct_apellido_act);
        grado = (EditText) findViewById(R.id.ct_grado_act);
        grupo = (EditText) findViewById(R.id.ct_grupo_act);
        turno = (EditText) findViewById(R.id.ct_turno_act);
        btnActualizar = (Button) findViewById(R.id.btn_actualizar_act);

        AdminBD adminBD = new AdminBD(getApplicationContext());

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adminBD.actualizarEmpleado(idActualizar.getText().toString(),
                        nombre.getText().toString(),
                        apellido.getText().toString(),
                        grado.getText().toString(),
                        grupo.getText().toString(),
                        turno.getText().toString());
                Toast.makeText(getApplicationContext(), "Se ha actualizado el registro!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}