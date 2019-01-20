package com.ecommerce.molbhaav.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;


import com.ecommerce.molbhaav.Adapter.HomePageAdapter;
import com.ecommerce.molbhaav.Adapter.MyAdapter;
import com.ecommerce.molbhaav.Controller.AppControl;
import com.ecommerce.molbhaav.Controller.IApi;
import com.ecommerce.molbhaav.Controller.ItemData;
import com.ecommerce.molbhaav.R;
import com.ecommerce.molbhaav.Response.HomePageResponse.HomePageResponse;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomePage extends Activity{

    private List<String> categoryId = new ArrayList<>();
    private List<String> categoryName = new ArrayList<>();
    private List<String> categoryImageUrl = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        OkHttpClient client = new OkHttpClient.Builder().build();
//http://10.0.2.2:8000 or http://localhost:8000
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
        IApi iApi = retrofit.create(IApi.class);

        iApi.getCategories().enqueue(new Callback<List<HomePageResponse>>() {
            @Override
            public void onResponse(Call<List<HomePageResponse>> call, Response<List<HomePageResponse>> response) {
                for(int i=0;i<response.body().size();i++){
                    categoryId.add(response.body().get(i).getCategoryId());
                    categoryName.add(response.body().get(i).getCategoryName());
                    categoryImageUrl.add(response.body().get(i).getCategoryImageUrl());
                }
                mAdapter = new HomePageAdapter(HomePage.this,categoryId, categoryName, categoryImageUrl);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<List<HomePageResponse>> call, Throwable t) {
                System.out.println("Error connecting home Page");
            }
        });



    }
}
