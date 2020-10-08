package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class github_act extends AppCompatActivity {


    private Spinner spin1;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);
        getSupportActionBar().hide();

        spin1 = (Spinner) findViewById(R.id.spn);
        text = (TextView) findViewById(R.id.tv);

        String[] librosSpinner = {"Farenheit", "Revival", "El Alquimista"};
        final String[][] libros = {{"Farenheit","5000"},{"Revival", "12000"},{"El Alquimista", "4500"}};

        spin1.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, librosSpinner));

        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                for (int cont=0; cont < libros.length; cont++){
                    if (spin1.getSelectedItem().toString().equals(libros[cont][0])) {
                        text.setText("El valor de " + libros[cont][0] + " es de " + libros[cont][1]);

                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }
}