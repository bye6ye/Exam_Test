package com.example.myapp.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;
import com.example.myapp.View.Admin.UserMain;

public class UserAllExams extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_my_exams);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }






    public void onClickReturn(View view) {
        try {
            Intent intent = new Intent(UserAllExams.this, UserMain.class);
            startActivity(intent);
        }
        catch (Exception ignored){ }
    }


    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(UserAllExams.this,UserMain.class);
            startActivity(intent);
        }
        catch (Exception ignored){ }
    }
}