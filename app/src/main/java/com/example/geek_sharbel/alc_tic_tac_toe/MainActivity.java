package com.example.geek_sharbel.alc_tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Three(View view) {
        Intent intent = new Intent(this, ThreeByThreeActivity.class);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }


    public void four(View view) {
        Intent intent = new Intent(this, FourByFourActivity.class);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void five(View view) {
        Intent intent = new Intent(this, FiveByFiveActivity.class);
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

}
