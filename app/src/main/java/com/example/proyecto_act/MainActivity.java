package com.example.proyecto_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb);
        btn = (Button)findViewById(R.id.btn);

        pb.setVisibility(View.INVISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new Task().execute();

            }
        });
    }


    //Implementar el AsyncTask

    class Task extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {
            for(int i = 1; i<= 10; i++)
            {
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }



        @Override
        protected void onPostExecute(String s) {
            Intent i = new Intent(getBaseContext(), Menu_Act.class);
            startActivity(i);
        }
    }


    //Tarea pesada
    public void Hilo(View v)
    {
        for(int i = 1; i<= 10; i++)
        {
            try{
                Thread.sleep(2000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}