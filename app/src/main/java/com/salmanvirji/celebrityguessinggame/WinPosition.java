package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class WinPosition extends AppCompatActivity {

    TextView totalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        totalScore = findViewById(R.id.totalScore);
        totalScore.setText(this.getIntent().getExtras().getInt("score"));
    }
}
