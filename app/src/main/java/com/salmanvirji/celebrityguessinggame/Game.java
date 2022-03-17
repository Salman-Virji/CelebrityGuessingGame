package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Game extends AppCompatActivity implements View.OnClickListener  {

    ArrayList<String> celebList = new ArrayList<>();

    Button btnChoice1, btnChoice2, btnChoice3, btnChoice4,reset;
    TextView txtScorenum;
    String correctname ="correctname";
   // String celebname;
    int index = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
        btnChoice3 = (Button) findViewById(R.id.btnChoice3);
        btnChoice4 = (Button) findViewById(R.id.btnChoice4);
        reset= findViewById(R.id.idReset);

        btnChoice1.setOnClickListener(this);
        btnChoice2.setOnClickListener(this);
        btnChoice3.setOnClickListener(this);
        btnChoice4.setOnClickListener(this);
        reset.setOnClickListener(this);


        txtScorenum = findViewById(R.id.txtScorenum);
        //gameStart();
        getCelebs();






    }

    // https://www.youtube.com/watch?v=h71Ia9iFWfI tutorial on importing and parsing json data
    private void getJSON(String correctname, String celebname)
    {

        String json;
        try{
            InputStream is = getAssets().open("celebs.json");
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");

            JSONArray jsonArray = new JSONArray(json);

            for(int i = 0; i<jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                if(obj.getString(correctname).equals(celebname)){

                    celebList.add(obj.getString("name1"));
                    celebList.add(obj.getString("name2"));
                    celebList.add(obj.getString("name3"));
                    celebList.add(obj.getString("name4"));



                }
            }




        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
    }

    public void getCelebs(){

        celebList.clear();
        String[] name={"Ryan Renolds","Danny Devito","Steve Buscemi"};
        getJSON(correctname,name[index].toString());
        btnChoice1.setText(celebList.get(0).toString());
        btnChoice2.setText(celebList.get(1).toString());
        btnChoice3.setText(celebList.get(2).toString());
        btnChoice4.setText(celebList.get(3).toString());



    }


    public void onClick(View v){


        int i = 0;
        //int index;
        int score = 0;
        String s;
        Button clickedBtn = findViewById(v.getId());
        String[] name={"Ryan Renolds","Danny Devito","Steve Buscemi"};





            if(clickedBtn.getText().equals("Next")){

                if(index >=0 && index <=3){
                    index++;
                }
                if(index ==3){
                    index = 0;
                }
                getCelebs();
            }


            if(clickedBtn.getText().equals(name[index]) && !clickedBtn.getText().equals("Next") )
            {
                score++;
                s =String.valueOf(score);
                txtScorenum.setText(s);
                clickedBtn.setText("Winner");



            }
            else if(!clickedBtn.equals(name[index])&& !clickedBtn.getText().equals("Next")){
                clickedBtn.setText("Wrong");

               // getCelebs();
            }







    }



}

