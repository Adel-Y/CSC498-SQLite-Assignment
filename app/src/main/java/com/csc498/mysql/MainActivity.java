package com.csc498.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    try{

        SQLiteDatabase sql = this.openOrCreateDatabase("finaldb",MODE_PRIVATE,null);
        sql.execSQL("CREATE Table IF NOT EXISTS exams(exam_name VARCHAR, exam_date VARCHAR)");
//        sql.execSQL("INSERT INTO exams(exam_name,exam_date) VALUES('mobile computing','May 13')");
//        sql.execSQL("INSERT INTO exams(exam_name,exam_date) VALUES('microeconomics','May 7')");

        Cursor cursor = sql.rawQuery("SELECT * FROM exams",null);
        int name_index= cursor.getColumnIndex("exam_name");
        int date_index= cursor.getColumnIndex("exam_date");

    }catch (Exception e){
        e.printStackTrace();
    }


    }
}