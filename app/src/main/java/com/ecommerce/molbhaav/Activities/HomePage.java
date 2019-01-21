package com.ecommerce.molbhaav.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;


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

public class HomePage extends AppCompatActivity{

    private List<String> categoryId = new ArrayList<>();
    private List<String> categoryName = new ArrayList<>();
    private List<String> categoryImageUrl = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.baseline_menu_black_18dp);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        if(menuItem.getItemId() == R.id.nav_home){
                            Toast.makeText(HomePage.this, "Home Clicked",Toast.LENGTH_LONG).show();
                        }else if(menuItem.getItemId() == R.id.nav_user_details){
                            Toast.makeText(HomePage.this, "User Clicked",Toast.LENGTH_LONG).show();
                        }else if(menuItem.getItemId() == R.id.nav_cart){
                            Toast.makeText(HomePage.this, "Cart Clicked",Toast.LENGTH_LONG).show();
                        }

                        return true;
                    }
                });



        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        OkHttpClient client = new OkHttpClient.Builder().build();
        //http://10.0.2.2:8000 or http://localhost:8000
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.177.7.91:8000")
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
