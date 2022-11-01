package com.example.maya04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Intent gi;
    int blueCounter,redCounter;
    int sum;
    TextView blueResult, redResult,winner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        blueResult=(TextView) findViewById(R.id.blueResults);
        redResult=(TextView) findViewById(R.id.redResults);
        winner =(TextView) findViewById(R.id.winner);
        gi = getIntent();

        redCounter=gi.getIntExtra("redCounter",0);
        blueCounter=gi.getIntExtra("blueCounter",0);

        blueResult.setText("the blue player achieved: " + blueCounter + " points");
        redResult.setText("the red player achieved: " + redCounter + " points");

        if (blueCounter>redCounter){
            sum =blueCounter-redCounter;
            winner.setText("The Blue Player WON!!!!\n" + "he got " + sum + " more points than the other player!!\nBetter luck next time Red");
        }
        else if(blueCounter<redCounter){
            sum =redCounter-blueCounter;
            winner.setText("The Red Player WON!!!!\n" + "he got " + sum + " more points than the other player!!\nBetter luck next time Blue");
        }
        else{
            winner.setText("ITS A TIE!!!");
        }

    }


    public void startGame(View view) {
        gi.putExtra("red",0);
        gi.putExtra("blue",0);

        setResult(RESULT_OK,gi);
        finish();
    }
}