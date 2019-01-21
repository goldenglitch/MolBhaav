package com.ecommerce.molbhaav.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ecommerce.molbhaav.R;

import java.util.List;

public class ProductByCategoryAdapter extends RecyclerView.Adapter<ProductByCategoryAdapter.ProductByCategoryViewHolder> {


    List<String> productIdList;
    List<String> productNameList;
    List<String> productImageUrlList;
    List<String> productUspList;

    public ProductByCategoryAdapter(List<String> productIdList, List<String> productNameList, List<String> productImageUrlList, List<String> productUspList) {
        this.productIdList = productIdList;
        this.productImageUrlList = productImageUrlList;
        this.productNameList = productNameList;
        this.productUspList = productUspList;
    }

    class ProductByCategoryViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView productId;
        private TextView productName;
        private TextView productUsp;

        public ProductByCategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.productimageView);
            productName = (TextView) itemView.findViewById(R.id.productName);
            productUsp = itemView.findViewById(R.id.productPriceRange);
        }

        public void bind(String name, String usp, String imageUrl){
            productName.setText(name);
            productUsp.setText(usp);
            Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
        }
    }


    @NonNull
    @Override
    public ProductByCategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.product_item_view, viewGroup, false);
        return new ProductByCategoryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductByCategoryViewHolder productByCategoryViewHolder, int i) {
        ((ProductByCategoryViewHolder)productByCategoryViewHolder).bind(productNameList.get(i), productUspList.get(i), productImageUrlList.get(i));
    }

    @Override
    public int getItemCount() {
        return productNameList.size();
    }





}
