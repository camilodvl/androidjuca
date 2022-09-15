package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    Button registrar; //Se crea el objeto tipo botón
    EditText usuario, clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUsuario);
        clave = findViewById(R.id.txtClave);

        registrar = (Button) findViewById(R.id.btnRegistrar); //busca el botón por id
        registrar.setOnClickListener(new View.OnClickListener() { //agrega una accion al evento onclick
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), Registro.class); //getcontext obtiene la actividad actual
                startActivity(i);

            }
        });

    }
    //se crea la funcion a ejecutar por el botón ingresar, esta función se asigna al botón en el diseño, al evento onClick
    public void Iniciar(View view) {
        String user = usuario.getText().toString();
        String pass = clave.getText().toString();

        if (user.equals("")) {
            usuario.setError("Ingrese un usuario");
        } else if (pass.equals("")) {
            clave.setError("Ingrese la clave");
        }
    }
}