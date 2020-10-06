package com.example.proyecto_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import Clases.Planes;

public class Clientes_Act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private TextView text;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_);

        spin1 = (Spinner)findViewById(R.id.spinClientes);
        spin2 = (Spinner)findViewById(R.id.spinPlanes);

        text = (TextView)findViewById(R.id.et2);
        edit = (EditText)findViewById(R.id.et1);

        //Recibo el arreglo desde el menú
        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");

        ArrayAdapter<String> adapt = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaPlanes);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void Calcular(View v)
    {
        Planes plan = new Planes();

        String cliente = spin1.getSelectedItem().toString();
        String planes = spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString());
        int xtreme = Integer.parseInt(plan.getXtreme());
        int mind = Integer.parseInt(plan.getMindfullness());

        int resultado = xtreme - saldo;
        int resultadoDos = mind - saldo;

        if(cliente.equals("Roberto") && planes.equals("xtreme"))
        {
            text.setText("El valor xtreme es: " + resultado);
        }

        if(cliente.equals("Roberto") && planes.equals("mindfullness"))
        {
            text.setText("El valor de mindfullness es: " + plan.getMindfullness());
        }

    }
}