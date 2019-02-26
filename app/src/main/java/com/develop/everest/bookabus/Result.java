package com.develop.everest.bookabus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Result extends AppCompatActivity {
    private static final String URL_PRODUCTS = "http://192.168.1.7/MyApi/Api.php";
    private static final String TAG = "Result";

    private static final int VERTICAL_ITEM_SPACE = 48;
    ArrayList<Bus> BusList;
    RecyclerView recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Recycler View
        recycleView = findViewById(R.id.recylcerView);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        // Adding decoration to recyclerview
//        recycleView.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        recycleView.addItemDecoration(new DividerItemDecoration(this));

        // Define Array list of Bus. We will feed it to adapter. Then adapter will feed it to recycler view
        BusList = new ArrayList<>();

        //Use volley for handling new JSON request
        RequestQueue queue = Volley.newRequestQueue(this);

        // Method to handle JSON response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject Bus = array.getJSONObject(i);
                                BusList.add(new Bus(
                                        Bus.getInt("id"),
                                        Bus.getString("dest_to"),
                                        Bus.getString("dest_from"),
                                        Bus.getString("name"),
                                        Bus.getString("departure"),
                                        Bus.getDouble("price")
                                ));
                            }
                            BusAdapter adapter = new BusAdapter(Result.this, BusList);
                            recycleView.setAdapter(adapter);
                            Log.v(TAG, "Data inserted");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v(TAG, "Received an exception");
            }
        });


        // Dummy Data
        BusList.add(new Bus(1,"Lajpat Nagar", "Nehru Place","Praveen Travels","NZM",1234.00));
        BusList.add(new Bus(2,"Kathmandu", "Dharan","Praveen Travels","NZM",1234.00));
        BusList.add(new Bus(3,"Ilam", "Kakarbita","Praveen Travels","NZM",1234.00));
        BusList.add(new Bus(4,"Kakarbita", "Kathmandu","Praveen Travels","NZM",1234.00));
        BusList.add(new Bus(5,"Dharan", "Kakarbita","Praveen Travels","NZM",1234.00));

        // Passing BusList to BusAdapter
        BusAdapter adapter = new BusAdapter(Result.this, BusList);

        // BusAdapter supplies data to RecyclerView
        recycleView.setAdapter(adapter);

        // Volley makes operation in queue
        queue.add(stringRequest);
    }
}