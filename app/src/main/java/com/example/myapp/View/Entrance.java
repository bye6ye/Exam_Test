package com.example.myapp.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.Controller.Helpers.Constant;
import com.example.myapp.Controller.Services.BaseService;
import com.example.myapp.Controller.Helpers.Validation;
import com.example.myapp.Models.Entities.User;
import com.example.myapp.R;
import com.example.myapp.View.Admin.MainAdmin;
import com.example.myapp.View.Admin.UserMain;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Entrance extends AppCompatActivity {
    private DatabaseReference db;
    private BaseService base;
    private Validation validation;
    private User concrete_user;
    public  String concrete_login;
    public  String concrete_password;
    private int result;
    public  String concrete_user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entrance);

        init();
        onClickEntrance();

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void init(){
        Context context = getBaseContext();
        base = new BaseService();
        validation = new Validation(context);
        db = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    private void getUsers(String login, String password){
            ValueEventListener valueListener =  new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    User user = ds.getValue(User.class);

                    assert user != null;
                    if(user.login.equals(login)&& user.password.equals(password)){
                        concrete_login=user.login;
                        concrete_password=user.password;
                         concrete_user_id=ds.getKey();

                        result=1;

                        break;
                        }
                    else if(user.login.equals(login)&& !user.password.equals(password)){
                        result=2;
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        db.addValueEventListener(valueListener);
    }


    public void onClickEntrance() {
        Button btn_comeIn = findViewById(R.id.buttonComeIn);
        btn_comeIn.setOnClickListener(v -> {
            try {
                EditText login = findViewById(R.id.Login);
                EditText password = findViewById(R.id.Password);

                if (login.getText().toString().equals("admin") && password.getText().toString().equals("12345")) {
                    try {
                        Intent intent = new Intent(Entrance.this, MainAdmin.class);
                        startActivity(intent);

                    }
                    catch (Exception ignored){ }
                }
                else {
                    getUsers(login.getText().toString(),password.getText().toString());
                    if (result==1 ) {
                        try {

                            Intent intent = new Intent(Entrance.this, UserMain.class);
                            intent.putExtra("user_id",concrete_user_id);

                            startActivity(intent);
                        }
                        catch (Exception ignored){ }
                        }
                    else if(result==2)validation.message("Пароль введен неверно");
                    else validation.message("Такого пользователя не существует");
                }
            }
            catch (Exception ignored){ }
        });
    }


    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Entrance.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch (Exception ignored){ }
    }

    public void onClickReturn() {
        Button btnBack = findViewById(R.id.buttonBack);
        btnBack.setOnClickListener(v -> {
            try {

                Intent intent = new Intent(Entrance.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            catch (Exception ignored){ }
        });
    }
}
