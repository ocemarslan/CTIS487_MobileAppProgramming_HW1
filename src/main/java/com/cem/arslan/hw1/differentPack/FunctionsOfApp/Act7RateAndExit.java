package com.cem.arslan.hw1.differentPack.FunctionsOfApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cem.arslan.hw1.R;
import com.cem.arslan.hw1.StartingActivities.MainActivity;


//osman cem arslan ctis487 hw rateAndExit act
public class Act7RateAndExit extends AppCompatActivity {

    RatingBar ratingBar;
    TextView tvUserRating,hint;
    Button exitApp;
    ImageView kalpImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Notification and Status Bars
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_act7_rate_and_exit);

        /*******************************************************/
        tvUserRating = findViewById(R.id.userRating); //given score
        kalpImg=findViewById(R.id.kalpImg); //if you give 5
        hint=findViewById(R.id.tv5StarsHint);

        ratingBar = findViewById(R.id.APPratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBarp, float rating, boolean fromUser) {

                String rat = Float.toString(rating);
                tvUserRating.setText("Your rating is " + rat + " over 5.");
                if(rating==5){
                    kalpImg.setVisibility(View.VISIBLE);
                    hint.setVisibility(View.INVISIBLE);
                }else{
                    kalpImg.setVisibility(View.INVISIBLE);
                    hint.setVisibility(View.VISIBLE);
                }
            }
        });


        //Wrote exit comments below
        exitApp = findViewById(R.id.extAppBtn);

        exitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ActivityLastToFirst = new Intent(getApplicationContext(), MainActivity.class);
                ActivityLastToFirst.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                ActivityLastToFirst.putExtra("EXIT", true);
                startActivity(ActivityLastToFirst);
                finish();
                System.exit(0);
            }
        });
    }
}