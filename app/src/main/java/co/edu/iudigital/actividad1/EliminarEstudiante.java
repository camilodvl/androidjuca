package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EliminarEstudiante extends AppCompatActivity {
    EditText cedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_estudiante);
    }

    public void ElimarEstudianteInventario (View view){
        cedula = findViewById(R.id.txtCedulaBorrar);
        String cedulaBorrar = cedula.getText().toString();

        try {
            List<Estudiante> estudianteRetornado = Estudiante.find(Estudiante.class, "cedula='"+cedulaBorrar+"'", null);
            if(estudianteRetornado.size()>0){
                Estudiante estudiante1 = estudianteRetornado.get(0);
                estudiante1.delete();
                Toast.makeText(getApplicationContext(), "Estudiante eliminado", Toast.LENGTH_LONG).show();
                Intent i = new Intent(view.getContext(), Inventario.class); //getcontext obtiene la actividad actual
                startActivity(i);
                finish();
            }else{
                Toast.makeText(getApplicationContext(), "Estudiante no encontrado", Toast.LENGTH_LONG).show();
            }

        }catch ( Exception e){

            Toast.makeText(getApplicationContext(), "Ha ocurrido un error", Toast.LENGTH_LONG).show();
        }


    }
}