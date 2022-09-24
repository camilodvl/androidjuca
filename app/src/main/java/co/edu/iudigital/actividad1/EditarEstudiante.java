package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EditarEstudiante extends AppCompatActivity {
    private EditText nombreEditar;
    private EditText cedulaEditar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_estudiante);
    }


    public void EditarEstudianteNuevo(View view){
        nombreEditar=findViewById(R.id.txtNombreEditar);
        cedulaEditar=findViewById(R.id.txtCedulaEditar);
        String nombreE= nombreEditar.getText().toString();
        String cedulaE= cedulaEditar.getText().toString();

        if(nombreEditar.toString().equals("")){
            nombreEditar.setError("Ingrese el nombre");
        }else if(cedulaEditar.toString().equals("")){
            cedulaEditar.setError("Ingrese la cedula");
        }else {
            List<Estudiante> estudianteRetornado = Estudiante.find(Estudiante.class, "cedula='"+cedulaE+"'", null);
            if(estudianteRetornado.size()>0){

                Estudiante estudiante = estudianteRetornado.get(0);
                estudiante.setCedula(cedulaE);
                estudiante.setNombre(nombreE);
                try {
                    estudiante.save();
                    Toast.makeText(getApplicationContext(), "Estudiante editado", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(view.getContext(), Inventario.class); //getcontext obtiene la actividad actual
                    startActivity(i);
                    finish();
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_LONG).show();
                }

            }else{
                Toast.makeText(getApplicationContext(), "No existe el estudiante", Toast.LENGTH_LONG).show();
            }

        }


    }


}