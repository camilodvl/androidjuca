package co.edu.iudigital.actividad1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class EstudiantesAdapter extends ArrayAdapter<Estudiante> {
    private List<Estudiante> estudiantes;
    private Context context;
    private int resource;


    public EstudiantesAdapter(Context context, int resource, List<Estudiante> estudiantes) {
        super(context, resource, estudiantes);
        this.estudiantes=estudiantes;
        this.context=context;
        this.resource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.estudiantes_adapter_layout, null);

            Estudiante estudiante = estudiantes.get(position);

            TextView nombre = view.findViewById(R.id.txtViewNombre);
            nombre.setText(estudiante.getNombre());

            TextView cedula = view.findViewById(R.id.txtViewCedula);
            cedula.setText(estudiante.getCedula());

            return view;

        }else{

            return view;
        }




    }
}
