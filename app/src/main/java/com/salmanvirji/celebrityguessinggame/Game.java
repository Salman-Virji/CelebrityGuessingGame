package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import org.json.JSONException;
import org.json.JSONObject;


public class Game extends AppCompatActivity {
    String JSON_STRING = "{\"celebs\":{\"name1\":\"Bobert\",\"name2\":\"John\",\"name3\":\"Smith\",\"name4\":\"Bob\",\"correct\":\"Salman\"}}";

    String n1,n2,n3,n4,correct;
    Button btnChoice1, btnChoice2, btnChoice3, btnChoice4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
        btnChoice3 = (Button) findViewById(R.id.btnChoice3);
        btnChoice4 = (Button) findViewById(R.id.btnChoice4);

        //https://abhiandroid.com/programming/json
        try{
            JSONObject obj = new JSONObject(JSON_STRING);
            JSONObject celebs = obj.getJSONObject("celebs");
            n1=celebs.getString("name1");
            n2=celebs.getString("name2");
            n3=celebs.getString("name3");
            n4=celebs.getString("name4");
            correct=celebs.getString("correct");

            btnChoice1.setText(n1);
            btnChoice2.setText(n2);
            btnChoice3.setText(n3);
            btnChoice4.setText(n4);
        }
        catch(JSONException e){
            e.printStackTrace();
        }



    }

}

