package com.example.quizapp;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String[] questions = {"The full form of DBMS is Data Base Management Structure.",
            "DBMS stores, modifies and retrieves data", "Charles Bachman along with his team invented the first DBMS known as Integrated Data Store (IDS).",
            " Information about data is known as Metadata", "Delete command is used to remove a relation from an SQL", "Left outer join operations do not preserve non-matched tuples.?"};
    private boolean[] answers = {false, true, true, true, false, false};
    private int score = 0;
    Button yes;
    Button no;
    TextView question;

    private int index= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        question.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the array is not going out of bounds
                if (index <= questions.length - 1) {
                    // If you have given correct answer
                    if(answers[index]){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();
                }
            }


        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the array is not going out of bounds
                if (index <= questions.length - 1) {
                    // If you have given correct answer
                    if(!answers[index]){
                        score++;
                    }
                    // Go to the next question
                    index++;
                    if (index <= questions.length - 1) {
                        question.setText(questions[index]);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Your score is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Restart the app to play again", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }



}