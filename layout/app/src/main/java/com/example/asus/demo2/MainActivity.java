package com.example.asus.demo2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView btnMassage, btnFacial, btnBrows, btnNails, btnMakeup, btnWaxing;
    private NavigationView menu;
    private ActionBarDrawerToggle menuIcon;
    private DrawerLayout draw;


    private void initialView() {
        btnMassage = findViewById(R.id.btn_Massage);
        btnFacial = findViewById(R.id.btn_Facial);
        btnBrows = findViewById(R.id.btn_Brows);
        btnNails = findViewById(R.id.btn_Nails);
        btnMakeup = findViewById(R.id.btn_Makeup);
        btnWaxing = findViewById(R.id.btn_Waxing);

        menu = findViewById(R.id.menu_home);
        draw = findViewById(R.id.draw);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        btnMassage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MassageActivity.class);
                startActivity(intent);
            }
        });
        btnFacial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FacialActivity.class);
                startActivity(intent);
            }
        });
        btnBrows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowsActivity.class);
                startActivity(intent);
            }
        });
        btnNails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NailsActivity.class);
                startActivity(intent);
            }
        });
        btnMakeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MakeupActivity.class);
                startActivity(intent);
            }
        });
        btnWaxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WaxingActivity.class);
                startActivity(intent);
            }
        });

        //set menu icon
        menuIcon = new ActionBarDrawerToggle(this, draw, R.string.open, R.string.close);
        draw.addDrawerListener(menuIcon);
        menuIcon.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set action for navigation view
        menu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                menuItem.setChecked(true);
                switch (id) {
                    case R.id.profileId:
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.cartId:
                        Toast.makeText(getApplicationContext(), "Click " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.promoteId:
                        Toast.makeText(getApplicationContext(), "Click " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.aboutUsId:
                        Intent intentAboutUs = new Intent(MainActivity.this, AboutUsActivity.class);
                        startActivity(intentAboutUs);
                        break;
                    case R.id.logoutId:
                        Toast.makeText(getApplicationContext(), "Click " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }

                draw.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }
    //open and close action for menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (menuIcon.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
