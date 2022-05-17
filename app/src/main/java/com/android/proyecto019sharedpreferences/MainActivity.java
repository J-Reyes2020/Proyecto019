package com.android.proyecto019sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtDate;
    private EditText txtTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDate = findViewById(R.id.id_txt_date);
        txtTexto = findViewById(R.id.id_txt_texto);
    }

    public void onClickGuradar(View view) {
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        String fecha = txtDate.getText().toString();
        String text = txtTexto.getText().toString();
        ed.putString(fecha,text);
        ed.commit();
        txtDate.setText("");
        txtTexto.setText("");
        Toast.makeText(this, "Las Actividades Fueron Registradas", Toast.LENGTH_SHORT).show();
    }

    public void onClickRecuperar(View view) {
        SharedPreferences sp = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String dato = sp.getString(txtDate.getText().toString(),"");
        if(dato.equals("")){
            Toast.makeText(this, "No hay actividades para la fecha indicada", Toast.LENGTH_SHORT).show();
        }else{
            txtTexto.setText(dato);
        }
    }
}