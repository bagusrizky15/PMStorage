package com.rivvana.pm_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_in, btn_ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_in = findViewById(R.id.button_in);
        btn_in.setOnClickListener(v -> {
            Intent internal = new Intent(MainActivity.this, InStorageActivity.class);
            startActivity(internal);
        });

        btn_ex = findViewById(R.id.button_ex);
        btn_ex.setOnClickListener(v -> {
            Intent external = new Intent(MainActivity.this, ExStorageActivity.class);
            startActivity(external);
        });
    }
}