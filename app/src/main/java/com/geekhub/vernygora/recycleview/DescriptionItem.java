package com.geekhub.vernygora.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionItem extends AppCompatActivity  {

    final String KEY_COUNTRY = "country";
    final String KEY_COUNTRY_IMAGE = "image";
    TextView descriptionCountry;
    ImageView descriptionImageCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descriprion_item);

        descriptionCountry = findViewById(R.id.textCountry);
        descriptionImageCountry = findViewById(R.id.imgCountry);

        Intent intent = getIntent();
        if (intent.hasExtra(KEY_COUNTRY) && intent.hasExtra(KEY_COUNTRY_IMAGE)) {
            String name = intent.getStringExtra(KEY_COUNTRY);
            int nameImage = intent.getIntExtra(KEY_COUNTRY_IMAGE, 0);

            descriptionCountry.setText("Country name is " + name);
            descriptionImageCountry.setImageResource(nameImage);

        }
    }
}
