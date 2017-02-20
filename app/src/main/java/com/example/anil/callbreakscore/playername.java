package com.example.anil.callbreakscore;



import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class playername  extends AppCompatActivity {
    mainactivity2 ma2 = new mainactivity2();
    private EditText e[] = new EditText[6];

    private TextInputLayout t[]=new TextInputLayout[5];
    private Button button2=null;
    private RadioGroup radioGroup=null;
    private RadioButton radiobuttonround=null;
    private RadioButton radiobuttonscore=null;
    int id =0,choice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playername);

        t[0] = (TextInputLayout) findViewById(R.id.player1);
        t[1] = (TextInputLayout) findViewById(R.id.player2);
        t[2] = (TextInputLayout) findViewById(R.id.player3);
        t[3] = (TextInputLayout) findViewById(R.id.player4);
        t[4] = (TextInputLayout) findViewById(R.id.roundedit);

        e[0] = (EditText) findViewById(R.id.player_1);
        e[0].addTextChangedListener(new MyTextWatcher(e[0]));

        e[1] = (EditText) findViewById(R.id.player_2);
        e[1].addTextChangedListener(new MyTextWatcher(e[1]));

        e[2] = (EditText) findViewById(R.id.player_3);
        e[2].addTextChangedListener(new MyTextWatcher(e[2]));

        e[3] = (EditText) findViewById(R.id.player_4);

        e[4] = (EditText) findViewById(R.id.rounds);

        if(ma2.pid==4){
            e[3].setVisibility(View.VISIBLE);
            e[3] = (EditText) findViewById(R.id.player_4);
            e[3].addTextChangedListener(new MyTextWatcher(e[3]));
        }
        else{
            t[3].setVisibility(View.INVISIBLE);
        }

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup2);
        radiobuttonround=(RadioButton)findViewById(R.id.round);
        radiobuttonscore=(RadioButton)findViewById(R.id.score);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                e[4].setVisibility(View.VISIBLE);
                if (checkedId == R.id.round) {
                    choice=1;
                    e[4].addTextChangedListener(new MyTextWatcher(e[4]));
                } else if (checkedId == R.id.score) {
                    choice=2;
                    e[4].addTextChangedListener(new MyTextWatcher(e[4]));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please Select Game Mode...",Toast.LENGTH_SHORT).show();
                }

            }
        });

        button2=(Button)findViewById(R.id.btn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();
            }
        });
    }

    /**
     * Validating form
     */

    private void submitForm() {

        if(ma2.pid==4) {
            if (!validateNameP1()) {
                return;
            }
            if (!validateNameP2()) {
                return;
            }
            if (!validateNameP3()) {
                return;
            }
            if (!validateNameP4()) {
                return;
            }
            if(radiobuttonscore.isChecked()==false && radiobuttonround.isChecked()==false){
                //todo jjnjnhk,njk
                Toast.makeText(getApplicationContext(), "Please", Toast.LENGTH_SHORT).show();
            }
            if(!validateRounds()){
                return;
            }

        }
        else{
            if (!validateNameP1()) {
                return;
            }
            if (!validateNameP2()) {
                return;
            }
            if (!validateNameP3()) {
                return;
            }
            if(!validateRounds()){
                return;
            }


            Toast.makeText(getApplicationContext(), "Thank You!", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validateNameP1() {
        if (e[0].getText().toString().trim().isEmpty()) {
            t[0].setError(getString(R.string.err_msg_nameP1));
            requestFocus(e[0]);
            return false;
        } else {
            t[0].setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateNameP2() {
        if (e[1].getText().toString().trim().isEmpty()) {
            t[1].setError(getString(R.string.err_msg_nameP2));
            requestFocus(e[1]);
            return false;
        } else {
            t[1].setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateNameP3() {
        if (e[2].getText().toString().trim().isEmpty()) {
            t[2].setError(getString(R.string.err_msg_nameP3));
            requestFocus(e[2]);
            return false;
        } else {
            t[2].setErrorEnabled(false);
        }

        return true;
    }


    private boolean validateNameP4() {
        if (e[3].getText().toString().trim().isEmpty()) {
            t[3].setError(getString(R.string.err_msg_nameP4));
            requestFocus(e[3]);
            return false;
        } else {
            t[3].setErrorEnabled(false);
        }

        return true;
    }

    private boolean validateRounds() {
        if (choice ==1) {
            if (e[4].getText().toString().trim().isEmpty()) {
                t[4].setError(getString(R.string.err_msg_round));
                requestFocus(e[4]);
                return false;
            } else {
                t[4].setErrorEnabled(false);
            }
            return true;
        }
        else
        {
            if (e[4].getText().toString().trim().isEmpty()) {
                t[4].setError(getString(R.string.erro_msg_score));
                requestFocus(e[4]);
                return false;
            } else {
                t[4].setErrorEnabled(false);
            }
            return true;
        }
    }
    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class MyTextWatcher implements TextWatcher{
        private  View view;
        private MyTextWatcher(View v){
            this.view = v;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()){
                case R.id.player1 :
                    validateNameP1();
                    break;
                case R.id.player2 :
                    validateNameP2();
                    break;
                case R.id.player3 :
                    validateNameP3();
                    break;
                case R.id.player4 :
                    validateNameP4();
                    break;
                case R.id.rounds:
                    validateRounds();
                    break;
            }
        }
    }
}
