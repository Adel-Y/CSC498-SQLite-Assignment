package com.csc498.mysql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> examsArray = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, examsArray);

        listView.setAdapter(adapter);


    try{

        SQLiteDatabase sql = this.openOrCreateDatabase("finaldb",MODE_PRIVATE,null);
        sql.execSQL("CREATE Table IF NOT EXISTS exams(exam_name VARCHAR, exam_date VARCHAR)");
//        sql.execSQL("INSERT INTO exams(exam_name,exam_date) VALUES('mobile computing','May 13')");
//        sql.execSQL("INSERT INTO exams(exam_name,exam_date) VALUES('microeconomics','May 7')");

        Cursor cursor = sql.rawQuery("SELECT * FROM exams",null);
        int name_index= cursor.getColumnIndex("exam_name");
        int date_index= cursor.getColumnIndex("exam_date");

        cursor.moveToFirst();

        while (cursor!=null){
            String text =cursor.getString(name_index)+" on "+cursor.getString(date_index);
//            Toast.makeText(this,text,Toast.LENGTH_LONG).show();
            examsArray.add(text);

            cursor.moveToNext();
        }
        listView.setAdapter(adapter);




    }catch (Exception e){
        e.printStackTrace();
    }
        Intent intent = new Intent(getApplicationContext(),Webview.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                startActivity(intent);

            }
        });

    }
}