package com.cem.arslan.hw1.differentPack.FunctionsOfApp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.cem.arslan.hw1.R;

public class Act4AboutCtis extends AppCompatActivity {

    Spinner spinnerInstructors, spinnerAssisstants;
    boolean firstItemDefaultAsSelected = true,fd=true;
    TextView tvName;
    ImageView teachPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Notification and Status Bars
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_act4_about_ctis);

        /*****************************************************************/
        spinnerInstructors = findViewById(R.id.instructorSpinner);
        spinnerAssisstants = findViewById(R.id.assistantSpinner);
        tvName =findViewById(R.id.tvNameTeacher);
        teachPic=findViewById(R.id.teacherPicturesIV);
        //teachPic.setVisibility(View.INVISIBLE);

        spinnerInstructors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (firstItemDefaultAsSelected) {
                    firstItemDefaultAsSelected = false;
                } else {
                    String teacherName=spinnerInstructors.getSelectedItem().toString();
                    String withProfTeacherName= "Inst. "+teacherName;
                    if(teacherName.equalsIgnoreCase("Erkan UÇAR"))
                    {
                        tvName.setText(withProfTeacherName);
                        teachPic.setImageResource(R.drawable.er);
                    }else if(teacherName.equalsIgnoreCase("Neşe şahin özçelik")){
                        tvName.setText(withProfTeacherName);
                        teachPic.setImageResource(R.drawable.nese);
                    }else if(teacherName.equalsIgnoreCase("Serpil TIN")){
                        tvName.setText(withProfTeacherName);
                        teachPic.setImageResource(R.drawable.serpil);
                    }else{
                        tvName.setText(R.string.ns);
                        teachPic.setImageResource(R.drawable.wp);
                    }

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerAssisstants.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (fd) {
                    fd= false;
                } else {
                    String teacherName=spinnerAssisstants.getSelectedItem().toString();
                    String withProfTeacherName= "Asst. "+teacherName;

                    if(teacherName.equalsIgnoreCase("leyla sezer"))
                    {
                        tvName.setText(withProfTeacherName);
                        teachPic.setImageResource(R.drawable.leyla);
                    }else if(teacherName.equalsIgnoreCase("burcu alper")){
                        tvName.setText(withProfTeacherName);
                        teachPic.setImageResource(R.drawable.burcu);
                    }else if (teacherName.equalsIgnoreCase("Hatice Zehra YILMAZ")){
                        tvName.setText(withProfTeacherName);
                        teachPic.setImageResource(R.drawable.hatice);
                    }else{
                        tvName.setText(R.string.ns);
                        teachPic.setImageResource(R.drawable.wp);
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    /*public void setTeacherPicture(String name) {

        //ImageView tmp = findViewById(R.id.imgDene);


        if (name.equalsIgnoreCase("Erkan"))
            tmp.setImageResource(R.drawable.erkan);
        else
            tmp.setImageResource(R.drawable.beyhan);
    } */



}