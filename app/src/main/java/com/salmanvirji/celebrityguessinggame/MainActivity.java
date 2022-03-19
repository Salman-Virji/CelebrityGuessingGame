package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnPlay, btnHelp, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay =(Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(v -> openGame());

        btnHelp =(Button) findViewById(R.id.btnHowtoplay);
        btnHelp.setOnClickListener(v -> openHelp());

        btnAbout = (Button) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(v -> openAbout());

    }

    public void openGame(){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
        finish();
    }

    public void openHelp(){
        Intent intent2 = new Intent(this, Help.class);
        startActivity(intent2);
        finish();
    }

    public void openAbout(){
        Intent intent3 = new Intent(this, About.class);
        startActivity(intent3);
        finish();
    }


}