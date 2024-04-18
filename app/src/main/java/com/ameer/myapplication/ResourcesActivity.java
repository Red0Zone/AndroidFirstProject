package com.ameer.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResourcesActivity extends AppCompatActivity {

    private Button bt1,bt2,bt3,bt4,bt5,bt6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resources);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        intiButtonsAction();

    }

    private void intiButtonsAction() {
        bt1 = findViewById(R.id.TextBook);
        bt2 = findViewById(R.id.onlineLectures);
        bt3 = findViewById(R.id.Exams);
        bt4 = findViewById(R.id.Slides);
        bt5 = findViewById(R.id.Wiki);
        bt6 = findViewById(R.id.Simlicable);

        bt1.setOnClickListener(e->{
            visitGoogleWebsite("https://www.infobooks.org/free-pdf-books/biology/");
        });
        bt2.setOnClickListener(e->{
            visitGoogleWebsite("https://www.youtube.com/c/biologylectures/");

        });
        bt3.setOnClickListener(e->{
            visitGoogleWebsite("https://drive.google.com/drive/folders/1hMh8OdZ0HtcPXiBIgWaMcL3JIgiL4fHJ/");

        });
        bt4.setOnClickListener(e->{
            visitGoogleWebsite("https://drive.google.com/drive/folders/1XUdAv1rqlgYvNo6L9SYSY8A5tI0qUKeN/");

        });
        bt5.setOnClickListener(e->{
            visitGoogleWebsite("https://en.wikipedia.org/wiki/Biology/");

        });
        bt6.setOnClickListener(e->{
            visitGoogleWebsite("https://simplicable.com/science/biology/");

        });
    }
    private void visitGoogleWebsite(String url){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}