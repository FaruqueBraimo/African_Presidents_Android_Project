package com.example.recycleview;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import model.President;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private RecyclerView presidentRecycleView;
    private  RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Menu menu;
    MyApplication myApplication = (MyApplication) this.getApplication();

    Button btn_addOne;
    List<President> presidentList;



    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_addOne = findViewById(R.id.btn_add);
        presidentList = myApplication.getPresidentList();


        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, President_Form.class );
                startActivity(intent);
            }
        });

        presidentRecycleView = findViewById(R.id.presidentList);
        presidentRecycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        presidentRecycleView.setLayoutManager(layoutManager);

        adapter = new  PresidentsAdapter(presidentList, MainActivity.this);
        presidentRecycleView.setAdapter(adapter);
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())  {
            case R.id.menu_a_z :

                List<President> sortedPresidents = presidentList.stream().sorted(Comparator.comparing(President::getName)).collect(Collectors.toList());

                adapter = new  PresidentsAdapter(sortedPresidents, MainActivity.this);
                presidentRecycleView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Presidentes sorteados de  A-Z", Toast.LENGTH_SHORT ).show();

                return  true;


            case R.id.menu_z_a:
                List<President> UnsortedPresidents = presidentList.stream().sorted(Comparator.comparing(President::getName).reversed()).collect(Collectors.toList());

                adapter = new  PresidentsAdapter(UnsortedPresidents, MainActivity.this);
                presidentRecycleView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Presidentes sorteados de Z-A", Toast.LENGTH_SHORT ).show();
                return  true;

            case R.id.data_desc:

                List<President> sortedByDate = presidentList.stream().sorted(Comparator.comparing(President::getDateElection)).collect(Collectors.toList());
                adapter = new  PresidentsAdapter(sortedByDate, MainActivity.this);
                presidentRecycleView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Presidentes sorteados a ordem Descendente", Toast.LENGTH_SHORT ).show();
                return  true;

            case R.id.date_asc :
                List<President> unSortedByDate = presidentList.stream().sorted(Comparator.comparing(President::getDateElection).reversed()).collect(Collectors.toList());
                adapter = new  PresidentsAdapter(unSortedByDate, MainActivity.this);
                presidentRecycleView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Presidentes sorteados a ordem Ascendente", Toast.LENGTH_SHORT ).show();
                return  true;

        }
        return  true;
    }


}