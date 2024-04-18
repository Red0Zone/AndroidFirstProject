package com.ameer.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class lessonsActivity extends AppCompatActivity {

    private String[] lessons;
    private ListView lessonsList;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lessons);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lessons = new String[]{
          "The Cell","Genetics","Metabolism","Hormones","DNA"
        };
        lessonsList = findViewById(R.id.lessonsList);
        adapter=new ArrayAdapter(lessonsActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,lessons);
        lessonsList.setAdapter(adapter);
    
        lessonsList.setOnItemClickListener((parent, view, position, id) -> lessonsActivity.this.onItemClicked(parent,view,position,id));
    }

    private void onItemClicked(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(lessonsActivity.this,showPageActivity.class).putExtra("res",position);
            startActivity(intent);

    }



}