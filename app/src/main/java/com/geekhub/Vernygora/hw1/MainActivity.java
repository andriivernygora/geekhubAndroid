package com.geekhub.Vernygora.hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int REQUEST_CODE_IMAGE = 1;
    EditText CatName;
    Button btnCat, btnEmail;
    LinearLayout Linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCat = findViewById(R.id.submitCat);
        btnEmail = findViewById(R.id.emailBtn);
        CatName = findViewById(R.id.editTextName);
        Linear = findViewById(R.id.Linear);

        btnCat.setOnClickListener(this);
        btnEmail.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("myLogs", "requestCode = " + requestCode + ", resultCode = " + resultCode);
        if (resultCode == RESULT_OK) {
            int backgroundImage = data.getIntExtra("image", Color.WHITE);
            Linear.setBackground(getResources().getDrawable(backgroundImage, getApplicationContext().getTheme()));
        } else {
            Toast.makeText(MainActivity.this, "Wrong result", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.submitCat:
                if (CatName.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please input name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, CatActivity.class);
                    intent.putExtra("nameCat", CatName.getText().toString());
                    startActivityForResult(intent, REQUEST_CODE_IMAGE);
                }
                break;
            case R.id.emailBtn:
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@geekhub.com"});
                intent.putExtra(Intent.EXTRA_TEXT, "Message Body");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Some message");

                try {
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                    finish();
                    Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
