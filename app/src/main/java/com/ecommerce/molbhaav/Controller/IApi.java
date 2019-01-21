package com.ecommerce.molbhaav.Controller;





import com.bumptech.glide.request.SingleRequest;
import com.ecommerce.molbhaav.Request.LoginRequest;
import com.ecommerce.molbhaav.Request.SignInRequest;
import com.ecommerce.molbhaav.Response.HomePageResponse.HomePageResponse;
import com.ecommerce.molbhaav.Response.LoginResponse;
import com.ecommerce.molbhaav.Response.ParticularCategoryPageResponse.ProductByCategory;
import com.ecommerce.molbhaav.Response.SignInResponse;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IApi {




    @POST("/users/signIn")
    public Call<SignInResponse> sign(@Body SignInRequest signInRequest);

    @POST("/users/login")
    public Call<LoginResponse>  login(@Body LoginRequest loginRequest);


    @GET("/category/findAll")
    public Call<List<HomePageResponse>> getCategories();

    @GET("/products/findByCategory/{categoryId}")
    public Call<List<ProductByCategory>> productsByCategory(@Path("categoryId") String categoryId);
    @PUT("/users/editProfile")
    public Call<SignInResponse> edit(@Body SignInResponse signInResponse);


    @GET("users/profile/{userId}")
    public Call<SignInResponse> getuser(@Path("userId") int userId);

//    @GET("config.json")
//    public Call<Object>

}
