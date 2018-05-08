package com.example.kurmi.recruitment_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button back,del;
    Dbcontroller dbcon;

    EditText et_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbcon=new Dbcontroller(this,"",null,1);
        back=(Button)findViewById(R.id.bt_back);
        del=(Button)findViewById(R.id.bt_del);
        et_id=(EditText)findViewById(R.id.et_cmpid);

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=et_id.getText().toString();
                dbcon.delete_candidates(id);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6=new Intent(Login.this,Company.class);
                startActivity(intent6);
            }
        });

    }
}
