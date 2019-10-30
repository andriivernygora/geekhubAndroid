package com.geekhub.vernygora.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DescriptionItem extends AppCompatActivity  {

    final String KEY_COUNTRY = "country";
    TextView descriptionCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);

        descriptionCountry = findViewById(R.id.textCountry);

        Intent intent = getIntent();
        if (intent.hasExtra(KEY_COUNTRY)) {
            String name = intent.getStringExtra(KEY_COUNTRY);
            descriptionCountry.setText("Country name is " + name);

        }
    }
}
