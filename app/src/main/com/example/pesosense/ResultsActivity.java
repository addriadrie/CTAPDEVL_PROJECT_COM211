package com.example.pesosense;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ImageButton backButton = findViewById(R.id.back_btn);

        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        imageView = findViewById(R.id.image);
        resultTextView = findViewById(R.id.result);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        String result = getIntent().getStringExtra("result");

        if (byteArray != null) {
            Bitmap imageBitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            imageView.setImageBitmap(imageBitmap);
        }

        resultTextView.setText(result);

        ImageButton convert = findViewById(R.id.convert_btn);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://wise.com/gb/currency-converter/usd-to-php-rate";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        ImageButton details = findViewById(R.id.details_btn);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.bsp.gov.ph/SitePages/CoinsAndNotes/NewGenerationCurrencyBanknotes.aspx";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}