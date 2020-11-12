package com.cem.arslan.hw1.differentPack.FunctionsOfApp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cem.arslan.hw1.R;
import com.cem.arslan.hw1.StartingActivities.Activity2;
import com.cem.arslan.hw1.StartingActivities.MainActivity;

import java.util.Random;

public class Act6Estimator extends AppCompatActivity {

    Intent goBackIntent;
    Random r;
    int RndOutput;
    Button generateBtnn,exitGame;
    TextView tvRndHint,tvWrongEachCounter;
    EditText etRndGuess;
    int eachTryWrongGuesses = 0, totalWrongGuesses = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Notification and Status Bars
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_act6_estimator);

        /***************************************************************/

        r = new Random();
        RndOutput = 0;

        generateBtnn = findViewById(R.id.generateRndBtn);
        exitGame=findViewById(R.id.extGame);


        tvRndHint = findViewById(R.id.tvRndNumHint);
        tvRndHint.setText("-");

        tvWrongEachCounter=findViewById(R.id.TVwrongCnt);
        tvWrongEachCounter.setText("0");

        etRndGuess = findViewById(R.id.ETuserGuess);


        generateBtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RndOutput = r.nextInt((100 - 1) + 1) + 1;
                String out = Integer.toString(RndOutput);
                tvRndHint.setText(out);
                Toast.makeText(Act6Estimator.this, R.string.newRndGeneratedToast, Toast.LENGTH_LONG).show();
                eachTryWrongGuesses = 0;
                tvWrongEachCounter.setText("0");

            }
        });

        etRndGuess.setOnEditorActionListener
                (new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                int INTuserGuess = Integer.parseInt(etRndGuess.getText().toString());

                if (INTuserGuess == RndOutput) {
                    displayAlertDialog(eachTryWrongGuesses);
                    eachTryWrongGuesses=0;
                    tvWrongEachCounter.setText("0");
                    tvRndHint.setText("-");

                } else {
                    if (INTuserGuess > RndOutput) {
                        Toast.makeText(Act6Estimator.this, R.string.goDown, Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Act6Estimator.this, R.string.goUp, Toast.LENGTH_LONG).show();
                    }
                    eachTryWrongGuesses++;
                    String y=Integer.toString(eachTryWrongGuesses);
                    tvWrongEachCounter.setText(y);
                    totalWrongGuesses++;
                }

                return false;
            }
        });



        //exit without finish
        exitGame.setOnClickListener(new View.OnClickListener() {  //exit without finish
            @Override
            public void onClick(View v) {
                Intent intentTOBack=new Intent();
                Bundle b = new Bundle();
                String totalWrongString=Integer.toString(totalWrongGuesses);
                b.putString("totalWrongTrials",totalWrongString);
                intentTOBack.putExtras(b);
                setResult(RESULT_OK,intentTOBack);
                finish();
            }
        });

    }

    public void displayAlertDialog(int eachtotalWrong){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(R.string.gameCongratulations);
        String tmp = Integer.toString(eachtotalWrong);
        String outp="You found the random number after "+eachtotalWrong+" wrong guess(es).";

        alertDialogBuilder.setMessage(outp);
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_foreground);


        alertDialogBuilder.setNegativeButton(R.string.gameQuit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intentTOBack=new Intent();
                Bundle b = new Bundle();
                String totalWrongString=Integer.toString(totalWrongGuesses);
                b.putString("totalWrongTrials",totalWrongString);
                intentTOBack.putExtras(b);
                setResult(RESULT_OK,intentTOBack);
                finish();
            }
        });
        alertDialogBuilder.setPositiveButton(R.string.gameRESTART, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Act6Estimator.this, R.string.gameRESTART,Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.show();
    }
}