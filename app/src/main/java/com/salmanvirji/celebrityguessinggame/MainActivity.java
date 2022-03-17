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

    Button btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay =(Button) findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(v -> openGame());

    }

    public void openGame(){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }




}