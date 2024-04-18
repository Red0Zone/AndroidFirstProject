package com.ameer.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class showPageActivity extends AppCompatActivity {

    private TextView showPageTV2;
    private TextView showPageTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showPageTV2 = findViewById(R.id.showPageTV2);
        showPageTV = findViewById(R.id.showPageTV);
        int page =getIntent().getIntExtra("res",-1);
        showPage(page);
    }

    private void showPage(int page) {
        if(page ==0){
            showPageTV.setText("The Cell");
            showPageTV2.setText(R.string.TheCell);
        }
        if(page ==1){
            showPageTV.setText("Genetics");
            showPageTV2.setText(R.string.Genetics);
        }if(page ==2){
            showPageTV.setText("Metabolism");
            showPageTV2.setText(R.string.Metabolism);
        }if(page ==3){
            showPageTV.setText("Hormones");
            showPageTV2.setText(R.string.Hormones);
        }if(page ==4){
            showPageTV.setText("DNA");
            showPageTV2.setText(R.string.DNA);
        }

    }

    public void backButtonOnClick(View view) {
        finish();
    }
}