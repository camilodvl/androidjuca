package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Inventario extends AppCompatActivity {
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);

        List< Estudiante > estudiantes = Estudiante.listAll(Estudiante.class);
        if(!estudiantes.isEmpty()){
            ArrayList<String> nombreEstudiantes = new ArrayList<String>();
            for (int i=0; i<estudiantes.size(); i++){
                nombreEstudiantes.add(estudiantes.get(i).getNombre());
            }

            lista=findViewById(R.id.lvEstudiantes);
            ArrayAdapter <String> adapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreEstudiantes);
            lista.setAdapter(adapter);
        }
    }

    public void RegistrarEstudianteActividad(View view){
        Intent i = new Intent(view.getContext(), RegistrarEstudiante.class); //getcontext obtiene la actividad actual
        startActivity(i);
        finish();
    }
}