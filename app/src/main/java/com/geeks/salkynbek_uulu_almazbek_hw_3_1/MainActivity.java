package com.geeks.salkynbek_uulu_almazbek_hw_3_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity {

    EditText nameEditText, surnameEditText, ageEditText;
    MaterialButton buttonForNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setClick();

        // Добавляем TextWatcher для поля ageEditText
        ageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Ничего не делаем перед изменением текста
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Ничего не делаем во время изменения текста
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Проверяем, содержит ли текст только цифры
                String input = s.toString();
                if (!TextUtils.isEmpty(input) && !TextUtils.isDigitsOnly(input)) {
                    // Если текст содержит символы, отличные от цифр, удаляем их
                    ageEditText.setText(input.replaceAll("\\D+", ""));
                    ageEditText.setSelection(ageEditText.getText().length());
                }
            }
        });
    }

    // ...

    public void findViews() {
        buttonForNavigation = findViewById(R.id.navigationButton);
        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        ageEditText = findViewById(R.id.ageEditText);

    }

    private void setClick() {
        buttonForNavigation.setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String surname = surnameEditText.getText().toString();
            String age = ageEditText.getText().toString();

            if (TextUtils.isEmpty(name)) {
                showToast("Введите ваше имя.");
            } else if (TextUtils.isEmpty(surname)) {
                showToast("Введите вашу фамилию.");
            } else if (TextUtils.isEmpty(age)) {
                showToast("Введите ваш возраст.");
            } else {
                navigateToFirst(name, surname, age);
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private void navigateToFirst(String name, String surname, String age) {
        Intent intent = new Intent(MainActivity.this, FirstActivity.class);
        intent.putExtra("nameEdit", name);
        intent.putExtra("surnameEdit", surname);
        intent.putExtra("ageEdit", age);
        startActivity(intent);
    }
}