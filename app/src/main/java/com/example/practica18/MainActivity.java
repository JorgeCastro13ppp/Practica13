package com.example.practica18;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lw1 = (ListView) findViewById(R.id.listv1);
        lw1.setAdapter(new MyCustomAdapter(this));
    }
}