package com.luminousinc.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 0 - yellow, 1 - red, 2 - empty
    int activePlayer;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activePlayer = 0;
    }

    public void dropIn(View tappedView) {
        ImageView tappedCell = (ImageView) tappedView;
        int index = Integer.parseInt(tappedCell.getTag().toString());

        if(2 != gameState[index]) {
            return;
        }

        if(0 == activePlayer) {
            tappedCell.setTranslationY(-2000);
            tappedCell.setImageResource(R.drawable.yellow);

            activePlayer = 1;
        } else {
            tappedCell.setTranslationY(-2000);
            tappedCell.setImageResource(R.drawable.yellow);

            activePlayer = 0;
        }

        tappedCell.animate().translationYBy(2000).rotation(3600).setDuration(900);
    }
}
