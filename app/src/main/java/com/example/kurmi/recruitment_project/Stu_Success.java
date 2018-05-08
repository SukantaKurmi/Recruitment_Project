package com.example.kurmi.recruitment_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Stu_Success extends AppCompatActivity {
    TextView Stuname,Stugender,Stumail,Stucnt,Sturoll,Stuadd,Stuage,Stucgpa,Stuhsc,Stussc,Stujob;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu__success);
        Stuname=(TextView)findViewById(R.id.tv_stuname);
        Stugender=(TextView) findViewById(R.id.tv_stugender);
        Stumail=(TextView)findViewById(R.id.tv_EmalId);
        Stucnt=(TextView)findViewById(R.id.tv_con);
        Sturoll=(TextView)findViewById(R.id.tv_roll);
        Stuadd=(TextView)findViewById(R.id.tv_Adrr);
        Stuage=(TextView)findViewById(R.id.tv_Age);
        Stucgpa=(TextView)findViewById(R.id.tv_cgpa);
        Stuhsc=(TextView)findViewById(R.id.tv_hsc);
        Stussc=(TextView)findViewById(R.id.tv_ssc);

        Stuname.setText(getIntent().getExtras().getString("Name").toString());
        Stugender.setText(getIntent().getExtras().getString("Gender").toString());
        Stumail.setText(getIntent().getExtras().getString("Mail").toString());
        Stucnt.setText(getIntent().getExtras().getString("Phn").toString());
        Sturoll.setText(getIntent().getExtras().getString("Roll").toString());
        Stuadd.setText(getIntent().getExtras().getString("Addrress").toString());
        Stuage.setText(getIntent().getExtras().getString("Age").toString());
        Stucgpa.setText(getIntent().getExtras().getString("CGPA").toString());
        Stuhsc.setText(getIntent().getExtras().getString("HSC").toString());
        Stussc.setText(getIntent().getExtras().getString("SSC").toString());

        Toast.makeText(Stu_Success.this,"Student Registered Successfully",Toast.LENGTH_LONG).show();

    }
}
