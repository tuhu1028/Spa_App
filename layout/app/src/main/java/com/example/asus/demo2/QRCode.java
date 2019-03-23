package com.example.asus.demo2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class QRCode extends AppCompatActivity {
    private TextView text;
    private Button btn;
    private ImageView img;
    private String text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        text = findViewById(R.id.txtQR);
        img = findViewById(R.id.imgQRCode);

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        Date currentTime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        String strDate = dateFormat.format(currentTime);
        final String arr []= strDate.split(":");
        System.out.println("Time:"+arr[0]+arr[1] +arr[2]);
        Intent intent = getIntent();
        if (intent != null){
            Bundle bundle = intent.getBundleExtra(LoginActivity.BUNDLE);
            if (bundle != null) {
                text2 = bundle.getString(LoginActivity.USER);
            } else {
                text2 = intent.getStringExtra(LoginActivity.USER);
            }
        }
         Log.e("QRCODE USER:",text2+"");


        String textQR = arr[0] + arr[1] + arr[2];
        text.setText(textQR+"TUHU1028");
        if (textQR != null){
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            try {
                BitMatrix bitMatrix = multiFormatWriter.encode(text.getText().toString(), BarcodeFormat.QR_CODE, 500, 500);
                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                img.setImageBitmap(bitmap);
            }catch (WriterException e){
                e.printStackTrace();
            }
        }
    }
    }
