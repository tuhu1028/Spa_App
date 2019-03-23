package com.example.asus.demo2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity  extends AppCompatActivity{
    private ImageView mImg;
    private TextView mTxtName, mTxtAddress, mTxtDescription, txtReadMore;
    private Context mContext;
    LinearLayout linearLayout;
    Button btnChooseTreatment,btnChooseTime,btnChooseDate,btnSubmit;

//    , PersistableBundle persistentState

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rv_detail);
        initialView();
        initialData();
        linearLayout = findViewById(R.id.view_detail);

        btnChooseTreatment = findViewById(R.id.btnChooseTreatment);
        btnChooseTime = findViewById(R.id.btnChooseTime);
        btnChooseDate = findViewById(R.id.btnChooseDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        mImg = (ImageView) findViewById(R.id.img_map_ma01);
        txtReadMore = (TextView) findViewById(R.id.txtReadMore);

        mImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
            }
        });

        btnChooseTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTreatment();
            }
        });
        btnChooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowDate();
            }
        });

        btnChooseTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTime();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),YourOrderActivity.class);
                startActivity(intent);
            }
        });
//        txtReadMore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!isFinishing()){
//                    Dialog dialog = new Dialog(getApplicationContext());
//                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//                    dialog.setContentView(R.layout.dialog_infor_readmore);
//                    dialog.show();
//                }
//            }
//        });


    }
    private void ShowTreatment(){
        PopupMenu popupMenu = new PopupMenu(this,btnChooseTreatment);
        popupMenu.getMenuInflater().inflate(R.menu.menu_treatment, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuTreatment1:
                        btnChooseTreatment.setText("Voucher 300,000đ ưu đãi còn 99,000đ/1 khách hàng");
                        break;
                    case R.id.menuTreatment2:
                        btnChooseTreatment.setText("Voucher 600,000đ ưu đãi còn 169,000đ/nhóm 02 khách hàng ");
                        break;
                    case R.id.menuTreatment3:
                        btnChooseTreatment.setText("Voucher 1,200,000đ ưu đãi còn 300,000đ/nhóm 04 khách hàng");
                        break;
//                    case R.id.menuTreatment4:
//                        btnChooseTreatment.setText("Treatment 4");
//                        break;
//                    case R.id.menuTreatment5:
//                        btnChooseTreatment.setText("Treatment 5");
//                        break;
//                    case R.id.menuTreatment6:
//                        btnChooseTreatment.setText("Treatment 5");
//                        break;
//                    case R.id.menuTreatment7:
//                        btnChooseTreatment.setText("Treatment 6");
//                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void ShowTime(){
        PopupMenu popupMenu = new PopupMenu(this,btnChooseTime);
        popupMenu.getMenuInflater().inflate(R.menu.menu_time, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuTime1:
                        btnChooseTime.setText("8:00 - 9:00");
                        break;
                    case R.id.menuTime2:
                        btnChooseTime.setText("9:00 - 10:00");
                        break;
                    case R.id.menuTime3:
                        btnChooseTime.setText("10:00 - 11:00");
                        break;
                    case R.id.menuTime4:
                        btnChooseTime.setText("14:00 - 15:00");
                        break;
                    case R.id.menuTime5:
                        btnChooseTime.setText("15:00 - 16:00");
                        break;
                    case R.id.menuTime6:
                        btnChooseTime.setText("16:00 - 17:00");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }
    private void ShowDate(){
        PopupMenu popupMenu = new PopupMenu(this,btnChooseDate);
        popupMenu.getMenuInflater().inflate(R.menu.menu_day, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menuDay1:
                        btnChooseDate.setText("Thứ sáu (22/3)");
                        break;
                    case R.id.menuDay2:
                        btnChooseTime.setText("Thứ bảy (23/3)");
                        break;
                    case R.id.menuDay3:
                        btnChooseTime.setText("Chủ Nhật (23/3)");
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void initialData() {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            }
        };
    }

    private void initialView() {
        mImg = findViewById(R.id.img_detail);
        mTxtDescription = findViewById(R.id.txt_detail_description);
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.txtReadMore){
//
//            ShowReadMore();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void ShowReadMore() {
//        final Dialog dialog = new Dialog(this);
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        dialog.setContentView(R.layout.dialog_infor_readmore);
//        dialog.show();
//    }

}
