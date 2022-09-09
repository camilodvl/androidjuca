package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity{
    Button registrar; //Se crea el objeto tipo botón
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        registrar=(Button)findViewById(R.id.registrar); //busca el botón por id
        registrar.setOnClickListener(new View.OnClickListener() { //agrega una accion al evento onclick
            @Override
            public void onClick(View view) {
                Intent i= new Intent(view.getContext(), Registro.class); //getcontext obtiene la actividad actual
                startActivity(i);

            }
        });

    }
}