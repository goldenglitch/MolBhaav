package com.ecommerce.molbhaav.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ecommerce.molbhaav.Activities.HomePage;
import com.ecommerce.molbhaav.Activities.ProductByCategory;
import com.ecommerce.molbhaav.R;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.HomeViewHolder> {

    private List<String> categoryIdList = new ArrayList<>();
    private List<String> categoryNameList = new ArrayList<>();
    private List<String> categoryImageUrlList = new ArrayList<>();
    private Context context;

    public HomePageAdapter(Context context, List<String> categoryIdList, List<String> categoryNameList, List<String> categoryImageUrlList){
        this.context = context;
        this.categoryIdList = categoryIdList;
        this.categoryNameList = categoryNameList;
        this.categoryImageUrlList = categoryImageUrlList;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,final int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_card_view, viewGroup, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder homeViewHolder, final int i) {
        ((HomeViewHolder) homeViewHolder).bind(categoryNameList.get(i), categoryImageUrlList.get(i));
        homeViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductByCategory.class);
                intent.putExtra("categoryId", categoryIdList.get(i));
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryIdList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView nameTextView;

        public HomeViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.categoryImageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);

        }

        public void bind(String name, String imageUrl){
            nameTextView.setText(name);
            Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
        }




    }


}
