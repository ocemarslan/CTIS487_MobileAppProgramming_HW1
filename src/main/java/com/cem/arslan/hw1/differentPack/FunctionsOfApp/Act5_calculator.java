package com.cem.arslan.hw1.differentPack.FunctionsOfApp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cem.arslan.hw1.R;

public class Act5_calculator extends AppCompatActivity {

    EditText num1, num2;
    Button sumBtn, subsBtn, mulBtn, divBtn;
    int result, n1, n2;
    String strResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Notification and Status Bars
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_act5_calculator);

        /**********************************************************************/

       //initialize variables
        sumBtn = findViewById(R.id.btnSum);
        subsBtn = findViewById(R.id.btnSubtract);
        divBtn = findViewById(R.id.btnDiv);
        mulBtn = findViewById(R.id.btnMul);

    }

    public void onClick(View view) {
        num1 = findViewById(R.id.etNum1);


        num2 = findViewById(R.id.etNum2);



        if(num1.getText().toString().length()==0||num2.getText().toString().length()==0){
            Toast.makeText(this,R.string.pleaseFillNum1Num2,Toast.LENGTH_LONG).show();
        }else{
            n1 = Integer.parseInt(num1.getText().toString());
            n2 = Integer.parseInt(num2.getText().toString());
            int doneToastMsg=R.string.notSetToastCalculator;
            if (view.getId() == sumBtn.getId()) {
                result = n1 + n2;
                strResult = Integer.toString(n1) + "+" + Integer.toString(n2) + "=" + Integer.toString(result);
                doneToastMsg = R.string.sumDoneMsg;

            } else if (view.getId() == subsBtn.getId()) {
                result = n1 - n2;
                strResult = Integer.toString(n1) + "-" + Integer.toString(n2) + "=" + Integer.toString(result);
                doneToastMsg = R.string.subtraDoneMsg;

            } else if (view.getId() == divBtn.getId()) {
                if (n2 == 0) {
                    doneToastMsg=R.string.CANOTbeZeroToast;
                    strResult="Denominator CANNOT be zero!";
                } else {
                    result = n1 / n2;
                    strResult = Integer.toString(n1) + "/" + Integer.toString(n2) + "=" + Integer.toString(result);
                    doneToastMsg = R.string.divDoneMsg;
                }

            } else {
                result = n1 * n2;
                strResult = Integer.toString(n1) + "*" + Integer.toString(n2) + "=" + Integer.toString(result);
                doneToastMsg = R.string.mulDoneMsg;
            }
            displayAlertDialog(strResult, doneToastMsg);
        }


    }

    public void displayAlertDialog(String strResult,int doneToastMsg){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(R.string.result);
        alertDialogBuilder.setMessage(strResult);
        alertDialogBuilder.setIcon(R.drawable.ic_launcher_foreground);


        alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Act5_calculator.this,  doneToastMsg,Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.show();
    }
}