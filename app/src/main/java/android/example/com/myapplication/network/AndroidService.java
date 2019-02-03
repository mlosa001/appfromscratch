package android.example.com.myapplication.network;

import android.example.com.myapplication.model.AndroidApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidService {
    @GET("android/jsonandroid/")
    Call<AndroidApi> getAndroid();
}

//https://api.learn2crack.com/android/jsonandroid/

//Create an Interface for a Retrofit service, adding methods for creating get requests that include the path that comes after the base url.