package com.example.kurmi.recruitment_project;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText name,add,city,contact,pass,conpass,id;
    Button Register;
    Dbcontroller dbcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbcon=new Dbcontroller(this,"",null,1);
        id=(EditText)findViewById(R.id.et_id);
        name=(EditText)findViewById(R.id.et_name);
        add=(EditText)findViewById(R.id.et_add);
        city=(EditText)findViewById(R.id.et_city);
        contact=(EditText)findViewById(R.id.et_cnt);
        pass=(EditText)findViewById(R.id.et_pwd);
        conpass=(EditText)findViewById(R.id.et_conpwd);
        Register=(Button)findViewById(R.id.bt_reg);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd=pass.getText().toString();
                String conpwd=conpass.getText().toString();
                String Name=name.getText().toString();
                String Add=add.getText().toString();
                String con=contact.getText().toString();
                String City=city.getText().toString();
                String Id=id.getText().toString();
                if(pwd.equals(conpwd)){
                    try {
                        dbcon.insert_candidates(Id,Name,pwd);
                    } catch (SQLiteException e) {
                        Toast.makeText(Register.this, "ALREADY EXIST", Toast.LENGTH_LONG).show();
                    }

                    Intent intent5=new Intent(Register.this,Success.class);
                    intent5.putExtra("Name",Name);
                    intent5.putExtra("Add",Add);
                    intent5.putExtra("City",City);
                    intent5.putExtra("Con",con);
                    intent5.putExtra("Id",Id);
                    startActivity(intent5);

                }
                else
                {
                    Toast.makeText(Register.this,"Password Mismatch",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
