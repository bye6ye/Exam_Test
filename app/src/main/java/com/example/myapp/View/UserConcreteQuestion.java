package com.example.myapp.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapp.Models.Entities.Exam;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.Models.Entities.User;
import com.example.myapp.R;
import com.example.myapp.View.Admin.CreateUser;
import com.example.myapp.View.Admin.MainAdmin;
import com.example.myapp.View.Admin.UserMain;

public class UserConcreteQuestion extends AppCompatActivity {
    private EditText _subject, _questionCount, _questionDistribution;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_concrete_question);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void init() {
        Context context = getBaseContext();


        //_subject = findViewById(R.id.Subject);
        //_questionCount = findViewById(R.id.QuestionsCount);
        // _questionDistribution = findViewById(R.id.QuestionDistribution);
    }

    public void onClickCreate(View view) {
        try {

            // String subject = _subject.getText().toString();
            //  int questionCount = Integer.parseInt(_questionCount.getText().toString());
            //  int questionDistribution =Integer.parseInt(_questionDistribution.getText().toString());


            //  Exam exam = new Exam(subject, questionCount, questionDistribution);


        } catch (Exception ex) {
            Toast.makeText(getBaseContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        try {
            Intent intent = new Intent(UserConcreteQuestion.this, UserConcreteQuestion.class);
            startActivity(intent);
            finish();
        } catch (Exception ignored) {
        }
    }

}