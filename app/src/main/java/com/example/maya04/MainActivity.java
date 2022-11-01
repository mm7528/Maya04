package com.example.maya04;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button red,blue,click;
    Intent si;
    int blueCounter=0,redCounter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = (Button) findViewById(R.id.red);
        blue = (Button)findViewById(R.id.blue);
        si = new Intent(this,MainActivity2.class);
        Toast.makeText(this, "ready?! Let's go!!!", Toast.LENGTH_LONG).show();

        red.setOnLongClickListener(this);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blueCounter++;
            }


        });

    }

    @Override
    public void onActivityResult(int source, int good, @Nullable Intent data_back){
        super.onActivityResult(source,good,data_back);
        if(data_back!=null){
            blueCounter=data_back.getIntExtra("blue",0);
            redCounter = data_back.getIntExtra("red",0);
        }
    }


    @Override
    public boolean onLongClick(View view) {
        redCounter+=2;

        return true;
    }

    public void endGame(View view) {

        si.putExtra("blueCounter",blueCounter);
        si.putExtra("redCounter",redCounter);
        startActivityForResult(si,1);
    }
}