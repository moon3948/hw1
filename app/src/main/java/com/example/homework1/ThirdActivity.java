package com.example.homework1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private TextView textView_info;
    private Button button_goHome;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        textView_info = findViewById(R.id.textView_info);
        button_goHome = findViewById(R.id.button_goHome);

        button_goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchNextActivity(v);
            }
        });

    }

    public void launchNextActivity (View v) {
        Intent intent = new Intent(ThirdActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
