package com.example.asus.demo2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MakeupActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> MakeupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makeup);

        recyclerView = findViewById(R.id.rv);

        MakeupList = new ArrayList<>();

        MakeupList.add(new Model(R.drawable.ma01,"truongtuanket","quang trung","since 100$","abc"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);

        Adapter adapter = new Adapter(this,MakeupList);
        recyclerView.setAdapter(adapter);
    }
}
