package com.example.myapp.View.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;
import com.example.myapp.View.Entrance;
import com.example.myapp.View.MainActivity;
import com.example.myapp.View.UserAllExams;
import com.example.myapp.View.UserCreateExam;

public class UserMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);

        onClickAllExams();
        onClickCreateExam();


        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    public void onClickAllExams() {
        Button btnAllUsers = findViewById(R.id.button_allExams);
        btnAllUsers.setOnClickListener(v -> {
            try {
                Intent intent = new Intent(UserMain.this, UserAllExams.class);
                startActivity(intent);
            }
            catch (Exception ignored){ }
        });
    }


    public void onClickCreateExam() {
        Button btnCreateUser = findViewById(R.id.button_createUser);
        btnCreateUser.setOnClickListener(v -> {
            try {
                Intent intent = new Intent( UserMain.this, UserCreateExam.class);
                startActivity(intent);
            }
            catch (Exception ignored){ }
        });
    }
    public void onClickReturn(View view) {
        // base.transition(R.id.button_back, AllUsers.this, MainAdmin.class);
        try {
            Intent intent = new Intent(UserMain.this, MainActivity.class);
            startActivity(intent);
        }
        catch (Exception ignored){ }
    }

    //Системная кнопка "назад"
    @Override
    public void onBackPressed() {
        //base.transition(AllUsers.this, MainAdmin.class);
        try {
            Intent intent = new Intent(UserMain.this, MainActivity.class);
            startActivity(intent);
        }
        catch (Exception ignored){ }
    }
}
