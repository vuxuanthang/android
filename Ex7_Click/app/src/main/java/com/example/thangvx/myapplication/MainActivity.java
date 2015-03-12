package com.example.thangvx.myapplication;

import android.content.DialogInterface;
import android.location.GpsStatus;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.button);

        b.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    public void Click(View v){
        TextView d = (TextView)  findViewById(R.id.textView1);
        d.setText("Lan thu: " + id);
        if(id % 3 == 0){
            id = 0;
        }
        id++;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
               /* TextView d = (TextView)  findViewById(R.id.textView1);
                d.setText("Lan thu: " + id);
                if(id % 3 == 0){
                    id = 0;
                }
                id++;*/
                Student s1 = new Student("Thang", 15, "nam");
                Student s2 = new Student("Thang 1", 35, "nam");
                Student s3 = new Student("Thang 2", 45, "nam");
                TextView d = (TextView)  findViewById(R.id.textView1);
                List lv = new ArrayList();
                lv.add(s1);
                lv.add(s2);
                lv.add(s3);

                Student s ;
                for( int i = 0; i < lv.size(); i++){
                    s = (Student) lv.get(i);
                    d.setText(d.getText() +"- Ten: " + s.getName() + ", Tuoi: " + s.getAge() + ", Gioi tinh: " + s.getSex() +"\n" );
                }
                break;
        }
    }
}
