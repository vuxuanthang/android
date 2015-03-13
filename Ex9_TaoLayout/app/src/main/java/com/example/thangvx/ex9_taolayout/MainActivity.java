package com.example.thangvx.ex9_taolayout;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private int[] colorM = new int[4];
    private int id1 = 2;
    private int id2 = 1;
    private int id3 = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView im1 = (ImageView) findViewById(R.id.imageView1);
        im1.setBackgroundColor(Color.RED);
        ImageView im2 = (ImageView) findViewById(R.id.imageView2);
        im2.setBackgroundColor(Color.YELLOW);
        ImageView im3 = (ImageView) findViewById(R.id.imageView3);
        im3.setBackgroundColor(Color.BLUE);
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this);
        colorM[0] = Color.RED ;
        colorM[1] = Color.BLUE;
        colorM[2] = Color.YELLOW;
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

    @Override
    public void onClick(View v) {
        ImageView im1 = (ImageView) findViewById(R.id.imageView1);
        ImageView im2 = (ImageView) findViewById(R.id.imageView2);
        ImageView im3 = (ImageView) findViewById(R.id.imageView3);

        switch (v.getId()){
            case R.id.button:
                int a = id1-1;
                int b = id2-1;
                int c = id3-1;

                im1.setBackgroundColor(colorM[a]);
                im2.setBackgroundColor(colorM[b]);
                im3.setBackgroundColor(colorM[c]);

                if(id1 % 3 == 0){
                    id1 = 0;
                }
                id1++;
                if(id2 % 3 == 0){
                    id2 = 0;
                }
                id2++;
                if(id3 % 3 == 0){
                    id3 = 0;
                }
                id3++;
                break;
        }
    }
}
