package com.devwuk.todaylotto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView no1,no2,no3,no4,no5,no6,msg;
    int Lotto[] = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        no1 = (TextView)findViewById(R.id.no1);
        no2 = (TextView)findViewById(R.id.no2);
        no3 = (TextView)findViewById(R.id.no3);
        no4 = (TextView)findViewById(R.id.no4);
        no5 = (TextView)findViewById(R.id.no5);
        no6 = (TextView)findViewById(R.id.no6);
        Button go = (Button)findViewById(R.id.make);
        msg = (TextView)findViewById(R.id.tv_content);



        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeNumber();
            }
        });
    }

    public void makeNumber(){

        for (int i = 0; i<6; i++){
            Lotto[i] = (int)(Math.random()*45)+1;

            for(int j=0; j<i; j++){

                if(Lotto[i] ==Lotto[j]){

                    i--;

                    break;

                }

            }

        }
        Animation startAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.ani);
        msg.startAnimation(startAnimation);
        Arrays.sort(Lotto);
        startAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                msg.setText("제비가 박씨를 물어왔다...");
                Arrays.sort(Lotto);

                no1.setText("");
                no2.setText("");
                no3.setText("");
                no4.setText("");
                no5.setText("");
                no6.setText("");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                msg.setText("박씨에서 나온 번호는...");


                no1.setText(Lotto[0]+"");
                no2.setText(Lotto[1]+"");
                no3.setText(Lotto[2]+"");
                no4.setText(Lotto[3]+"");
                no5.setText(Lotto[4]+"");
                no6.setText(Lotto[5]+"");
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
}
