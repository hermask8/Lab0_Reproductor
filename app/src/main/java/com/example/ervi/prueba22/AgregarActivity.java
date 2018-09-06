package com.example.ervi.prueba22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgregarActivity extends AppCompatActivity {

    public EditText nombre;
    public EditText duracion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nombre = (EditText)findViewById(R.id.etNombre);
        duracion = (EditText)findViewById(R.id.etDuracion);

    }

    public void MandarLista(View view)
    {
        Intent pasarVariables = new Intent(this,MainActivity.class);

        pasarVariables.putExtra("nombre",nombre.getText().toString());
        pasarVariables.putExtra("duracion",duracion.getText().toString());

        startActivity(pasarVariables);
    }


}
