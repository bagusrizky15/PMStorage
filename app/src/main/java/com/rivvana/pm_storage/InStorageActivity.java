package com.rivvana.pm_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.appsearch.StorageInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InStorageActivity extends AppCompatActivity implements View.OnClickListener {

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

        String isiFile = "Hello";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void editFile(){

        String ubah = "Update Hello";
        File file = new File(getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try {
            file.createNewFile();
            outputStream = new FileOutputStream(file, false);
            outputStream.write(ubah.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    void readFile(){
        File storage = getFilesDir();
        File file = new File(storage, FILENAME);

        if (file.exists()){
            StringBuilder text = new StringBuilder();

            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();

                while (line!=null){
                    text.append(line);
                    line = br.readLine();
                }
                br.close();
            } catch (IOException e){
                System.out.println("Error " + e.getMessage());
            }
            tvRead.setText(text.toString());
        }
    }

    void deleteFile (){
        File file = new File(getFilesDir(), FILENAME);
        if (file.exists()){
            file.delete();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_create){
            createFile();
        }else if (id == R.id.btn_edit){
            editFile();
        }else if (id == R.id.btn_read){
            readFile();
        }else if (id == R.id.btn_delete){
            deleteFile();
        }
    }
}