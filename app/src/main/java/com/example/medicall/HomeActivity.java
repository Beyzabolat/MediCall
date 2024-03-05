package com.example.medicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerViewAdaptery adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> appList;

    int[] covers = new int[]{
            R.drawable.home51,
            R.drawable.home21,
            R.drawable.home31,
            R.drawable.home41,
            R.drawable.home1,
            R.drawable.home2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        Toast.makeText(getApplicationContext(), "Hoşgeldin " + username + "!", Toast.LENGTH_SHORT).show();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menuu);

        recyclerView = findViewById(R.id.recyclerview);
        appList = new ArrayList<>();

        adapter = new RecyclerViewAdaptery(this, appList);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        IntializeDataIntoRecyclerView();

        adapter.setOnItemClickListener(new RecyclerViewAdaptery.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        Intent doctorIntent = new Intent(HomeActivity.this, FindDoctorActivity.class);
                        startActivity(doctorIntent);
                        break;
                    // Buraya diğer durumları ekleyin
                }
            }
        });
    }

    private void IntializeDataIntoRecyclerView() {
        appList.add(new row(covers[0]));
        appList.add(new row(covers[1]));
        appList.add(new row(covers[2]));
        appList.add(new row(covers[3]));
        appList.add(new row(covers[4]));
        appList.add(new row(covers[5]));
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
