package com.example.proyecto_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_Act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_);


        vf = (ViewFlipper)findViewById(R.id.slider);


        //iterar mi función del slider
        for(int i= 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        //Vamos a dar la configuración al Slider
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);


        vf.addView(view);  //Añadimos la imagen
        vf.setFlipInterval(2300); // Sudesplazamiento será de 2300 milis
        vf.setAutoStart(true);   // Iniciar de forma automática

        //Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Maps(View v)
    {
        Intent i = new Intent(this, Maps_Act.class);
        startActivity(i);
    }

    public void Info(View v)
    {
        Intent i = new Intent(this, Info_Act.class);
        startActivity(i);
    }

    public void Clientes(View v)
    {
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> planes = new ArrayList<String>();


        clientes.add("Roberto");
        clientes.add("Ivan");

        planes.add("xtreme");
        planes.add("mindfullness");

        Intent i = new Intent(this, Clientes_Act.class);
        i.putExtra("listaClientes", clientes); //Preparo el dato para ser enviado
        i.putExtra("listaPlanes", planes);
        startActivity(i);
    }
}