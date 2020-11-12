package com.cem.arslan.hw1.StartingActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.cem.arslan.hw1.R;


//osman cem arlan ctis 487 hw1 main act
public class MainActivity extends AppCompatActivity {

    SeekBar seekBarunlockVolume;
    TextView tvUnlockPerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide Notification and Status Bars
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        tvUnlockPerc=findViewById(R.id.tvPercUnlock);
        seekBarunlockVolume=findViewById(R.id.seekBarUnlock);

        seekBarunlockVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvUnlockPerc.setText("Don't Stop Touching!\nLoading..."+"%"+progress);
                if(progress==100)
                {
                    Intent intent = new Intent(MainActivity.this,Activity2.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBar.setProgress(0);
            }
        });


        //close the all app up to an intent from last activity
        if(getIntent().getBooleanExtra("EXIT",false))
        {
            finish();
        }
    }
}