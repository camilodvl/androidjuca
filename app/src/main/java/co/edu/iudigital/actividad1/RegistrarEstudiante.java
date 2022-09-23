package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarEstudiante extends AppCompatActivity {
    EditText nombreEstudiante, cedulaEstudiante;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_estudiante);

    }

    public void RegistrarEstudianteNuevo(View view){
        nombreEstudiante=findViewById(R.id.txtNombreEstudiante);
        cedulaEstudiante=findViewById(R.id.txtCedulaEstudiante);
        String nombreE= nombreEstudiante.getText().toString();
        String cedulaE= cedulaEstudiante.getText().toString();

        if(nombreEstudiante.toString().equals("")){
            nombreEstudiante.setError("Ingrese el nombre");
        }else if(cedulaEstudiante.toString().equals("")){
            cedulaEstudiante.setError("Ingrese la cedula");
        }else {
            Estudiante estudiante = new Estudiante(cedulaE, nombreE);
            try {
                estudiante.save();
                Toast.makeText(getApplicationContext(), "Estudiante registrado", Toast.LENGTH_LONG).show();
                Intent i = new Intent(view.getContext(), Inventario.class); //getcontext obtiene la actividad actual
                startActivity(i);
                finish();
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_LONG).show();
            }
        }


    }
}