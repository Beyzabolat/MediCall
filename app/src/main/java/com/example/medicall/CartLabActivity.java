package com.example.medicall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class CartLabActivity extends AppCompatActivity {
HashMap<String ,String> item;
ArrayList list;
SimpleAdapter sa;
TextView tvTotal;
private DatePickerDialog datePickerDialog;
private TimePickerDialog timePickerDialog;
private Button dateButton, timebutton,btncheckout;
private String[][] packages={};
ListView lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_lab);

        dateButton=findViewById(R.id.buttonAppDate);
        timebutton=findViewById(R.id.buttonAppTime);
        btncheckout=findViewById(R.id.buttoncheckout);
        tvTotal=findViewById(R.id.textViewtotalCost);
        lst=findViewById(R.id.listViewCart);


        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username"," ").toString();
        Database db=new Database(getApplicationContext(),"healthcare",null,1);

        float totalAmount=0;
        ArrayList dbData=db.getCartData(username,"lab");

        Toast.makeText(getApplicationContext(),""+dbData,Toast.LENGTH_LONG).show();

        packages=new String[dbData.size()][];
        for (int i=0;i<packages.length;i++){
            packages[i]=new String[5];
        }

        for (int i=0;i<dbData.size();i++){
            String arrData=dbData.get(i).toString();
            String[] strData=arrData.split(java.util.regex.Pattern.quote("₺"));
            packages[i][0]=strData[0];
            packages[i][2]=strData[1]+"/-";
            totalAmount=totalAmount+Float.parseFloat(strData[1]);


        }
        tvTotal.setText("Toplam Tutar: "+totalAmount);

        list=new ArrayList();
        for (int i=0;i<packages.length;i++){
            item= new HashMap<String,String >();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines3,
                new String[]{"line1","line2","line3"},
                new int[]{R.id.textViewTestName,R.id.textViewTestType,R.id.textViewTestCost});
        lst.setAdapter(sa);





        ImageButton backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartLabActivity.this,LabTestActivity.class));
            }
        });


        btncheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(CartLabActivity.this,LabTestBookActivity.class);
                it.putExtra("price", tvTotal.getText());
                it.putExtra("date", dateButton.getText());
                it.putExtra("time", timebutton.getText());
                startActivity(it);
            }
        });



        //datepicker
        initDatePicker();
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });


        //timepicker
        initTimePicker();
        timebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });



    }
    private void initDatePicker(){
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                i1=i1+1;
                dateButton.setText(i2+"/"+i1+"/"+i);

            }
        };
        Calendar cal=Calendar.getInstance();
        int year= cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        int style= AlertDialog.THEME_HOLO_DARK;
        datePickerDialog=new DatePickerDialog(this,dateSetListener,year,month,day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis()+86400000);
    }
    private void initTimePicker(){
        TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int i, int i1) {
                timebutton.setText(i+":"+i1);


            }
        };

        Calendar cal=Calendar.getInstance();
        int hrs=cal.get(Calendar.HOUR);
        int mins=cal.get(Calendar.MINUTE);
        int style= AlertDialog.THEME_HOLO_DARK;
        timePickerDialog=new TimePickerDialog(this, style, timeSetListener, hrs, mins,true);


    }
}