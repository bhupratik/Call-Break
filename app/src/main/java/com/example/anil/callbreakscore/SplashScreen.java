package com.example.anil.callbreakscore;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;

/**
 *
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),mainactivity2.class);
                startActivity(intent);
                finish();
            }
        },3000);
//        final Thread timerThread = new Thread(){
//            public void run(){
//                try{
//                    sleep(3000);
//                }catch(InterruptedException e){
//                    e.printStackTrace();
//                }finally{
//                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//        };
//        timerThread.start();
    }

//    @Override
//    protected void onPause() {
//        // TODO Auto-generated method stub
//        super.onPause();
//        //finish();
//    }

}