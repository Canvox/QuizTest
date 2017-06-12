package net.dusktech.com.quiztest;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private QuestionActivity mQuestionLibrary = new QuestionActivity();

    private TextView mScoreView;
    private TextView mQuestionView;

    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

        //while (mQuestionNumber < 6) {
        updateQuestion();

            mButtonChoice1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    if (mButtonChoice1.getText() == mAnswer){
                        mScore = mScore + 1;
                        updateScore(mScore);
                        Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    }
                    updateQuestion();
                    check();
                }
            });

            mButtonChoice2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    if (mButtonChoice2.getText() == mAnswer){
                        mScore = mScore + 1;
                        updateScore(mScore);
                        Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    }
                    updateQuestion();
                    check();
                }
            });

            mButtonChoice3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    if (mButtonChoice3.getText() == mAnswer){
                        mScore = mScore + 1;
                        updateScore(mScore);
                        Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    }
                    updateQuestion();
                    check();
                }
            });

            mButtonChoice4.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){

                    if (mButtonChoice4.getText() == mAnswer){
                        mScore = mScore + 1;
                        updateScore(mScore);
                        Toast.makeText(MainActivity.this, "Correct", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(MainActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
                    }
                    updateQuestion();
                    check();
                }
            });
        //}

    }

    private void check(){
        if (mScore == (mQuestionLibrary.mQuestions.length-1)){
            win();
        }
    }

    private void updateQuestion(){
        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        System.out.println("++++++++++++++++++"+mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

        mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
        mQuestionNumber++;
        /*if (mQuestionNumber >= mQuestionLibrary.mQuestions.length-1){
            gameOver();
        }*/
    }

    private void updateScore(int point) {
        mScoreView.setText("" + mScore);
    }

    private void win(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Victory! Your score is " + mScore + "points")
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + "points" + (mQuestionLibrary.mQuestions.length-1))
                .setCancelable(false)
                .setPositiveButton("New Game",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                finish();
                            }
                        })
                .setNegativeButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}