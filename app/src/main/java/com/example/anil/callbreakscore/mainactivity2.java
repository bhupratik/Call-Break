package com.example.anil.callbreakscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



public class mainactivity2 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private Button button;
    private RadioButton pradio;
    public static int pid=0;
 //   Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainactivity2);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i){
                switch (i){
                    case R.id.radioButton5:
                        pid=3;
                        Toast.makeText(mainactivity2.this,pid + "", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), playername.class);
                        startActivity(intent);

                        break;
                    case R.id.radioButton6:
                        pid=4;
                        Toast.makeText(mainactivity2.this,pid + "", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getApplicationContext(), playername.class);
                        startActivity(intent2);
                        break;

                }
            }
        });



    }


}
