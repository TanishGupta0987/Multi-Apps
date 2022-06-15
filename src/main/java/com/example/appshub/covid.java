package com.example.appshub;



import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import com.example.appshub.databinding.ActivityCovidBinding;

public class covid extends AppCompatActivity {

    ListView listView;

    public static List<Model> modelList = new ArrayList<>();
    Model model;
    Adapter adapter;

    ActivityCovidBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        binding= ActivityCovidBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listView = findViewById(R.id.listView);
        fetchData();
    }


    private void fetchData() {
        // The Link Through Which We Can Fetch Data
        String url = "https://data.covid19india.org/state_district_wise.json";

        StringRequest request = new StringRequest(Request.Method.GET, url, response -> {

            try {
                // Creating JSON Object
                JSONObject object = new JSONObject(response);

                // From that object we are fetching data
                JSONObject object1 = object.getJSONObject("Jammu and Kashmir");
                JSONObject object2 = object1.getJSONObject("districtData");
                JSONObject object3 = object2.getJSONObject("Jammu");
                JSONObject object4 = object3.getJSONObject("delta");


                String active = object3.getString("active");
                String confirmed = object3.getString("confirmed");
                String deceased = object3.getString("deceased");
                String recovered = object3.getString("recovered");

                String confInc = object4.getString("confirmed");
                String confDec = object4.getString("deceased");
                String confRec = object4.getString("recovered");

                model = new Model("Jammu", confirmed, deceased, recovered, active,
                        confInc, confDec, confRec);
                // placing data into the app using AdapterClass
                modelList.add(model);

                // Creating JSON Object
                object3 = object2.getJSONObject("Kathua");

                // From that object we are fetching data
                active = object3.getString("active");
                confirmed = object3.getString("confirmed");
                deceased = object3.getString("deceased");
                recovered = object3.getString("recovered");
                object4 = object3.getJSONObject("delta");
                confInc = object4.getString("confirmed");
                confDec = object4.getString("deceased");
                confRec = object4.getString("recovered");

                model = new Model("Kathua", confirmed, deceased, recovered, active,
                        confInc, confDec, confRec);
                // placing data into the app using AdapterClass
                modelList.add(model);

                // Creating JSON Object
                object3 = object2.getJSONObject("Srinagar");

                // From that object we are fetching data
                active = object3.getString("active");
                confirmed = object3.getString("confirmed");
                deceased = object3.getString("deceased");
                recovered = object3.getString("recovered");
                object4 = object3.getJSONObject("delta");

                confInc = object4.getString("confirmed");
                confDec = object4.getString("deceased");
                confRec = object4.getString("recovered");

                model = new Model("Srinagar", confirmed, deceased, recovered, active,
                        confInc, confDec, confRec);
                // placing data into the app using AdapterClass
                modelList.add(model);

                // Creating JSON Object
                object3 = object2.getJSONObject("Reasi");

                // From that object we are fetching data
                active = object3.getString("active");
                confirmed = object3.getString("confirmed");
                deceased = object3.getString("deceased");
                recovered = object3.getString("recovered");
                object4 = object3.getJSONObject("delta");

                confInc = object4.getString("confirmed");
                confDec = object4.getString("deceased");
                confRec = object4.getString("recovered");

                model = new Model("Reasi", confirmed, deceased, recovered, active,
                        confInc, confDec, confRec);
                // placing data into the app using AdapterClass
                modelList.add(model);

                // Creating JSON Object
                object3 = object2.getJSONObject("Samba");

                // From that object we are fetching data
                active = object3.getString("active");
                confirmed = object3.getString("confirmed");
                deceased = object3.getString("deceased");
                recovered = object3.getString("recovered");
                object4 = object3.getJSONObject("delta");
                confInc = object4.getString("confirmed");
                confDec = object4.getString("deceased");
                confRec = object4.getString("recovered");

                model = new Model("Samba", confirmed, deceased, recovered, active,
                        confInc, confDec, confRec);
                // placing data into the app using AdapterClass
                modelList.add(model);

                adapter = new Adapter(covid.this, modelList);
                listView.setAdapter(adapter);

                // In case of error it will run
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // In case of error it will run
                Toast.makeText(covid.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

}


