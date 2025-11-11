package com.example.practica18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw1 = (ListView) findViewById(R.id.listv1);
        lw1.setAdapter(new MyCustomAdapter(this));
        lw1.setOnItemClickListener((parent, view, position, id) -> {
            // Obtenemos el objeto Filas de la posición seleccionada
            Filas filaSeleccionada = (Filas) parent.getItemAtPosition(position);

            // Mostramos un Toast con la ciudad seleccionada
            String mensaje = "Ciudad: " + filaSeleccionada.titulo +
                    "\n" + filaSeleccionada.subtitulo;
            Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
        });

    }
}