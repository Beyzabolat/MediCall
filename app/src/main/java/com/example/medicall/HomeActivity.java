package com.example.medicall;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    private RecyclerViewAdaptery adapter;
    private StaggeredGridLayoutManager manager;
    private List<row> appList;

    int[] covers = new int[]{
            R.drawable.fash1,
            R.drawable.fash2,
            R.drawable.fash3,
            R.drawable.fash4,
            R.drawable.fash5,
            R.drawable.fash6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        // 1- Toolbar:
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // 4- Making the home button in toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator
                (R.drawable.menuu);




        // 5- Initializing RecyclerView
        recyclerView = findViewById(R.id.recyclerview);
        appList = new ArrayList<>();

        //Adapter
        adapter = new RecyclerViewAdaptery(this, appList);
        manager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);


        // Layout Manager
        recyclerView.setLayoutManager(manager);

        // Adapter
        recyclerView.setAdapter(adapter);

        // 6- Putting Data into recyclerView
        IntializeDataIntoRecyclerView();

    }
    private void IntializeDataIntoRecyclerView() {

        row a = new row(covers[0]);
        appList.add(a);

        a = new row(covers[1]);
        appList.add(a);

        a = new row(covers[2]);
        appList.add(a);

        a = new row(covers[3]);
        appList.add(a);

        a = new row(covers[4]);
        appList.add(a);

        a = new row(covers[5]);
        appList.add(a);

        adapter.notifyDataSetChanged();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return  super.onCreateOptionsMenu(menu);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if (id==R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}