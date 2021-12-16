package com.example.lesson2android1;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity2 extends AppCompatActivity {
    ImageView imImageGallery;
    EditText etTransData;
    Button btnSenDataToMainActivity;
    Uri uriimage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        initView();
        listener();

    }

    private void initView() {
        imImageGallery = findViewById(R.id.in_image_gallery);
        etTransData = findViewById(R.id.trans_data);
        btnSenDataToMainActivity = findViewById(R.id.btn_trans_data_to_main_activity);

    }

    private void listener() {
        imImageGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
//                startActivity(intent);
                resultLauncher.launch("image/*");
            }

        });
        btnSenDataToMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = etTransData.getText().toString();
                Intent intent = new Intent(SecondActivity2.this, MainActivity.class);
                intent.putExtra("title", data);
                intent.putExtra("image", uriimage);
                startActivity(intent);
            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri uri) {
                    imImageGallery.setImageURI(uri);
                    uriimage = uri;
                }
            });

}