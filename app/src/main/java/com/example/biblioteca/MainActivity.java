package com.example.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button btn;
    private ImageButton btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        progress = (ProgressBar)findViewById(R.id.pb);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn2.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();
            }
        });
        
        progress.setVisibility(View.INVISIBLE);
    }


    // Tarea Asíncrona.

    class Task extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

            progress.setVisibility(View.VISIBLE);
        }


        @Override
        protected String doInBackground(String... strings) {

            for(int i = 1; i < 10; i++)
            {
                try {
                    Thread.sleep(200);

                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }


        @Override
        protected void onPostExecute(String s) {

            progress.setVisibility(View.INVISIBLE);
            btn2.setVisibility(View.VISIBLE);
        }
    }

    public void git(View view){
        Intent intent = new Intent(this, github_act.class);
        startActivity(intent);
    }


}