package com.example.omari.cis436proj4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView mathClass;
    CardView historyCard;
    CardView scienceCard;
    CardView codingCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mathClass = findViewById(R.id.MathCard);
        historyCard = findViewById(R.id.HistoryCard);
        scienceCard = findViewById(R.id.ScienceCard);
        codingCard = findViewById(R.id.CodingCard);

        mathClass.setOnClickListener(new View.OnClickListener() {
            // Go to Math Class Timer Activity

            @Override
            public void onClick(View v) {
                Intent math = new Intent(MainActivity.this, MathSubject.class);
                math.putExtra("class", R.mipmap.math_icon3); // Send Math icon
                startActivity(math);
            }
        });

        historyCard.setOnClickListener(new View.OnClickListener() {
            // Go to History Class Timer Activity

            @Override
            public void onClick(View v) {
                Intent history = new Intent(MainActivity.this, HistorySubject.class);
                history.putExtra("class", R.mipmap.history_icon_small); // Send History Icon
                startActivity(history);
            }
        });

        scienceCard.setOnClickListener(new View.OnClickListener() {
            // Go to Science Class Timer Activity

            @Override
            public void onClick(View v) {
                Intent science = new Intent(MainActivity.this, ScienceSubject.class);
                science.putExtra("class", R.mipmap.sciene_icon); // Send Science icon
                startActivity(science);
            }
        });

        codingCard.setOnClickListener(new View.OnClickListener() {
            // Go to Coding Class Timer Activity

            @Override
            public void onClick(View v) {
                Intent coding = new Intent(MainActivity.this, CodingSubject.class);
                coding.putExtra("class", R.mipmap.coding_icon3); // Send Coding icon
                startActivity(coding);
            }
        });
    }


}
