package com.example.medicall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {



    private String[][] packages=
            {
                    {"Tüm Vücut Tarama", "", "", "", "999"},
                    {"Kan Testi Sonuçları", "", "", "", "299"},
                    {"İdrar Testi Sonuçları", "", "", "", "199"},
                    {"Karaciğer Fonksiyon Testi", "", "", "", "399"},
                    {"Tiroid Testi Sonuçları", "", "", "", "199"},
                    {"Kolesterol Testi Sonuçları", "", "", "", "149"},
            };
    private String[] packageDetails = {
            "Genel sağlık durumunu değerlendirmek için kapsamlı bir test paketi",
            "Kan hücreleri ve kimyasal bileşenlerinin değerlendirilmesi",
            "İdrar örneğinin analiz edilmesiyle böbrek ve idrar yolu sağlığını değerlendirme",
            "Karaciğer fonksiyonlarını ölçümlemek için bir dizi test",
            "Tiroid hormonları ve işlevi hakkında bilgi sağlamak için kullanılır",
            "Kandaki kolesterol seviyelerini değerlendirerek kardiyovasküler sağlık hakkında bilgi verir",
            "Tüm Vücut Tarama\n\nComplete Hemogram\n\nDolaşım sistemini, enfeksiyonları, kansızlığı ve diğer kan hastalıklarını değerlendirmek için kapsamlı bir test paketi",
            // Diğer alt paketlerin detayları buraya eklenecek
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGotoCart;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);



        btnGotoCart=findViewById(R.id.buttoncart);
        listView=findViewById(R.id.listviewT);

        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class));
            }
        });

        ImageButton backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i=0;i<packages.length;i++){
            item=new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", packages[i][4]+ "/-");
            list.add(item);


            sa=new SimpleAdapter(this,list, R.layout.multi_lines2,
                    new String[]
                    {"line1","line2","line3","line4","line5"},
                    new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
          listView.setAdapter(sa);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent it=new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                    it.putExtra("text1", packages[i][0]);
                    it.putExtra("text2", packageDetails[i]);
                    it.putExtra("text3", packages[i][4]);
                    startActivity(it);

                }
            });


        }
}}