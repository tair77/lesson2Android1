package com.example.lesson2android1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    Button btnOpenSecondActivity;
    TextView meaning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.in_image);
        meaning = findViewById(R.id.tv_text);
        btnOpenSecondActivity = findViewById(R.id.btn_open_second_acnivity);

        btnOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity2.class);
                startActivity(intent);


            }
        });
        Intent intent = getIntent();
        String getData = intent.getStringExtra("title");
        meaning.setText(getData);

        Uri getImage = intent.getParcelableExtra("image");
        image.setImageURI(getImage);


    }
}