package com.geeks.salkynbek_uulu_almazbek_hw_3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        String name = getIntent().getStringExtra("nameEdit");
        TextView textView = findViewById(R.id.nameTextView);
        textView.setText(name);

        String surname = getIntent().getStringExtra("surnameEdit");
        TextView textView1 = findViewById(R.id.surnameTextView);
        textView1.setText(surname);

        String age = getIntent().getStringExtra("ageEdit");
        TextView textView2 = findViewById(R.id.ageTextView);
        textView2.setText(age);



    }


}