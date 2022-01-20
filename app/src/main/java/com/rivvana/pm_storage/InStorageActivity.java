package com.rivvana.pm_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class InStorageActivity extends AppCompatActivity {

    public static final String FILENAME = "myfile.txt";
    Button btnCreate , btnEdit, btnRead, btnDelete;
    TextView tvRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_storage);

        String title = "Internal Storage";
        getSupportActionBar().setTitle(title);

        btnCreate = findViewById(R.id.btn_create);
        btnEdit = findViewById(R.id.btn_edit);
        btnRead = findViewById(R.id.btn_read);
        btnDelete = findViewById(R.id.btn_delete);
        tvRead = findViewById(R.id.tv_read);

        btnCreate.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    void createFile(){
        
    }

}