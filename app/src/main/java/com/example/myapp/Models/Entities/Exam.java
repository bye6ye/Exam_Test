package com.example.myapp.Models.Entities;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class Exam {
    String subject;
    int questionCount,questionDistribution;

    public Exam(String subject,int questionCount,int  questionDistribution) {
        this.subject = subject;
        this.questionCount = questionCount;
        this.questionDistribution = questionDistribution;
    }
 //   Integer id;
 // User user;
  //  Date date;
  //  Boolean isActive;
  //  String name;
  //  List<Question> tickets;
}
