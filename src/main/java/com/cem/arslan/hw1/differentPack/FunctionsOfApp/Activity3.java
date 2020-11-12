package com.cem.arslan.hw1.differentPack.FunctionsOfApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cem.arslan.hw1.R;

import com.cem.arslan.hw1.StartingActivities.userInformation; //import userInformation class in order to be able to access intent content's object

//OSMAN CEM ARSLAN CTIS 487 HW1 _ ACT3
public class Activity3 extends AppCompatActivity {

    View GameScoreLayout;
    Intent intentFromAct2;
    String name, surname, gender;
    TextView tvRegisteredUsr,scoreTVForGameEst;
    Button btnAboutCTIS, btnCALCULATOR, btnESTIMATOR, btnRATEandEXIT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //Hide Notification and Status Bars
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_3);

        /****************************************************************/

        GameScoreLayout=findViewById(R.id.gameResultLayout);
        scoreTVForGameEst=findViewById(R.id.scoreOfGame);
        GameScoreLayout.setVisibility(View.INVISIBLE);


        intentFromAct2 = getIntent();  // take intent from act 2
        userInformation registeredUser = intentFromAct2.getParcelableExtra("user");
        name = registeredUser.getName();
        surname = registeredUser.getSurname();
        gender = registeredUser.getGender();


        String genderAbbreviation, toastMsg;

        if (gender.equalsIgnoreCase("female")) {
            genderAbbreviation = "Ms.";
        } else {
            genderAbbreviation = "Mrs.";
        }
        toastMsg = "Logged in as "+genderAbbreviation + surname ;
        Toast.makeText(this, toastMsg, Toast.LENGTH_SHORT).show();
        tvRegisteredUsr = findViewById(R.id.tvRegisteredUser);
        tvRegisteredUsr.setText("Welcome"+" "+genderAbbreviation+" "+name+" "+surname);




        btnAboutCTIS = findViewById(R.id.aboutCTISBtn);
        btnCALCULATOR = findViewById(R.id.calcBtn);
        btnESTIMATOR = findViewById(R.id.estGameBtn);
        btnRATEandEXIT = findViewById(R.id.rateAndExitBtn);

    }

    public void onClick(View view) {
        if (view.getId() == btnAboutCTIS.getId()) {
            Intent intentToActs = new Intent(this, Act4AboutCtis.class);
            startActivity(intentToActs);
        } else if (view.getId() == btnCALCULATOR.getId()) {
            Intent intentToActs = new Intent(this, Act5_calculator.class);
            startActivity(intentToActs);
        } else if (view.getId() == btnESTIMATOR.getId()) {
            Intent intentToActsEst = new Intent(this, Act6Estimator.class);
            intentToActsEst.putExtra("totalWrong",0);
            startActivityForResult(intentToActsEst,1);
        } else {
            Intent intentToActs = new Intent(this, Act7RateAndExit.class);
            startActivity(intentToActs);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle b = data.getExtras();
        String resultTakenFromGame = b.getString("totalWrongTrials");
        scoreTVForGameEst.setText(resultTakenFromGame);
        GameScoreLayout.setVisibility(View.VISIBLE);
    }
}