package android.example.com.myapplication.view;

import android.example.com.myapplication.R;
import android.example.com.myapplication.model.Android;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class AndroidViewHolder extends RecyclerView.ViewHolder{

    private TextView ver;
    private TextView name;
    private TextView api;

    public AndroidViewHolder(View itemView) {
        super(itemView);
        ver = (TextView) itemView.findViewById(R.id.ver_textview);
        name = (TextView) itemView.findViewById(R.id.name_textview);
        api = (TextView) itemView.findViewById(R.id.api_textview);
// we put the parameter itemView in front of the findViewById() method,
// because we are setting the child views of
// the itemView being passed into this constructor.
    }
 public void onBind(Android android){
            ver.setText("ver: " + android.getVer());
         name.setText("name: " + android.getName());
     api.setText("api: " + android.getApi());



 }


    }

