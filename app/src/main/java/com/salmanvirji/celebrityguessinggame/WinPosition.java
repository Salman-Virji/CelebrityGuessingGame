package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

public class WinPosition extends AppCompatActivity {

    Button button_home;
    TextView totalScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

       totalScore = findViewById(R.id.totalScore);
        totalScore.setText(this.getIntent().getExtras().getString("score"));
        button_home =(Button) findViewById(R.id.button_home);
        button_home.setOnClickListener(v -> goHome());
    }

    public void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
