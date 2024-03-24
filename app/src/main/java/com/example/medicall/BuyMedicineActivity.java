package com.example.medicall;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Parol", "", "", "", "10"},
            {"Aspirin", "", "", "", "5"},
            {"Voltaren", "", "", "", "15"},
            {"Panadol", "", "", "", "8"},
            {"Nurofen", "", "", "", "12"},
            {"Advil", "", "", "", "9"},
            {"Tylenol", "", "", "", "7"},
            {"Claritin", "", "", "", "20"},
            {"Zyrtec", "", "", "", "18"},
            {"Benadryl", "", "", "", "13"},
            {"Sancotec", "", "", "", "25"},
            {"Buscopan", "", "", "", "17"},
            {"Daleron", "", "", "", "6"},
            {"Neurodex", "", "", "", "22"},
            {"Ranitidine", "", "", "", "14"},
            {"Cipralex", "", "", "", "30"},
            {"Tramadol", "", "", "", "28"},
            {"Lustral", "", "", "", "27"},
            {"Dexamethasone", "", "", "", "23"},
            {"Prednol", "", "", "", "21"},
            {"Amoxicillin", "", "", "", "11"},
            {"Cefuroxime", "", "", "", "19"},
            {"Clarithromycin", "", "", "", "24"},
            {"Fluconazole", "", "", "", "16"},
            // Diğer ilaç paketleri buraya eklenebilir
    };

    private String[][] packages_details = {
            {"Parol, ağrı kesici ilaç."},
            {"Aspirin, kan inceltici ve ağrı kesici ilaç."},
            {"Voltaren, ağrı kesici ve iltihap önleyici ilaç."},
            {"Panadol, ağrı kesici ve ateş düşürücü ilaç."},
            {"Nurofen, ağrı kesici ve ateş düşürücü ilaç."},
            {"Advil, ağrı kesici ve ateş düşürücü ilaç."},
            {"Tylenol, ağrı kesici ve ateş düşürücü ilaç."},
            {"Claritin, alerji semptomlarını hafifleten ilaç."},
            {"Zyrtec, alerji semptomlarını hafifleten ilaç."},
            {"Benadryl, alerji semptomlarını hafifleten ilaç."},
            {"Sancotec, kas spazmlarını ve ağrılarını hafifleten ilaç."},
            {"Buscopan, kas spazmlarını hafifleten ilaç."},
            {"Daleron, ağrı kesici ilaç."},
            {"Neurodex, nörolojik sorunları tedavi eden ilaç."},
            {"Ranitidine, mide asidini azaltan ilaç."},
            {"Cipralex, antidepresan ilaç."},
            {"Tramadol, şiddetli ağrıları kesen ilaç."},
            {"Lustral, antidepresan ilaç."},
            {"Dexamethasone, iltihap önleyici ve bağışıklık sistemini baskılayan ilaç."},
            {"Prednol, iltihap önleyici ilaç."},
            {"Amoxicillin, antibiyotik ilaç."},
            {"Cefuroxime, antibiyotik ilaç."},
            {"Clarithromycin, antibiyotik ilaç."},
            {"Fluconazole, mantar enfeksiyonlarını tedavi eden ilaç."},
            // Diğer ilaçların açıklamaları buraya eklenebilir
    };
    HashMap<String ,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnMed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.listviewBM);
        btnMed=findViewById(R.id.buttonmedicine);
        ImageButton backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,HomeActivity.class));
            }
        });
        btnMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this,CartBuyMedicineActivity.class));

            }
        });
        list=new ArrayList();
        for (int i=0;i<packages.length;i++){
            item= new HashMap<String,String >();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]);
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines2,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",packages[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });

    }
}