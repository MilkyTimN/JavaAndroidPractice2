package com.example.javaandroidpractice2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextEmail = findViewById(R.id.et_email);
        EditText editTextPassword = findViewById(R.id.et_password);
        Button buttonEnter = findViewById(R.id.btn_enter);
        TextView text = findViewById(R.id.tv_enter_or_reg);
        LinearLayout horizontalContainer = findViewById(R.id.forget_pass_container);


        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0 && editTextPassword.getText().length() == 0) {
                    buttonEnter.setBackgroundTintList(getResources().getColorStateList(R.color.grey));
                } else {
                    buttonEnter.setBackgroundTintList(getResources().getColorStateList(R.color.orange));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        editTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @SuppressLint({"ResourceAsColor", "UseCompatLoadingForColorStateLists"})
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 0 && editTextEmail.getText().length() == 0) {
                    buttonEnter.setBackgroundTintList(getResources().getColorStateList(R.color.grey));
                } else {
                    buttonEnter.setBackgroundTintList(getResources().getColorStateList(R.color.orange));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        buttonEnter.setOnClickListener(view -> {
            if (editTextEmail.getText().toString().equals("admin") &&
                    editTextPassword.getText().toString().equals("admin")) {

                editTextEmail.setVisibility(View.INVISIBLE);
                editTextPassword.setVisibility(View.INVISIBLE);
                text.setVisibility(View.INVISIBLE);
                horizontalContainer.setVisibility(View.INVISIBLE);
                buttonEnter.setVisibility(View.INVISIBLE);

                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин и пароль", Toast.LENGTH_LONG).show();
            }
        });

    }
}