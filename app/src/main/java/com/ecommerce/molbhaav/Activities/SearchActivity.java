package com.ecommerce.molbhaav.Activities;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ecommerce.molbhaav.Adapter.ProductByCategoryAdapter;
import com.ecommerce.molbhaav.Controller.IApi;
import com.ecommerce.molbhaav.R;
import com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse.ProductByCategory;
import com.ecommerce.molbhaav.Response.ProductDetailsWithPriceAndCount.ProductDetailPriceAndCount;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchActivity extends Activity {

    private List<String> imageUrlList = new ArrayList<>();
    private List<String> nameList = new ArrayList<>();
    private List<String> uspList = new ArrayList<>();
    private List<String> productIdList = new ArrayList<>();
    private List<Integer> highestPriceList = new ArrayList<>();
    private List<Integer> lowestPriceList = new ArrayList<>();
    private List<Integer> merchantCountList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        System.out.println("SearchActivity started");
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doSearch(query);
            System.out.println("SearchActivity Intent get");
        }

    }

    public void doSearch(String query){
        OkHttpClient client = new OkHttpClient.Builder().build();
        //http://10.0.2.2:8000 or http://localhost:8000
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.177.7.118:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
        IApi iApi = retrofit.create(IApi.class);

        iApi.searchProductsResult(query).enqueue(new Callback<List<ProductDetailPriceAndCount>>() {
            @Override
            public void onResponse(Call<List<ProductDetailPriceAndCount>> call, Response<List<ProductDetailPriceAndCount>> response) {
                for(int i=0;i<response.body().size();i++) {
                    uspList.add(String.valueOf(i));
                    nameList.add(response.body().get(i).getProductName());
                    imageUrlList.add(response.body().get(i).getProductImageUrl());
                    productIdList.add(response.body().get(i).getProductId());
                    highestPriceList.add(response.body().get(i).getHighestPrice());
                    lowestPriceList.add(response.body().get(i).getLowestPrice());
                    merchantCountList.add(response.body().get(i).getMerchantCount());
                }
                mAdapter = new ProductByCategoryAdapter(productIdList, nameList, imageUrlList, uspList, highestPriceList, lowestPriceList, merchantCountList);
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<List<ProductDetailPriceAndCount>> call, Throwable t) {
                System.out.println("Error while searching");
            }
        });


    }








}
