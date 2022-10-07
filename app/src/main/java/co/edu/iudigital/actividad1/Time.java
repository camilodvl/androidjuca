package co.edu.iudigital.actividad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Time extends AppCompatActivity {

    TextView txtHora, txtAno, txtMes, txtDia;
    RequestQueue  requestQueue;//creamos la variable que va a crear la cola
    private String URL="https://timeapi.io/api/Time/current/zone?timeZone=Europe/Amsterdam";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        txtHora = findViewById(R.id.txtViewHora);
        txtAno = findViewById(R.id.txtViewAno);
        txtMes = findViewById(R.id.txtViewMes);
        txtDia = findViewById(R.id.txtViewDia);
        requestQueue = Volley.newRequestQueue(this); //se crea la cola y se le pasa el activity
        jsonObjectRequest();
    }


    private void jsonObjectRequest(){
        JsonObjectRequest  jsonObjectRequest= new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            txtHora.setText(response.getString("hour").toString()+
                                    ":"+response.getString("minute").toString());
                            txtAno.setText(response.getString("year").toString());
                            txtMes.setText(response.getString("month").toString());
                            txtDia.setText(response.getString("day").toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        requestQueue.add(jsonObjectRequest);// agregamos la solicitud a la cola
    }
}

