package com.geekhub.Vernygora.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CatActivity extends AppCompatActivity implements View.OnClickListener {

    final String KEY_NAME_CAT = "nameCat";
    final String KEY_IMAGE = "image";
    Button btnPirate, btnBatman, btnViking;
    TextView CatName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cat);

        btnPirate = findViewById(R.id.pirateName);
        btnBatman = findViewById(R.id.batmanName);
        btnViking = findViewById(R.id.vikingName);
        CatName = findViewById(R.id.catName);

        btnPirate.setOnClickListener(this);
        btnBatman.setOnClickListener(this);
        btnViking.setOnClickListener(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra(KEY_NAME_CAT);

        CatName.setText("My cat\'s name is " + name);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.pirateName:
                intent.putExtra(KEY_IMAGE, R.drawable.cat_pirate);
                break;
            case R.id.batmanName:
                intent.putExtra(KEY_IMAGE, R.drawable.cat_batman);
                break;
            case R.id.vikingName:
                intent.putExtra(KEY_IMAGE, R.drawable.cat_viking);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();

    }
}

