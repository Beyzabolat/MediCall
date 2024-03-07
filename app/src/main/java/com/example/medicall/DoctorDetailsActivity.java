package com.example.medicall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.HashMap;


public class DoctorDetailsActivity extends AppCompatActivity{

    TextView tv;
    String[][] doctor_details={};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Aile Hekimleri")==0)
            doctor_details=doctor_details1;
        else

        if (title.compareTo("Diş Hekimleri")==0)
            doctor_details=doctor_details_2;
        else
        if (title.compareTo("Kardiyologlar")==0)
            doctor_details=doctor_details_3;
        else

        if (title.compareTo("Cerrahlar")==0)
            doctor_details=doctor_details_4;
        else

        if (title.compareTo("Diyetisyenler")==0)
            doctor_details=doctor_details_5;
        else
        if (title.compareTo("Göz Hekimleri")==0)
            doctor_details=doctor_details_6;
        else
            doctor_details=doctor_details_7;




        ImageButton backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });



        list = new ArrayList();
        for (int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5",doctor_details[i][4]+ "/-");
            list.add(item);




        }
        sa=new SimpleAdapter(this,list, R.layout.multi_lines, new String[]
                {"line1","line2","line3","line4","line5"},
                new int[]{R.id.textViewDoctorName,R.id.textViewHospitalAddress,R.id.textViewAge,
                        R.id.textViewPhoneNumber,R.id.textViewSalary}
        );
        ListView lst=findViewById(R.id.listviewDD);
        lst.setAdapter(sa);






    }

    private String[][] doctor_details1=
            {
                    {"Dr. Mehmet Yılmaz", "Ankara Caddesi No:123", "45", "555-123-4567", "600"},
                    {"Dr. Ayşe Kaya", "İstanbul Bulvarı No:456", "38", "555-987-6543", "600"},
                    {"Dr. Ahmet Demir", "İzmir Sokak No:789", "50", "555-567-8901", "600"},
                    {"Dr. Fatma Çelik", "Bursa Caddesi No:321", "42", "555-234-5678", "600"},
                    {"Dr. Ali Toprak", "Antalya Bulvarı No:654", "47", "555-876-5432", "600"},
                    {"Dr. Zeynep Yıldırım", "dana Sokak No:987", "35", "555-345-6789", "600"}

            };
    private String[][] doctor_details_2 = {
            {"Doktor Adı : Dr. Emre Aksoy", "Hastane Adresi : İzmir Bulvarı No:789", "Yaş : 40", "Telefon Numarası : 555-987-6543", "600"},
            {"Doktor Adı : Dr. Elif Korkmaz", "Hastane Adresi : Ankara Caddesi No:321", "Yaş : 37", "Telefon Numarası : 555-567-8901", "600"},
            {"Doktor Adı : Dr. Burak Demir", "Hastane Adresi : Bursa Sokak No:456", "Yaş : 48", "Telefon Numarası : 555-234-5678", "600"},
            {"Doktor Adı : Dr. Selin Yılmaz", "Hastane Adresi : Antalya Bulvarı No:654", "Yaş : 43", "Telefon Numarası : 555-876-5432", "600"},
            {"Doktor Adı : Dr. Canan Çelik", "Hastane Adresi : İstanbul Caddesi No:987", "Yaş : 39", "Telefon Numarası : 555-345-6789", "600"}
    };

    private String[][] doctor_details_3 = {
            {"Doktor Adı : Dr. Ali Kaplan", "Hastane Adresi : İstanbul Bulvarı No:123", "Yaş : 42", "Telefon Numarası : 555-123-4567", "600"},
            {"Doktor Adı : Dr. Zeynep Kaya", "Hastane Adresi : Ankara Sokak No:456", "Yaş : 36", "Telefon Numarası : 555-987-6543", "600"},
            {"Doktor Adı : Dr. Burak Yıldırım", "Hastane Adresi : İzmir Caddesi No:789", "Yaş : 41", "Telefon Numarası : 555-567-8901", "600"},
            {"Doktor Adı : Dr. Elif Demir", "Hastane Adresi : Antalya Bulvarı No:321", "Yaş : 49", "Telefon Numarası : 555-234-5678", "600"},
            {"Doktor Adı : Dr. Selim Çetin", "Hastane Adresi : Bursa Sokak No:654", "Yaş : 44", "Telefon Numarası : 555-876-5432", "600"}
    };

    private String[][] doctor_details_4 = {
            {"Doktor Adı : Dr. Cemal Yılmaz", "Hastane Adresi : İstanbul Sokak No:123", "Yaş : 47", "Telefon Numarası : 555-123-4567", "600"},
            {"Doktor Adı : Dr. Sevil Korkmaz", "Hastane Adresi : Ankara Bulvarı No:456", "Yaş : 35", "Telefon Numarası : 555-987-6543", "600"},
            {"Doktor Adı : Dr. Ayşe Kaya", "Hastane Adresi : İzmir Caddesi No:789", "Yaş : 50", "Telefon Numarası : 555-567-8901", "600"},
            {"Doktor Adı : Dr. Emir Demir", "Hastane Adresi : Antalya Sokak No:321", "Yaş : 46", "Telefon Numarası : 555-234-5678", "600"},
            {"Doktor Adı : Dr. Esra Yıldız", "Hastane Adresi : Bursa Bulvarı No:654", "Yaş : 34", "Telefon Numarası : 555-876-5432", "600"}
    };

    private String[][] doctor_details_5 = {
            {"Doktor Adı : Dr. Hasan Aksoy", "Hastane Adresi : Ankara Bulvarı No:123", "Yaş : 41", "Telefon Numarası : 555-123-4567", "600"},
            {"Doktor Adı : Dr. Yasemin Kaya", "Hastane Adresi : İstanbul Sokak No:456", "Yaş : 37", "Telefon Numarası : 555-987-6543", "600"},
            {"Doktor Adı : Dr. Murat Demir", "Hastane Adresi : İzmir Bulvarı No:789", "Yaş : 45", "Telefon Numarası : 555-567-8901", "600"},
            {"Doktor Adı : Dr. Aslı Çelik", "Hastane Adresi : Antalya Caddesi No:321", "Yaş : 39", "Telefon Numarası : 555-234-5678", "600"},
            {"Doktor Adı : Dr. Mehmet Toprak", "Hastane Adresi : Bursa Sokak No:654", "Yaş : 47", "Telefon Numarası : 555-876-5432", "600"}
    };

    private String[][] doctor_details_6 = {
            {"Doktor Adı : Dr. Zeki Yılmaz", "Hastane Adresi : İstanbul Bulvarı No:123", "Yaş : 48", "Telefon Numarası : 555-123-4567", "600"},
            {"Doktor Adı : Dr. Nazlı Korkmaz", "Hastane Adresi : Ankara Caddesi No:456", "Yaş : 36", "Telefon Numarası : 555-987-6543", "600"},
            {"Doktor Adı : Dr. Melis Demir", "Hastane Adresi : İzmir Sokak No:789", "Yaş : 43", "Telefon Numarası : 555-567-8901", "600"},
            {"Doktor Adı : Dr. Hakan Yıldırım", "Hastane Adresi : Antalya Bulvarı No:321", "Yaş : 40", "Telefon Numarası : 555-234-5678", "600"},
            {"Doktor Adı : Dr. Zehra Çelik", "Hastane Adresi : Bursa Caddesi No:654", "Yaş : 38", "Telefon Numarası : 555-876-5432", "600"}
    };
    private String[][] doctor_details_7 = {
            {"Doktor Adı : Dr. Zeki Yılmaz", "Hastane Adresi : İstanbul Bulvarı No:123", "Yaş : 48", "Telefon Numarası : 555-123-4567", "600"},
            {"Doktor Adı : Dr. Nazlı Korkmaz", "Hastane Adresi : Ankara Caddesi No:456", "Yaş : 36", "Telefon Numarası : 555-987-6543", "600"},
            {"Doktor Adı : Dr. Melis Demir", "Hastane Adresi : İzmir Sokak No:789", "Yaş : 43", "Telefon Numarası : 555-567-8901", "600"},
            {"Doktor Adı : Dr. Hakan Yıldırım", "Hastane Adresi : Antalya Bulvarı No:321", "Yaş : 40", "Telefon Numarası : 555-234-5678", "600"},
            {"Doktor Adı : Dr. Zehra Çelik", "Hastane Adresi : Bursa Caddesi No:654", "Yaş : 38", "Telefon Numarası : 555-876-5432", "600"}
    };





}
