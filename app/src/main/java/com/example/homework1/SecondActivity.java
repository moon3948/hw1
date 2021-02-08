package com.example.homework1;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SecondActivity extends AppCompatActivity {

    private EditText input;
    private TextView textView_title;
    private LinearLayout linearLayout;
    private String data;
    private Button button_generate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        linearLayout = findViewById(R.id.second_linear_layout);
        textView_title = findViewById(R.id.textView_title);
        button_generate = findViewById(R.id.button_generate);

        Intent intent = getIntent();
        try {
            data = intent.getStringExtra("madLib");
            JSONObject jObject = new JSONObject(data);
            String title = jObject.optString("title");
            textView_title.setText(title);

            String blanks = jObject.optString("blanks");
            JSONArray array = new JSONArray(blanks);

            for (int i = 0; i < blanks.length(); i++) {
                input = new EditText(this);
                input.setHint("Please enter " + array.getString(i));
                linearLayout.addView(input);

                TextView textView = new TextView(this);
                textView.setText(array.getString(i));
                linearLayout.addView(textView);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        button_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                value = input.getText().toString();
//                if (value.matches("")) {
//                    Toast.makeText(this, "Please fill out all inputs", Toast.LENGTH_SHORT).show();
//                    return;
//                }
                launchNextActivity(v);
            }
        });
    }

    public void launchNextActivity (View view) {
        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
        String message;
        message = input.getText().toString();
        intent.putExtra("result", message);
        startActivity(intent);

    }

}
