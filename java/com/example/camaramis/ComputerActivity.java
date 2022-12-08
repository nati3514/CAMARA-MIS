package com.example.camaramis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ComputerActivity extends AppCompatActivity {

    private static final String PRODUCT_URL ="http://192.168.8.110/camara/myapi.php";
    List<Product> productList;

    RecyclerView recyclerView;

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer);

        drawerLayout=findViewById(R.id.drawer_layout);

        productList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();

        loadProducts();
    }
    public void ClickMenu(View view){
        MainActivity.opernDrawer(drawerLayout);
    }
    public void ClickLogo(View view){
        MainActivity.closeDrawer(drawerLayout);
    }
    public void ClickDashboard(View view){
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void ClickComputer(View view){
        recreate();
    }
    public void ClickLogout(View view){
        MainActivity.logout(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(drawerLayout);
    }

    private void loadProducts(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray products = new JSONArray(response);

                            for(int i=0; i<products.length(); i++){
                                JSONObject productobject = products.getJSONObject(i);

                                int id = productobject.getInt("id");
                                String Afri_Number = productobject.getString("Afri_Number");
                                String Short_Des = productobject.getString("Short_Des");

                                String Brand = productobject.getString("Brand");

                                //String image = productobject.getString("image");

                                String pro_Date = productobject.getString("pro_Date");

                                String Status = productobject.getString("Status");

                                Product product = new Product(id, Afri_Number, Short_Des, Brand, pro_Date, Status);
                                productList.add(product);
                            }
                            //creating recyclerview adapter
                            ProductAdapter adapter = new ProductAdapter(ComputerActivity.this, productList);

                            //setting adapter to recyclerview
                            recyclerView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(ComputerActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}