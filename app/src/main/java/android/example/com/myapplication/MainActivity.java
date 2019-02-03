package android.example.com.myapplication;

import android.example.com.myapplication.controller.AndroidAdapter;
import android.example.com.myapplication.model.Android;
import android.example.com.myapplication.model.AndroidApi;
import android.example.com.myapplication.network.AndroidService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "JSON?";
    private AndroidService androidService;
    private Button newAndroid;
    private ImageView imageView;
    private String androidUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView androidrecycler = (RecyclerView) findViewById(R.id.android_recyclerview);

        List<Android> phones = new ArrayList<>();
        phones.add(new Android());
        phones.add(new Android());
        phones.add(new Android());

        AndroidAdapter androidAdapter = new AndroidAdapter(phones);
//      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        androidrecycler.setAdapter(androidAdapter);
        androidrecycler.setLayoutManager(linearLayoutManager);

        Retrofit retrofit = new Retrofit.Builder() //starts builder process
                .baseUrl("https://api.learn2crack.com/") //base url gateway to JSON endpt
                .addConverterFactory(GsonConverterFactory.create())//serialization
                .build(); //ends trasc

        //creating service so can use to make reqs

        androidService = retrofit.create(AndroidService.class);
        //GET requ. asynchronously

        newAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<AndroidApi> android = androidService.getAndroid();
                android.enqueue(new Callback<AndroidApi>() {
                    @Override
                    public void onResponse(Call<AndroidApi> call, Response<AndroidApi> response) {
                    Log.d(TAG, "onResponse: " + response.body().toString());
                    //why .toString
                        androidUrl = response.body().toString();
                        Picasso.get()
                                .load(response.body().toString())
                                .into(imageView);



                    }

                    @Override
                    public void onFailure(Call<AndroidApi> call, Throwable t) {
                        Log.d(TAG, "onResponse: " + t.toString());

                    }
                });

            }
        });
    }
}
