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

import com.example.asus.demo2.room.database.PosDatabase;
import com.example.asus.demo2.room.entities.User;
import com.example.asus.demo2.room.management.UserManagement;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    UserManagement userManagement;

    int id;
    EditText user;
    EditText pass;
    EditText copass;
    EditText phone;
    EditText fullname;
    Button btn;
    TextView txtUser, txtPass,txtLogin;
    PosDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user = (EditText) findViewById(R.id.register_username);
        pass = (EditText) findViewById(R.id.register_password);
        copass = (EditText) findViewById(R.id.register_confirmpassword);
        phone = (EditText) findViewById(R.id.register_phone);;

        fullname = (EditText) findViewById(R.id.register_fullname);

        btn = (Button) findViewById(R.id.btn_register);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            register();
            }
        });
    }

    private void register(){
        String mUser  = user.getText().toString();
        String mPass  = pass.getText().toString();
        String mCoPass  = copass.getText().toString();
        String mPhone = phone.getText().toString();
        String mFullname  = fullname.getText().toString();

        userManagement = new UserManagement(getApplication());
        if (mUser.isEmpty() || mPass.isEmpty() || mCoPass.isEmpty() || mFullname.isEmpty()){
            txtLogin = (TextView) findViewById(R.id.txtLogin);
            txtLogin.setTextColor(Color.RED);
            txtLogin.setText("All infor not null");
        }else

        //Check pass & cofirm pass is duplicate
        if (!mPass.equals(mCoPass)){
            txtPass = (TextView) findViewById(R.id.txtCheckPass);
            txtPass.setTextColor(Color.RED);
            txtPass.setText("Pass cofirm didn't duplicate");
        } else {
            User user = new User(mUser, mPass, mPhone, mFullname);
            try {
                userManagement.addUserItem(user);
                Log.e("List Register:",userManagement.toString());
//                for (User ur: userItemEntityList){
//                    int id = ur.getId();
//                    String name = ur.getUsername();
//                    String pass1 = ur.getPassword();
//                    Log.e("LIST","Id:" + id + ",name: " +name + ",pass: " + password);
//
//                }
                Toast.makeText(getApplicationContext(), "Insert Successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
            } catch (Exception e){
                Toast.makeText(getApplicationContext(), "Insert Failed. Dupliaction ID", Toast.LENGTH_SHORT).show();
                System.out.println("Exception Register: "+e.getMessage());
            }

        }
    }













































//    public void validate(){
//
//        String mUser  = user.getText().toString();
//        String mPass  = pass.getText().toString();
//        String mCoPass  = copass.getText().toString();
////        phone = (int) Integer.parseInt(String.valueOf(findViewById(R.id.register_phone)));
//        String mFullname  = fullname.getText().toString();
//
//        if (mUser.isEmpty() || mPass.isEmpty() || mCoPass.isEmpty() || mFullname.isEmpty()){
//            txtLogin = (TextView) findViewById(R.id.txtLogin);
//            txtLogin.setTextColor(Color.RED);
//            txtLogin.setText("All infor not null");
//        }else
//
//        //        Check pass & cofirm pass is duplicate
//        if (!mPass.equals(mCoPass)){
//            txtPass = (TextView) findViewById(R.id.txtCheckPass);
//            txtPass.setTextColor(Color.RED);
//            txtPass.setText("Pass cofirm didn't duplicate");
//        } else {
//            database = Room.databaseBuilder(this, PosDatabase.class, "userdb").allowMainThreadQueries().build();
////            database = Room.databaseBuilder(this, PosDatabase.class, "userdb").fallbackToDestructiveMigration().build();
//
//
//            User user = new User(id, mUser, mPass, phone, mFullname);
////        check user is duplicate
//            try{
//                database.getUserDao().addUser(user);
//                Toast.makeText(getApplicationContext(), "Insert Successfull", Toast.LENGTH_SHORT).show();
//            } catch (Exception e){
//                Toast.makeText(getApplicationContext(), "Insert Failed. Dupliaction ID", Toast.LENGTH_SHORT).show();
//                System.out.println("Exception Register: "+e.getMessage());
//            }
//
//        }
//
//
//
//    }
}
