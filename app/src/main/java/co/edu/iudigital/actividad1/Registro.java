package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

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
        } else {

            try {
                List < Usuario > usuariosBd = Usuario.find(Usuario.class, "usuario='" + usuarioV + "'", null);
                if (usuariosBd.size() > 0) {
                    Toast.makeText(getApplicationContext(), "El usuario ya existe", Toast.LENGTH_LONG).show();
                } else {
                    Usuario usuarioBd = new Usuario(usuarioV, passwordV, emailV);
                    usuarioBd.save();
                    Toast.makeText(getApplicationContext(), "Usuario Creado", Toast.LENGTH_LONG).show();
                    usuario.setText("");
                    password.setText("");
                    email.setText("");
                    finish();
                }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Error al crear el usuario", Toast.LENGTH_LONG).show();
            }

        }
    }
}