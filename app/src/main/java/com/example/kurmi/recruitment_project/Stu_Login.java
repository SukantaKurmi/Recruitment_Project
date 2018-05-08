package com.example.kurmi.recruitment_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Stu_Login extends AppCompatActivity {
    Spinner cmpname;
    Button apply,dele;
    EditText uniroll;
    Dbcontroller1 dbcon1;
    Dbcontroller3 dbcon3;
    String labell;
    String cmpny[] = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu__login);
        dbcon1 = new Dbcontroller1(this, "", null, 1);
        dbcon3 = new Dbcontroller3(this, "", null, 1);
       cmpname=(Spinner)findViewById(R.id.sp_name);
       apply=(Button)findViewById(R.id.bt_apply);
       dele=(Button)findViewById(R.id.bt_studel);
       uniroll=(EditText)findViewById(R.id.et_uniroll);

        cmpny[0] = "TCS";
        cmpny[1] = "Wipro";
        cmpny[2] = "IBM";
        cmpny[3] = "CTS";
        cmpny[4] = "CAPGIMENI";
        cmpny[5] = "KREETI TECH";

        cmpname.setAdapter(new Testcmp());

        cmpname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                labell = cmpny[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Roll=uniroll.getText().toString();
                String CGPA=dbcon1.search_cgpa(Roll);
                String HSC=dbcon1.search_hsc(Roll);
                String SSC=dbcon1.search_ssc(Roll);
                int colg=Integer.parseInt(CGPA);
                int higher=Integer.parseInt(HSC);
                int sec=Integer.parseInt(SSC);


                if(labell.equalsIgnoreCase("TCS") && colg<70 && higher<70 && sec<70){
                    Toast.makeText(Stu_Login.this,"Cutt off not match",Toast.LENGTH_LONG).show();
                    labell="";
                    Intent intent11=new Intent(Stu_Login.this,Student.class);
                    startActivity(intent11);
                }
                if(labell.equalsIgnoreCase("WIPRO") && colg<75 && higher<75 && sec<75){
                    Toast.makeText(Stu_Login.this,"Cutt off not match",Toast.LENGTH_LONG).show();
                    labell="";
                    Intent intent11=new Intent(Stu_Login.this,Student.class);
                    startActivity(intent11);
                }
                if(labell.equalsIgnoreCase("IBM") && colg<80 && higher<80 && sec<80){
                    Toast.makeText(Stu_Login.this,"Cutt off not match",Toast.LENGTH_LONG).show();
                    labell="";
                    Intent intent11=new Intent(Stu_Login.this,Student.class);
                    startActivity(intent11);
                }
                if(labell.equalsIgnoreCase("CTS") && colg<70 && higher<70 && sec<70) {
                    Toast.makeText(Stu_Login.this, "Cutt off not match", Toast.LENGTH_LONG).show();
                    labell = "";
                    Intent intent11 = new Intent(Stu_Login.this, Student.class);
                    startActivity(intent11);
                }
                Toast.makeText(Stu_Login.this,"Applied successfully",Toast.LENGTH_LONG).show();
                dbcon3.insert_stu(Roll,labell);
            }
        });



        dele.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String Roll=uniroll.getText().toString();
               dbcon1.delete_stu(Roll);
               Toast.makeText(Stu_Login.this,"Student Deleted Successfully",Toast.LENGTH_LONG).show();
           }
       });




    }
    public class Testcmp extends BaseAdapter {

        @Override
        public int getCount() {
            return cmpny.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater lf = getLayoutInflater();
            convertView = lf.inflate(R.layout.row, parent, false);
            TextView tvdata = (TextView) convertView.findViewById(R.id.tv_data);
            tvdata.setText(cmpny[position]);
            return convertView;
        }

    }
}


