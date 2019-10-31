package com.geekhub.vernygora.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    final String KEY_COUNTRY = "country";
    final String KEY_COUNTRY_IMAGE = "image";
    MyRecyclerViewAdapter adapter;
    private String[] countries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countries = getResources().getStringArray(R.array.countries);

        ArrayList<String> countryNames = new ArrayList<>();
        countryNames.addAll(Arrays.asList(countries));

        ArrayList<Integer> countryImage = new ArrayList<>();
        countryImage.add(R.drawable.hungary_1);
        countryImage.add(R.drawable.china_2);
        countryImage.add(R.drawable.germany_3);
        countryImage.add(R.drawable.france_4);
        countryImage.add(R.drawable.japan_5);
        countryImage.add(R.drawable.australia_6);
        countryImage.add(R.drawable.usa_7);
        countryImage.add(R.drawable.australia_6);
        countryImage.add(R.drawable.australia_6);
        countryImage.add(R.drawable.australia_6);
        countryImage.add(R.drawable.australia_6);
        countryImage.add(R.drawable.australia_6);
        countryImage.add(R.drawable.france_13);
        countryImage.add(R.drawable.usa_14);
        countryImage.add(R.drawable.sweden_15);
        countryImage.add(R.drawable.greece_16);
        countryImage.add(R.drawable.italy_17);
        countryImage.add(R.drawable.ukraine_18);
        countryImage.add(R.drawable.portugal_19);
        countryImage.add(R.drawable.south_korea_20);

        RecyclerView recyclerView = findViewById(R.id.rvCountry);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        adapter = new MyRecyclerViewAdapter(this, countryNames, countryImage);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(MainActivity.this, DescriptionItem.class);
        intent.putExtra(KEY_COUNTRY, adapter.getItem(position));
        intent.putExtra(KEY_COUNTRY_IMAGE, adapter.getItemImage(position));
        startActivity(intent);
    }
}
