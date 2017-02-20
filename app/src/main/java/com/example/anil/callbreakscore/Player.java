package com.example.anil.callbreakscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Player extends AppCompatActivity {
    String name="Test";
    int score=0;
    int hand=0;

    static Player player;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        player=this;


        Toast.makeText(Player.this,name, Toast.LENGTH_SHORT).show();
    }

    public static Player getInstance(){
        return player;
    }



}
