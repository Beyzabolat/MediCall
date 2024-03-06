package com.example.medicall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        // Geri butonuna tıklama işlemi
        ImageButton backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Aktiviteyi kapat
            }
        });

        // Kartlara tıklama işlemi
        CardView family=findViewById(R.id.cardFamilyPhysician);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Aile Hekimi");
                startActivity(it);

            }
        });
        CardView dentist=findViewById(R.id.cardDentist);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Diş Hekimi");
                startActivity(it);

            }
        });
        CardView cardiolog=findViewById(R.id.cardcardiologists);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Kardiyologlar");
                startActivity(it);

            }
        });
        CardView surgeon=findViewById(R.id.cardsurgeon);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Cerrah");
                startActivity(it);

            }
        });
        CardView dietician=findViewById(R.id.carddietician);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Diyetisyen");
                startActivity(it);

            }
        });CardView eye=findViewById(R.id.cardeye);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Göz Hekimi");
                startActivity(it);

            }
        });

    }

}
