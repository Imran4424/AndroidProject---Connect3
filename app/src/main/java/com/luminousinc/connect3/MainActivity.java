package com.luminousinc.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 - empty, 1 - red, 2 - yellow
    int activePlayer;
    int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winningPositions = {{0, 1, 2},
                                {3, 4, 5},
                                {6, 7, 8},
                                {0, 3, 6},
                                {1, 4, 7},
                                {2, 5, 8},
                                {0, 4, 8},
                                {2, 4, 6} };

    private Handler delayHandler;
    String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activePlayer = 1;
        delayHandler = new Handler();
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

        tappedCell.animate().translationYBy(2000).rotation(3600).setDuration(700);

        if(isWon() || isFull()) {
            // this is confusing but active player is changed after his turn
            if(1 == activePlayer) {
                winner = "Yellow Wins";
            } else {
                winner = "Red Wins";
            }

            delayHandler.postDelayed(startNewActivity, 1500);
        }
    }

    public boolean isWon() {
        for(int[] winOneDArr: winningPositions) {
            if(0 != gameState[winOneDArr[0]] && gameState[winOneDArr[0]] == gameState[winOneDArr[1]] && gameState[winOneDArr[1]] == gameState[winOneDArr[2]]) {
                return true;
            }
        }

        return  false;
    }

    public  boolean isFull() {
        for(int i = 0; i < gameState.length; i++) {
            if(0 == gameState[i]) {
                return  false;
            }
        }

        return true;
    }

    private Runnable startNewActivity = new Runnable() {
        @Override
        public void run() {
            Intent congratsActivityIntent = new Intent(MainActivity.this, congratsActivity.class);
            congratsActivityIntent.putExtra("winnerName", winner);
            startActivity(congratsActivityIntent);
        }
    };
}
