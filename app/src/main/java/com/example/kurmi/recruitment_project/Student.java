package com.example.kurmi.recruitment_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Student extends AppCompatActivity {
    EditText roll,name;
    Button stu_sgp,stu_sgn,stu_list,stucomlist;
    TextView tv_stu,tv_stucomlist;
    Dbcontroller1 dbcon1;
    Dbcontroller3 dbcon3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        dbcon1 = new Dbcontroller1(this, "", null, 1);
        dbcon3 = new Dbcontroller3(this, "", null, 1);
        roll=(EditText)findViewById(R.id.et_stroll);
        name=(EditText)findViewById(R.id.et_stname);
        tv_stu=(TextView)findViewById(R.id.tv_stulist);
        stu_sgp=(Button)findViewById(R.id.bt_stureg);
        stu_sgn=(Button)findViewById(R.id.bt_stulogin);
        stu_list=(Button)findViewById(R.id.bt_stlist);
        stucomlist=(Button)findViewById(R.id.bt_stcomlist);


        tv_stucomlist=(TextView) findViewById(R.id.tv_stucomplist);
        stu_sgp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent7=new Intent(Student.this,Stu_Register.class);
                startActivity(intent7);
            }
        });
       stu_sgn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String Name=name.getText().toString();
               String Roll=roll.getText().toString();
               if(dbcon1.search_stu(Roll,Name)==1)
               {
                   Toast.makeText(Student.this,"Login Successful",Toast.LENGTH_LONG).show();
                   Intent intent8=new Intent(Student.this,Stu_Login.class);
                   startActivity(intent8);
               }
               else{
                   Toast.makeText(Student.this,"wrong user id  or password",Toast.LENGTH_LONG).show();
               }
           }
       });

       stu_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbcon1.list_allstu(tv_stu);
            }
        });

       stucomlist.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               dbcon3.list_allstu(tv_stucomlist);
           }
       });
    }
}
