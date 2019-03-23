package com.example.asus.demo2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class SpaManagerActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Button btnChooseTreatment,btnChooseTimeFrom,btnChooseTimeEnd,btnChChoosePromote, btnsuccset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spa_manager);
        btnChooseTreatment = findViewById(R.id.btnChooseTreatment);
        btnChChoosePromote = findViewById(R.id.btnChoosePromote);
        btnChooseTimeFrom = findViewById(R.id.btnChooseTimeFrom);
        btnChooseTimeEnd = findViewById(R.id.btnChooseTimeEnd);
        btnsuccset = findViewById(R.id.btn_succset);

        btnsuccset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SpaManagerActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        btnChooseTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTreatment();
            }
        });
        btnChChoosePromote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChoosePromote();
            }
        });
        btnChooseTimeFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        btnChooseTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
                btnChooseTimeEnd.setText("29/03/2019");
            }
        });


    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        btnChooseTimeFrom.setText("22/03/2019");



    }

    private void ShowTreatment(){
        PopupMenu popupMenu = new PopupMenu(this,btnChooseTreatment);
        popupMenu.getMenuInflater().inflate(R.menu.menu_services, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuTreatment1:
                        btnChooseTreatment.setText("Massage 30p");
                        break;
                    case R.id.menuTreatment2:
                        btnChooseTreatment.setText("Massage 60p");
                        break;
                    case R.id.menuTreatment3:
                        btnChooseTreatment.setText("Massage 90p");
                        break;
                    case R.id.menuTreatment4:
                        btnChooseTreatment.setText("Massage 120p");
                        break;
                    case R.id.menuTreatment5:
                        btnChooseTreatment.setText("Massage 150p");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void ChoosePromote(){
        PopupMenu popupMenu = new PopupMenu(this,btnChChoosePromote);
        popupMenu.getMenuInflater().inflate(R.menu.menu_promote, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.btnChoosePromote1:
                        btnChChoosePromote.setText("khuyến mãi 10%");
                        break;
                    case R.id.btnChoosePromote2:
                        btnChChoosePromote.setText("khuyến mãi 20%");
                        break;
                    case R.id.btnChoosePromote3:
                        btnChChoosePromote.setText("khuyến mãi 30%");
                        break;
                    case R.id.btnChoosePromote4:
                        btnChChoosePromote.setText("khuyến mãi 40%");
                        break;
                    case R.id.btnChoosePromote5:
                        btnChChoosePromote.setText("khuyến mãi 50%");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
}
