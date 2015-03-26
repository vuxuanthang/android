package com.example.thangvx.ex10_listsv;

import com.example.thangvx.ex10_listsv.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thangvx on 3/26/2015.
 */
public class StudentAdapter extends ArrayAdapter<Student> {
    int layoutResourceId;
    private ArrayList<Student> std;
    Context context;

    public StudentAdapter(Context context, int layoutResourceId,  ArrayList<Student> std) {

        super(context, R.layout.activity_main, std);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.std = std;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=  ((Activity) context).getLayoutInflater();;
        View rowView=inflater.inflate(R.layout.item, null,true);

        TextView txtName = (TextView) rowView.findViewById(R.id.viewname);
        TextView txtAge = (TextView) rowView.findViewById(R.id.viewage);
        TextView txtSex = (TextView) rowView.findViewById(R.id.viewsex);

        try {
            txtName.setText(std.get(position).getName());
            txtAge.setText(std.get(position).getAge() + "");
            if( std.get(position).getSex() == "1"){
                txtSex.setText("Nam");
            }else{
                txtSex.setText("Nu");
            }
        }catch (Exception e){
            System.out.println("lỗi");
        }
        return rowView;

    };
}
