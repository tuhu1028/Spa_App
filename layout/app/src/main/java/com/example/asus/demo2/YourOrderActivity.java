package com.example.asus.demo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class YourOrderActivity extends AppCompatActivity {

    Button btnFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);


        btnFinish = (Button) findViewById(R.id.btnFinish
        );
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);

//                Bundle bundle = intent.getExtras();
//                if (bundle != null) {
//                    String value1 = bundle.getString("USERNAME", "");
//                    Log.e("YOUR ORDER USER:",value1);
//                }
//                Log.e("YOUR ORDER USER:",bundle.getString("USERNAME", ""));
                startActivity(intent);
            }
        });
    }
}
