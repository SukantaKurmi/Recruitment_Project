package com.example.kurmi.recruitment_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Success extends AppCompatActivity {
    TextView name,add,city,cnt,id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        name=(TextView)findViewById(R.id.tv_name);
        add=(TextView)findViewById(R.id.tv_add);
        city=(TextView)findViewById(R.id.tv_city);
        cnt=(TextView)findViewById(R.id.tv_cnt);
        id=(TextView)findViewById(R.id.tv_id);
        name.setText(getIntent().getExtras().getString("Name").toString());
        add.setText(getIntent().getExtras().getString("Add").toString());
        city.setText(getIntent().getExtras().getString("City").toString());
        cnt.setText(getIntent().getExtras().getString("Con").toString());
        id.setText(getIntent().getExtras().getString("Id").toString());

        Toast.makeText(Success.this,"Registered Successfully",Toast.LENGTH_LONG).show();
    }
}
