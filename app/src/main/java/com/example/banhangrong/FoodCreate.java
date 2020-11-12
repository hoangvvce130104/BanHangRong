package com.example.banhangrong;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class FoodCreate extends AppCompatActivity {
    private ImageView imgView;
    private ImageView imgView2;
    private ImageView imgView3;
    private ImageButton btnDelete1;
    private ImageButton btnDelete2;
    private ImageButton btnDelete3;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSTION_CODE = 100;
    private int check = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_food_create);
        imgView = findViewById(R.id.imgView);
        imgView2 = findViewById(R.id.imgView2);
        imgView3 = findViewById(R.id.imgView3);
        btnDelete1 = findViewById(R.id.btnDelete1);
        btnDelete2 = findViewById(R.id.btnDelete2);
        btnDelete3 = findViewById(R.id.btnDelete3);
        //hidden button
        btnDelete1.setVisibility(View.GONE);
        btnDelete2.setVisibility(View.GONE);
        btnDelete3.setVisibility(View.GONE);
        imgView.setImageResource(R.drawable.ic_action_add);
        imgView2.setImageResource(R.drawable.ic_action_add);
        imgView3.setImageResource(R.drawable.ic_action_add);
        //set onlick button
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                check = 1;
            }
        });
        imgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                check = 2;
            }
        });
        imgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPermission();
                check = 3;
            }

        });
        btnDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.setImageResource(R.drawable.ic_action_add);
                btnDelete1.setVisibility(View.GONE);
            }
        });
        btnDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView2.setImageResource(R.drawable.ic_action_add);
                btnDelete2.setVisibility(View.GONE);
            }
        });
        btnDelete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView3.setImageResource(R.drawable.ic_action_add);
                btnDelete3.setVisibility(View.GONE);
            }
        });
    }

    public void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                //not granted
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSTION_CODE
                );

            } else {
                //already granted
                pickImageFromGallery();
            }
        } else {
            pickImageFromGallery();
        }
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra("extra", 1);
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSTION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                } else {
                    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
            switch (check) {
                case 1:
                    imgView.setImageURI(data.getData());
                    btnDelete1.setVisibility(View.VISIBLE);
                    check = 0;
                    break;
                case 2:
                    imgView2.setImageURI(data.getData());
                    btnDelete2.setVisibility(View.VISIBLE);
                    check = 0;
                    break;
                case 3:
                    imgView3.setImageURI(data.getData());
                    btnDelete3.setVisibility(View.VISIBLE);
                    check = 0;
                    break;
                default:
                    break;
            }
        }
    }
}