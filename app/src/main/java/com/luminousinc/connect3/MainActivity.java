package com.luminousinc.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 0 - empty, 1 - red, 2 - yellow
    int activePlayer;
    int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activePlayer = 1;
    }

    public void dropIn(View tappedView) {
        ImageView tappedCell = (ImageView) tappedView;
        int index = Integer.parseInt(tappedCell.getTag().toString());

        if(0 != gameState[index]) {
            return;
        }

        gameState[index] = activePlayer;

        if(2 == activePlayer) {
            tappedCell.setTranslationY(-2000);
            tappedCell.setImageResource(R.drawable.yellow);

            activePlayer = 1;
        } else {
            tappedCell.setTranslationY(-2000);
            tappedCell.setImageResource(R.drawable.red);

            activePlayer = 2;
        }

        tappedCell.animate().translationYBy(2000).rotation(3600).setDuration(900);
    }
}
