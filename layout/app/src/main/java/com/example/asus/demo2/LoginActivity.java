package com.example.asus.demo2;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.demo2.room.daos.UserDao;
import com.example.asus.demo2.room.database.PosDatabase;
import com.example.asus.demo2.room.entities.User;
import com.example.asus.demo2.room.management.UserManagement;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    UserManagement userManagement;
    EditText username;
    EditText password;
    Button btnLogin;
    TextView tx1;
    PosDatabase database;
    public static final String BUNDLE = "bundel";
    public static final String USER = "USER";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);
        btnLogin = (Button)findViewById(R.id.btn_login);
        tx1 = (TextView)findViewById(R.id.txtLogin);
//        getListUser();



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateTamThoi();
            }
        });
    }
    public void validateTamThoi(){
        if (String.valueOf(username.getText()).equals("user")){
            Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), YourOrderActivity2.class);
            startActivity(intent);

        }
        if (String.valueOf(username.getText()).equals("admin")){
            Toast.makeText(getApplicationContext(), "Login By Admin", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), SpaManagerActivity.class);
            startActivity(intent);
        }
    }

    public void validate() {
        userManagement = new UserManagement(getApplication());
        userManagement.getAllUserItemEntity(new UserManagement.OnDataCallBackUserData() {
            @Override
            public void onDataSuccess(List<User> userItemEntityList) {
                List<User> list= userItemEntityList;
                for (User ur: userItemEntityList){
                    int id = ur.getId();
                    String name = ur.getUsername();
                    String pass = ur.getPassword();
                    Log.e("LIST","Id:" + id + ",name: " +name + ",pass: " + password);
                    if (String.valueOf(username.getText()).equals(name)) {
                        Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), YourOrderActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("USERNAME", "USER");
                        intent.putExtra(BUNDLE,bundle);
                        startActivity(intent);
                    }
                    if (String.valueOf(username.getText()).equals("admin")){
                        Toast.makeText(getApplicationContext(), "Login By Admin", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), SpaManagerActivity.class);
                        startActivity(intent);
                    }

                }
                Log.e("LIST", userItemEntityList.toString());
            }

            @Override
            public void onDataFail(String message) {
                Log.e("LIST", message);
                Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getListUser(){
        UserManagement management = new UserManagement(getApplication());
        management.getAllUserItemEntity(new UserManagement.OnDataCallBackUserData() {
            @Override
            public void onDataSuccess(List<User> userItemEntityList) {
                Toast.makeText(getApplicationContext(), "Login Successfull", Toast.LENGTH_SHORT).show();
                List<User> list= userItemEntityList;
                for (User ur: userItemEntityList){
                    int id = ur.getId();
                    String name = ur.getUsername();
                    String pass1 = ur.getPassword();
                    Log.e("LIST","Id:" + id + ",name: " +name + ",pass: " + password);

                }
                Log.e("LIST", userItemEntityList.toString());
            }

            @Override
            public void onDataFail(String message) {

            }
        });
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
//    neu duoc them cai attempt luc login sai
//    https://www.tutorialspoint.com/android/android_login_screen.htm
}
