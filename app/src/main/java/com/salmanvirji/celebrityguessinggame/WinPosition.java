package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

public class WinPosition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openGame(){
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

}