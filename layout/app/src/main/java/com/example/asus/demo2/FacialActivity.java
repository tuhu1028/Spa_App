package com.example.asus.demo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FacialActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> facialList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facial);

        recyclerView = findViewById(R.id.rv);

        facialList = new ArrayList<>();
        facialList.add(new Model(R.drawable.fa00,"Zennie Brows Spa ","18 Bis/10A Nguyễn Thị Minh Khai, Đakao, Quận 1","100","99,000","1.0 km","Giảm 62%"));
        facialList.add(new Model(R.drawable.fa20,"Phòng khám Chuyên khoa Da liễu Red Apple ","30/1A Ngô Thời Nhiệm, Phường 7, Quận 3","100","249,000đ","2.3 km","Giảm 79%"));
        facialList.add(new Model(R.drawable.fa30,"V.Beauty Spa & Clinic","V.Beauty Spa & Clinic","100","86,000đ ","4.6 km","Giảm 86%"));
        facialList.add(new Model(R.drawable.fa40,"119,000đ ","18 Bis/10A Nguyễn Thị Minh Khai, Đakao, Quận 1","100","119,000đ","5.1 km","Giảm 86%"));

        facialList.add(new Model(R.drawable.fa00,"Zennie Brows Spa ","18 Bis/10A Nguyễn Thị Minh Khai, Đakao, Quận 1","100","99,000","1.0 km","Giảm 62%"));
        facialList.add(new Model(R.drawable.fa20,"Phòng khám Chuyên khoa Da liễu Red Apple ","30/1A Ngô Thời Nhiệm, Phường 7, Quận 3","100","249,000đ","2.3 km","Giảm 79%"));
        facialList.add(new Model(R.drawable.fa30,"V.Beauty Spa & Clinic","V.Beauty Spa & Clinic","100","86,000đ ","4.6 km","Giảm 86%"));
        facialList.add(new Model(R.drawable.fa40,"119,000đ ","18 Bis/10A Nguyễn Thị Minh Khai, Đakao, Quận 1","100","119,000đ","5.1 km","Giảm 86%"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);

        Adapter adapter = new Adapter(this, facialList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(FacialActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }
}
