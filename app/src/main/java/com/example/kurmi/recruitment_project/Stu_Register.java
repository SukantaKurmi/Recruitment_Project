package com.example.kurmi.recruitment_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class Stu_Register extends AppCompatActivity {
    EditText name, age, rollno, addrress, cgpa, hsc, ssc, phnno, mailid;
    Button submit;
    Dbcontroller1 dbcon1;
    RadioButton rd;
    RadioGroup rgp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu__register);
        dbcon1 = new Dbcontroller1(this, "", null, 1);
        name = (EditText) findViewById(R.id.name);
        mailid = (EditText) findViewById(R.id.mail);
        phnno = (EditText) findViewById(R.id.cnt);
        addrress = (EditText) findViewById(R.id.add);
        age = (EditText) findViewById(R.id.age);
        rollno = (EditText) findViewById(R.id.roll);
        cgpa = (EditText) findViewById(R.id.cgpa);
        hsc = (EditText) findViewById(R.id.hsc);
        ssc = (EditText) findViewById(R.id.ssc);
        submit = (Button) findViewById(R.id.bt_sub);
        rgp = (RadioGroup) findViewById(R.id.rg);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = name.getText().toString();
                String Mail = mailid.getText().toString();
                String Phn = phnno.getText().toString();
                String Addrress = addrress.getText().toString();
                String Age = age.getText().toString();
                String Rollno = rollno.getText().toString();
                String CGPA = cgpa.getText().toString();
                String HSC = hsc.getText().toString();
                String SSC = ssc.getText().toString();
                int radiobuttonid = rgp.getCheckedRadioButtonId();
                rd = (RadioButton) findViewById(radiobuttonid);
                String Gender = rd.getText().toString();
                dbcon1.insert_field(Rollno, Name, Gender, Mail, Phn, Age, Addrress, CGPA, HSC, SSC);
                Intent intent10=new Intent(Stu_Register.this,Stu_Success.class);
                intent10.putExtra("Name", Name);
                intent10.putExtra("Gender", Gender);
                intent10.putExtra("Mail", Mail);
                intent10.putExtra("Phn", Phn);
                intent10.putExtra("Addrress", Addrress);
                intent10.putExtra("Age", Age);
                intent10.putExtra("Roll", Rollno);
                intent10.putExtra("CGPA", CGPA);
                intent10.putExtra("HSC", HSC);
                intent10.putExtra("SSC", SSC);

                startActivity(intent10);
            }
        });

    }
}
