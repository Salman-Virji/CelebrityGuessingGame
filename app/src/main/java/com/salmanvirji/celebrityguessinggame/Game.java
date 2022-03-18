package com.salmanvirji.celebrityguessinggame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
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


public class Game extends AppCompatActivity  {

    //Declaration of variables:
    private ArrayList<Celeb> celebList;
    private Button option1, option2, option3, option4, next;
    private TextView scoreTextView;
    int score = 0;
    private ImageView celebrityImage;
    int question = 0;
    Button btnFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnFinish =(Button) findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(v -> openResults());

        //variables for buttons
        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);

        next = findViewById(R.id.next);

        // Displaying the score in game:
        scoreTextView = findViewById(R.id.score);
        scoreTextView.setText("Total Score: " + score);

        // variable for image view in game:
        celebrityImage = findViewById(R.id.image);

        // List instance:
        this.celebList = new ArrayList<>();

        addCelebs();

        startGame();

        // functionality of Next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableButtons();
                question++;
                startGame();
                resetButtonColors();
            }
        });
    }

    public void openResults(){
        Intent intent = new Intent(this, WinPosition.class);
        startActivity(intent);
    }

    // function implementation for resetting the colors after answering the question
    public void resetButtonColors(){
        option1.setBackgroundColor(Color.TRANSPARENT);
        option2.setBackgroundColor(Color.TRANSPARENT);
        option3.setBackgroundColor(Color.TRANSPARENT);
        option4.setBackgroundColor(Color.TRANSPARENT);
    }

    // function for storing and adding the celebrities to the questions
    public void addCelebs(){
        celebList.add(new Celeb("Bruno Mars", R.drawable.bruno_mars));
        celebList.add(new Celeb("Justin Bieber", R.drawable.justin_bieber));
        celebList.add(new Celeb("Justin Timberlake", R.drawable.justin_timberlake));
        celebList.add(new Celeb("Katy Perry", R.drawable.katy_perry));
        celebList.add(new Celeb("Selena Gomez", R.drawable.selena_gomez));
        celebList.add(new Celeb("Selena Gomez", R.drawable.ryan_reynolds));
        celebList.add(new Celeb("Selena Gomez", R.drawable.ben_afflek));
        celebList.add(new Celeb("Selena Gomez", R.drawable.steve_buscemi));
    }

    // function for disabling the buttons after answering
    public void disableButtons(){
        option1.setEnabled(false);
        option2.setEnabled(false);
        option3.setEnabled(false);
        option4.setEnabled(false);
    }

    // function for enabling the buttons after answering
    public void enableButtons(){
        option1.setEnabled(true);
        option2.setEnabled(true);
        option3.setEnabled(true);
        option4.setEnabled(true);
    }

    // function for starting the game and its implementation for every question with changing
    // the colors of buttons depends on answers, Correct or Wrong:
    public void startGame(){

        if (this.question == 0){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Usher");
            option2.setText("Bruno Mars");
            option3.setText("Justin Bieber");
            option4.setText("Pitbull");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });
        }

        if (this.question == 1){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Steven Tyler");
            option2.setText("Pitbull");
            option3.setText("Usher");
            option4.setText("Justin Bieber");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });
        }

        if (this.question == 2){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Justin Timberlake");
            option2.setText("Mark Antony");
            option3.setText("Chris Brown");
            option4.setText("Jojo");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    disableButtons();
                }
            });
        }

        if (this.question == 3){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Jennifer Aniston");
            option2.setText("Jennifer Lopez");
            option3.setText("Katy Perry");
            option4.setText("Selena Gomez");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    disableButtons();
                }
            });
        }

        if (this.question == 4){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Madonna");
            option2.setText("Christina Grimmie");
            option3.setText("Jennifer Lopez");
            option4.setText("Selena Gomez");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });
        }

        if (this.question == 5){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Seth Rogan");
            option2.setText("Brad Pitt");
            option3.setText("Ryan Reynolds");
            option4.setText("Elijah Woods");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    disableButtons();
                }
            });
        }

        if (this.question == 6){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Danny Devito");
            option2.setText("Leonardo DiCaprio");
            option3.setText("Steve Buscemi");
            option4.setText("Ben Afflek");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });
        }

        if (this.question == 7){
            celebrityImage.setImageResource(this.celebList.get(this.question).getImage());

            option1.setText("Danny Devito");
            option2.setText("Steve Carell");
            option3.setText("John Krasinski");
            option4.setText("Steve Buscemi");

            option1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option1.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option2.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    option3.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.wrong));
                    disableButtons();
                }
            });

            option4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    option4.setBackgroundColor(ContextCompat.getColor(Game.this, R.color.correct));
                    score += 1;
                    disableButtons();
                }
            });

        }

        // When last answer is reached, this function should redirect to the total score page:
        if (this.question == 8){
            Intent intent = new Intent(this, WinPosition.class);
            intent.putExtra("score", score);
            startActivity(intent);
            finish();
        }
    }

}

//    Button btnChoice1, btnChoice2, btnChoice3, btnChoice4,reset;
//    TextView txtScorenum;
//    String correctname ="correctname";
//   // String celebname;
//    int index = 0;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_game);
//
//        btnChoice1 = (Button) findViewById(R.id.btnChoice1);
//        btnChoice2 = (Button) findViewById(R.id.btnChoice2);
//        btnChoice3 = (Button) findViewById(R.id.btnChoice3);
//        btnChoice4 = (Button) findViewById(R.id.btnChoice4);
//        reset= findViewById(R.id.btnNext);
//
//        btnChoice1.setOnClickListener(this);
//        btnChoice2.setOnClickListener(this);
//        btnChoice3.setOnClickListener(this);
//        btnChoice4.setOnClickListener(this);
//        reset.setOnClickListener(this);
//
//
//        txtScorenum = findViewById(R.id.txtScorenum);
//        //gameStart();
//        getCelebs();
//
//
//
//
//
//
//    }
//
//    // https://www.youtube.com/watch?v=h71Ia9iFWfI tutorial on importing and parsing json data
//    private void getJSON(String correctname, String celebname)
//    {
//
//        String json;
//        try{
//            InputStream is = getAssets().open("celebs.json");
//            int size = is.available();
//            byte[] buffer = new byte[size];
//
//            is.read(buffer);
//            is.close();
//
//            json = new String(buffer,"UTF-8");
//
//            JSONArray jsonArray = new JSONArray(json);
//
//            for(int i = 0; i<jsonArray.length(); i++){
//                JSONObject obj = jsonArray.getJSONObject(i);
//                if(obj.getString(correctname).equals(celebname)){
//
//                    celebList.add(obj.getString("name1"));
//                    celebList.add(obj.getString("name2"));
//                    celebList.add(obj.getString("name3"));
//                    celebList.add(obj.getString("name4"));
//
//
//
//                }
//            }
//
//
//
//
//        }catch (IOException | JSONException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void getCelebs(){
//
//        celebList.clear();
//        String[] name={"Ryan Reynolds","Danny Devito","Steve Buscemi"};
//        getJSON(correctname,name[index].toString());
//        btnChoice1.setText(celebList.get(0).toString());
//        btnChoice2.setText(celebList.get(1).toString());
//        btnChoice3.setText(celebList.get(2).toString());
//        btnChoice4.setText(celebList.get(3).toString());
//
//
//
//    }
//
//
//    public void onClick(View v){
//
//
//        int i = 0;
//        //int index;
//        int score = 0;
//        String s;
//        Button clickedBtn = findViewById(v.getId());
//        String[] name={"Ryan Reynolds","Danny Devito","Steve Buscemi"};
//
//
//
//
//
//            if(clickedBtn.getText().equals("Next")){
//
//                if(index >=0 && index <=3){
//                    index++;
//                }
//                if(index ==3){
//                    index = 0;
//                }
//                getCelebs();
//            }
//
//
//            if(clickedBtn.getText().equals(name[index]) && !clickedBtn.getText().equals("Next") )
//            {
//                score += 1;
//                s =String.valueOf(score);
//                txtScorenum.setText(s);
//                clickedBtn.setText("Winner");
//
//
//
//            }
//            else if(!clickedBtn.equals(name[index])&& !clickedBtn.getText().equals("Next")){
//                clickedBtn.setText("Wrong");
//
//               // getCelebs();
//            }
//
//
//
//
//
//
//
//    }





