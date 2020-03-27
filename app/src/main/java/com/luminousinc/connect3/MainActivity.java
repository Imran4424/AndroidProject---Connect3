package com.luminousinc.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View tappedView) {
        ImageView tappedCell = (ImageView) tappedView;

        tappedCell.setTranslationY(-2000);
        tappedCell.setImageResource(R.drawable.yellow);
        tappedCell.animate().translationYBy(2000).rotation(3600).setDuration(1000);
    }
}
