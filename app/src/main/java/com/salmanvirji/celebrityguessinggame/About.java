package com.salmanvirji.celebrityguessinggame;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import org.w3c.dom.Text;

public class About extends AppCompatActivity {

    Button button_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        button_home =(Button) findViewById(R.id.btnHelpHome);
        button_home.setOnClickListener(v -> goHome());
    }

    public void goHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}