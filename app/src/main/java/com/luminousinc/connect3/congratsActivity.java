package com.luminousinc.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class congratsActivity extends AppCompatActivity {
    TextView winnerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);
        winnerText = (TextView) findViewById(R.id.textViewWinner);
    }

    public void playAgain(View v) {
        startActivity(new Intent(congratsActivity.this, MainActivity.class));
    }
}
