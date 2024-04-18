package com.ameer.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btLessons,btVideos,btOres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btLessons=findViewById(R.id.btLessons);
        btVideos=findViewById(R.id.btVideos);
        btOres=findViewById(R.id.btnOres);
        btLessons.setOnClickListener(e->{btLessonsOnAction();});
        btVideos.setOnClickListener(e->{btVideosOnAction();});
    }

    private void btVideosOnAction() {
        Intent intent = new Intent(MainActivity.this,ShowVideoActivity.class);
        startActivity(intent);
    }

    private void btLessonsOnAction() {
        Intent intent = new Intent(MainActivity.this,lessonsActivity.class);
        startActivity(intent);
    }

    public void resOnClicked(View view) {
        Intent intent = new Intent(MainActivity.this,ResourcesActivity.class);
        startActivity(intent);
    }

}