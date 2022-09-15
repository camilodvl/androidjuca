package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {

    EditText usuario, password, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario = findViewById(R.id.txtUsuarioRegistro);
        password = findViewById(R.id.txtPasswordRegistro);
        email = findViewById(R.id.txtEmailRegistro);
    }

    public void GuardarRegistro(View view) {
        String usuarioV = usuario.getText().toString();
        String passwordV = password.getText().toString();
        String emailV = email.getText().toString();

        if (usuarioV.equals("")) {
            usuario.setError("Ingrese el usuario");
        } else if (passwordV.equals("")) {
            password.setError("Ingrese el password");
        } else if (emailV.equals("")) {
            email.setError("Ingrese el email");
        }
    }
}