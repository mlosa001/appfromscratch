package android.example.com.myapplication.controller;

import android.example.com.myapplication.R;
import android.example.com.myapplication.model.Android;
import android.example.com.myapplication.view.AndroidViewHolder;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidViewHolder> {

    //list and constructor to accept a list of d@a type objs
    private List<Android> androidList;

    public AndroidAdapter(List<Android> androidList){
        this.androidList = androidList;
    }


    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.android_itemview, parent, false);
        return new AndroidViewHolder(childView);
    }

    @Override
    public void onBindViewHolder( AndroidViewHolder holder, int position) {
        Android android = androidList.get(position);

        holder.onBind(android);
    }

    @Override
    public int getItemCount() {
        return androidList.size();
    }
}


// dependencies,model, recyvler view, vieholder, adapter,