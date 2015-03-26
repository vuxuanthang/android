package com.example.thangvx.ex10_listsv;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView lvStudent;
    ArrayList<Student> arrStudent = new ArrayList<Student>();
    StudentAdapter adapter = null ;
    Student std = null;
    EditText name ;
    EditText age ;
    RadioGroup rg ;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.editname);
        age = (EditText) findViewById(R.id.editage);
        rg = (RadioGroup) findViewById(R.id.radiogroud1);
        bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(this);

        /*
        ListView lv = (ListView) findViewById(R.id.listView);
        */
        Student a = new Student("Thang", 20, "1");
        Student b = new Student("Thang 1", 30, "1");
        Student c = new Student("Thang 2", 40, "1");
        lvStudent = (ListView) findViewById(R.id.listView);
        arrStudent.add(a);
        arrStudent.add(b);
        arrStudent.add(c);
        lvStudent.setOnItemClickListener(this);
        //ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, arrStudent);
        try{

            adapter = new StudentAdapter(this, android.R.layout.simple_list_item_1, arrStudent);
            lvStudent.setAdapter(adapter);
        }catch (Exception e){
            System.out.println("l");
        }



    }


    @Override
    public void onClick(View v) {
        String names =  name.getText() + "";
        int ag = Integer.parseInt(age.getText() + "") ;
        Student ipu = new Student();

        switch (v.getId()){
            case R.id.button:

                            ipu.setName(names);
                            ipu.setAge(ag);
                            int radId=rg.getCheckedRadioButtonId();
                            if(radId == R.id.rdnam){
                                ipu.setSex("1");
                            }else{
                                ipu.setSex("0");
                            }
                            arrStudent.add(ipu);

                            name.setText("");
                            age.setText("");
                            adapter.notifyDataSetChanged();
                            lvStudent.setAdapter(adapter);

                break;
            default:
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent myIntent = new Intent(view.getContext(), ViewdetailActivity.class);
        Student detailStudent = arrStudent.get(position);
        myIntent.putExtra("detailStudent", detailStudent);
        startActivity(myIntent);
    }
}
