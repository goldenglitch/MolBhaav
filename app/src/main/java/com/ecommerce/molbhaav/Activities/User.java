package com.ecommerce.molbhaav.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ecommerce.molbhaav.Controller.IApi;
import com.ecommerce.molbhaav.R;
import com.ecommerce.molbhaav.Response.SignInResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class User extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    ImageView i1,i2;
    Button btn,ok;
    String pass;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ed1=findViewById(R.id.editText);
        ed2=findViewById(R.id.editText2);
        ed3=findViewById(R.id.editText3);
        t1=findViewById(R.id.name);
        btn=findViewById(R.id.button2);
        ok=findViewById(R.id.button3);

        i2=findViewById(R.id.imageView2);


        i2.setImageResource(R.drawable.background);

        SharedPreferences sharedPreferences= getSharedPreferences("package com.example.projectfinal;", Context.MODE_PRIVATE);
        final int id= sharedPreferences.getInt("user",0);
        //final String pass= sharedPreferences.getString("pass","");
       // Toast.makeText(this, ""+sharedPreferences.getInt("user",0), Toast.LENGTH_SHORT).show();
        OkHttpClient client = new OkHttpClient.Builder().build();

        final Retrofit retrofit= new Retrofit.Builder().baseUrl("http://allstore.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build();
        IApi iApi = retrofit.create(IApi.class);
        iApi.getuser(id).enqueue(new Callback<SignInResponse>() {
            @Override
            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
               String name= response.body().getName();
                String email = response.body().getEmailId();
                String address= response.body().getAddress();
                pass=response.body().getPassword();

                ed1.setText(name);
                t1.setText(name);
                ed2.setText(email);
                ed3.setText(address);
                ed1.setEnabled(false);
                ed2.setEnabled(false);
                ed3.setEnabled(false);



            }

            @Override
            public void onFailure(Call<SignInResponse> call, Throwable t) {


            }  });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ok.setVisibility(1);
                ed1.setEnabled(true);
                ed2.setEnabled(true);
                ed3.setEnabled(true);
                String name= ed1.getText().toString();
                String Email=ed2.getText().toString();
                String address=ed3.getText().toString();
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        OkHttpClient client = new OkHttpClient.Builder().build();

                        final Retrofit retrofit= new Retrofit.Builder().baseUrl("http://allstore.herokuapp.com")
                                .addConverterFactory(GsonConverterFactory.create())
                                .client(client).build();
                        IApi iApi = retrofit.create(IApi.class);
                        SignInResponse signInResponse= new SignInResponse();
                        signInResponse.setAddress(ed3.getText().toString());
                        signInResponse.setEmailId(ed2.getText().toString());
                        signInResponse.setName(ed1.getText().toString());
                        signInResponse.setPassword(pass);
                        signInResponse.setUserId(id);


                        //Toast.makeText(Registration.this, ""+signInRequest.getName(), Toast.LENGTH_SHORT).show();
                        iApi.edit(signInResponse).enqueue(new Callback<SignInResponse>() {
                            @Override
                            public void onResponse(Call<SignInResponse> call, Response<SignInResponse> response) {
                                //System.out.println("Success" + response.body().getUserId());
                                if(response.isSuccessful())
                                {
                                    Toast.makeText(User.this, "updated the details", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(User.this, "Error in upddation", Toast.LENGTH_SHORT).show();

                                } }

                            @Override
                            public void onFailure(Call<SignInResponse> call, Throwable t) {
                                System.out.println("error"+ t);



                            }
                        });


                    }
                });




            }
        });

        }


    }

