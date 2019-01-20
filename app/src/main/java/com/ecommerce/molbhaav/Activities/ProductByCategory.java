package com.ecommerce.molbhaav.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ecommerce.molbhaav.R;

public class ProductByCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_by_category);
        System.out.println(getIntent().getStringExtra("categoryId"));
    }
}
