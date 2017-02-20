package com.example.anil.callbreakscore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class HandTaken extends AppCompatActivity {
    String name="Test";
    int score=0;
    int hand=0;

    static HandTaken player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        player=this;


        Toast.makeText(HandTaken.this,name, Toast.LENGTH_SHORT).show();
    }

    public static HandTaken getInstance(){
        return player;
    }



}
