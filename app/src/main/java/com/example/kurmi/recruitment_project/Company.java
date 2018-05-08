package com.example.kurmi.recruitment_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Company extends AppCompatActivity {
    EditText id,pwd,cmpname;
    Button sgn,sgp,list;
    TextView tv;
    Dbcontroller dbcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
        dbcon=new Dbcontroller(this,"",null,1);
        id=(EditText)findViewById(R.id.et_01);
        cmpname=(EditText)findViewById(R.id.et_02);
        pwd=(EditText)findViewById(R.id.et_03);
        sgn=(Button)findViewById(R.id.bt_signin);
        sgp=(Button)findViewById(R.id.bt_signup);
        list=(Button)findViewById(R.id.bt_list);
        tv=(TextView)findViewById(R.id.tv_list);
        sgp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(Company.this,Register.class);
                startActivity(intent3);
            }
        });

        sgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid=id.getText().toString();
                String name=cmpname.getText().toString();
                String pass=pwd.getText().toString();
                if(dbcon.search(userid,name,pass)==1)
                {
                    Toast.makeText(Company.this,"Login Successful",Toast.LENGTH_LONG).show();
                    Intent intent4=new Intent(Company.this,Login.class);
                    startActivity(intent4);
                }
                else{
                    Toast.makeText(Company.this,"wrong user id  or password",Toast.LENGTH_LONG).show();
                }

            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dbcon.list_candidates(tv);
            }
        });
    }
}
