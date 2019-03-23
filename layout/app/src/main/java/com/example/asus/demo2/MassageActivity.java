package com.example.asus.demo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MassageActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Model> massagesList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_massage);

        recyclerView = findViewById(R.id.rv);

        massagesList = new ArrayList<>();

        massagesList.add(new Model(R.drawable.ma01,"My Spa","2 Bàu Bàng, Phường 13, Quận Tân Bình","100","99,000đ","1.0 km","Giảm 67%"));
        massagesList.add(new Model(R.drawable.ma20,"KHỎE Massage","38 Bùi Thị Xuân, Phường Bến Thành, Quận 1","100","210,000đ","2.3 km","Giảm 40%"));
        massagesList.add(new Model(R.drawable.ma30,"Lamode Beauté Home Spa","181/29 Âu Dương Lân, Phường 2, Quận 8","100","99,000đ ","4.6 km","Giảm 60%"));
        massagesList.add(new Model(R.drawable.ma40,"Spa Massage Khỏe Đẹp","145, Nguyễn Cư Trinh, Phường Nguyễn Cư Trinh, Quận 1, Hồ Chí Minh","100","99,000đ ","5.0 km","Giảm 90%"));

        massagesList.add(new Model(R.drawable.ma01,"My Spa","2 Bàu Bàng, Phường 13, Quận Tân Bình","100","99,000đ","1.0 km","Giảm 67%"));
        massagesList.add(new Model(R.drawable.ma20,"KHỎE Massage","38 Bùi Thị Xuân, Phường Bến Thành, Quận 1","100","210,000đ","2.3 km","Giảm 40%"));
        massagesList.add(new Model(R.drawable.ma30,"Lamode Beauté Home Spa","181/29 Âu Dương Lân, Phường 2, Quận 8","100","99,000đ ","4.6 km","Giảm 60%"));
        massagesList.add(new Model(R.drawable.ma40,"Spa Massage Khỏe Đẹp","145, Nguyễn Cư Trinh, Phường Nguyễn Cư Trinh, Quận 1, Hồ Chí Minh","100","99,000đ ","5.0 km","Giảm 90%"));


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvLiLayoutManager = layoutManager;

        recyclerView.setLayoutManager(rvLiLayoutManager);

        Adapter adapter = new Adapter(this, massagesList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MassageActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
