package com.example.tinpattiofflineaccountant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

class TaskArrayAdapter extends ArrayAdapter<MyObj> {
    public TaskArrayAdapter(Context context, ArrayList<MyObj> list){
        super(context,0,list);
    }
    public View getView(int position, View convertview, ViewGroup parent){
        View listItem=convertview;
        if(listItem==null){
            listItem= LayoutInflater.from(getContext()).inflate(R.layout.mylist,parent,false);
        }
        MyObj Obj=getItem(position);
        TextView showDetails=(TextView)listItem.findViewById(R.id.ShowDetails);
        showDetails.setText(Obj.getShowDetail());
        TextView date=(TextView)listItem.findViewById(R.id.date);
        date.setText(Obj.getDate());
        TextView user=(TextView)listItem.findViewById(R.id.user);
        user.setText("By: "+Obj.getUser());
        TextView showExp=(TextView)listItem.findViewById(R.id.showExp);
        String status;
        if (Obj.getStatusString().equals("Undone") || Obj.getStatusString().equals("Done")){
            status = Obj.getStatusString();
            if (status.equals("Undone")) {
                showDetails.setBackgroundColor(RED);
                showExp.setBackgroundColor(RED);
                date.setBackgroundColor(RED);
                user.setBackgroundColor(RED);
                showExp.setText(status);
            }
            else {
                showDetails.setBackgroundColor(GREEN);
                showExp.setBackgroundColor(GREEN);
                date.setBackgroundColor(GREEN);
                user.setBackgroundColor(GREEN);
                showExp.setText(status);
            }
        }
        else {
            if (Obj.getShowExp() == 0) {
                status = "Undone";
                showDetails.setBackgroundColor(RED);
                showExp.setBackgroundColor(RED);
                date.setBackgroundColor(RED);
                user.setBackgroundColor(RED);
                showExp.setText(status);
            } else {
                status = "Done";
                showDetails.setBackgroundColor(GREEN);
                showExp.setBackgroundColor(GREEN);
                date.setBackgroundColor(GREEN);
                user.setBackgroundColor(GREEN);
                showExp.setText(status + Obj.getGetUser() + Obj.getDoneDate());
            }
        }
        return listItem;
    }
}
