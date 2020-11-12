package com.cem.arslan.hw1.StartingActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cem.arslan.hw1.R;
import com.cem.arslan.hw1.differentPack.FunctionsOfApp.Activity3;


//Osman Cem ARSLAN, CTIS487, HOMEWORK_1
public class Activity2 extends AppCompatActivity {

    EditText userName, userSurname;
    TextView uLike;
    Dialog doYouLikeDialog;
    Button yesBtn, noBtn;
    RadioButton rbFemale, rbMale;
    RadioGroup rbGroup;
    userInformation newUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Notification and Status Bars
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_2);

        /**************************************************/

        uLike = findViewById(R.id.tvUlike);   //Textview: Do you like my first page
        createDailog();
        doYouLikeDialog.show();


        userName = findViewById(R.id.etUserName);
        userSurname = findViewById(R.id.etUserSurname);
        rbFemale = findViewById(R.id.rbFemale);
        rbMale = findViewById(R.id.rbMale);
        rbGroup = findViewById(R.id.rbGroup);


    }

    public void onClickContinue(View v) {
        int selectedRadioBtnID = rbGroup.getCheckedRadioButtonId();


        if (userName.getText().toString().length() == 0 || userSurname.getText().toString().length() == 0 || selectedRadioBtnID == -1) {
            Toast.makeText(this,"Please fill all areas!",Toast.LENGTH_SHORT).show();

        } else {
            RadioButton selectedGenderButton = findViewById(selectedRadioBtnID);
            String genderAsString = selectedGenderButton.getText().toString();
            newUser = new userInformation(userName.getText().toString(), userSurname.getText().toString(), genderAsString);
            Intent intentOfgoToAct3 = new Intent(Activity2.this, Activity3.class);
            intentOfgoToAct3.putExtra("user",newUser);
            startActivity(intentOfgoToAct3);
        }

    }


    //Re-open the dialog box when it is called again.
    public void onClickDialog(View view) {
        doYouLikeDialog.show();
    }


    //Create a Custom Dialog Box
    public void createDailog() {
        doYouLikeDialog = new Dialog(this);
        doYouLikeDialog.setContentView(R.layout.dialog);

        yesBtn = doYouLikeDialog.findViewById(R.id.yesIlikeBtn);
        noBtn = doYouLikeDialog.findViewById(R.id.ordinaryBtn);


        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uLike.setText("I am glad to hear that you liked first page :),if you want to change your decision, click 'ASK AGAIN'");
                doYouLikeDialog.dismiss();
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uLike.setText("Sorry, I will try to be more creative day-by-day,if you want to change your decision, click 'ASK AGAIN'");
                doYouLikeDialog.dismiss();
            }
        });
    }
}