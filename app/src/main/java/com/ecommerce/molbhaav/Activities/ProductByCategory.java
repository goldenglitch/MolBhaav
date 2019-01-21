package com.ecommerce.molbhaav.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ecommerce.molbhaav.Adapter.HomePageAdapter;
import com.ecommerce.molbhaav.Adapter.ProductByCategoryAdapter;
import com.ecommerce.molbhaav.Controller.IApi;
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

public class ProductByCategory extends AppCompatActivity {


    private List<String> imageUrlList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    private List<String> uspList = new ArrayList<>();
    private List<String> productIdList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_by_category);
        System.out.println(getIntent().getStringExtra("categoryId"));

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        OkHttpClient client = new OkHttpClient.Builder().build();
//http://10.0.2.2:8000 or http://localhost:8000
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:8000")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
        IApi iApi = retrofit.create(IApi.class);

        iApi.productsByCategory(getIntent().getStringExtra("categoryId")).enqueue(new Callback<List<com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse.ProductByCategory>>() {
            @Override
            public void onResponse(Call<List<com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse.ProductByCategory>> call, Response<List<com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse.ProductByCategory>> response) {
                for(int i=0;i<response.body().size();i++) {
                    uspList.add(String.valueOf(i));
                    nameList.add(response.body().get(i).getProductName());
                    imageUrlList.add(response.body().get(i).getProductImageUrl());
                    productIdList.add(response.body().get(i).getProductId());
                }
                mAdapter = new ProductByCategoryAdapter(productIdList, nameList, imageUrlList, uspList);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<List<com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse.ProductByCategory>> call, Throwable t) {

            }

    });

}
}

