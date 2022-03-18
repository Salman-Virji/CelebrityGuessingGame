package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Game extends AppCompatActivity implements View.OnClickListener  {

    ArrayList<String> celebList = new ArrayList<>();

    Button btnChoice1, btnChoice2, btnChoice3, btnChoice4,reset;
    TextView txtScorenum;
    String correctname ="correctname";
    String score ="0";
    ImageView celebimg;
   // String celebname;
    int index = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int score = 0;
        String s;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        celebimg = (ImageView)findViewById (R.id.imgPlaceHolder);
        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
        btnChoice3 = (Button) findViewById(R.id.btnChoice3);
        btnChoice4 = (Button) findViewById(R.id.btnChoice4);
        reset= findViewById(R.id.btnNext);

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
    public void getJSON(String correctname, String celebname)
    {

        String json;
        try{

            //getting the json file from the assets folder
            InputStream is = getAssets().open("celebs.json");
            int size = is.available();
            byte[] buffer = new byte[size];

            is.read(buffer);
            is.close();

            json = new String(buffer,"UTF-8");

            JSONArray jsonArray = new JSONArray(json);

            //travising the json and adding its contents to celebList
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

    //get celebrities to display
    public void getCelebs(){
        //Clears list everytime function is called
        celebList.clear();
        // String array holds celeb names. we use the index of the array to get the json data
        String[] name={"Ryan Reynolds","Danny Devito","Steve Buscemi","Bruno Mars","Justin Bieber","Katy Perry","Selena Gomez","Justin Timberlake","Win Screen"};
        // get json data and store it in the array list celebList
        getJSON(correctname,name[index].toString());

        // set btn text from celebList
        btnChoice1.setText(celebList.get(0).toString());
        btnChoice2.setText(celebList.get(1).toString());
        btnChoice3.setText(celebList.get(2).toString());
        btnChoice4.setText(celebList.get(3).toString());



        //Setting the celeb picture if index value matches the celeb name
        if(name[index] =="Ryan Reynolds"){
            celebimg.setImageResource(R.drawable.ryan_reynolds);
        }

        if(name[index] =="Danny Devito"){
            celebimg.setImageResource(R.drawable.danny_devito);
        }
        if(name[index] =="Steve Buscemi"){
            celebimg.setImageResource(R.drawable.steve_buscemi);
        }
        if(name[index] =="Bruno Mars"){
            celebimg.setImageResource(R.drawable.bruno_mars);
        }
        if(name[index] =="Justin Bieber"){
            celebimg.setImageResource(R.drawable.justin_bieber);
        }
        if(name[index] =="Justin Timberlake"){
            celebimg.setImageResource(R.drawable.justin_timberlake);
        }
        if(name[index] =="Katy Perry"){
            celebimg.setImageResource(R.drawable.katy_perry);
        }
        if(name[index] =="Selena Gomez"){
            celebimg.setImageResource(R.drawable.selena_gomez);
        }



    }


    // updates the score by incrementing the value
    public void getScore(){


        String s = txtScorenum.getText().toString();

        int i = Integer.parseInt(s);
        i++;

         score = new Integer(i).toString();

        txtScorenum.setText(score);


    }

    // function for disabling the buttons after answering
    public void disableButtons(){
        btnChoice1.setEnabled(false);
        btnChoice2.setEnabled(false);
        btnChoice3.setEnabled(false);
        btnChoice4.setEnabled(false);
    }

    // function for enabling the buttons after answering
    public void enableButtons(){
        btnChoice1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.purple_500));
        btnChoice2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.purple_500));
        btnChoice3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.purple_500));
        btnChoice4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.purple_500));
        btnChoice1.setEnabled(true);
        btnChoice2.setEnabled(true);
        btnChoice3.setEnabled(true);
        btnChoice4.setEnabled(true);
    }

    // go to win screen
    public void goToWinScreen(){

        Intent intent2 = new Intent(this, WinPosition.class);
        intent2.putExtra("score",score);
        startActivity(intent2);
        finish();
    }
    public void onClick(View v){


        int i = 0;
        //int index;
        int score = 0;

        // finding which button was clicked
        Button clickedBtn = findViewById(v.getId());

        //string array to hold celeb names same to get data off thier index postion
        String[] name={"Ryan Reynolds","Danny Devito","Steve Buscemi","Bruno Mars","Justin Bieber","Katy Perry","Selena Gomez","Justin Timberlake","end"};




            // incerment up the array to get new values
            if(clickedBtn.getText().equals("Next")){

                if(index == 7) {

                     goToWinScreen();

                   // index++;
                }
                else{
                   // setContentView(R.layout.activity_win);
                    enableButtons();
                    index++;

                }

                //at end of array go to win screen


                 //getCelebs based on new index
                getCelebs();


            }


            if(clickedBtn.getText().equals(name[index]) && !clickedBtn.getText().equals("Next") )
            {

               getScore();
                clickedBtn.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                disableButtons();



            }
            else if(!clickedBtn.equals(name[index])&& !clickedBtn.getText().equals("Next")){
                clickedBtn.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                disableButtons();

               // getCelebs();
            }







    }



}

