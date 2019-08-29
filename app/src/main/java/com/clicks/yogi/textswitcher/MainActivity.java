package com.clicks.yogi.textswitcher;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private TextSwitcher textSwitcher;
    String[] strings = {"Text 1", "Text 2", "Text 3", "Text 4", "Text 5"};
    int count = strings.length;
    int Indexvalue = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = findViewById(R.id.btnNext);
        textSwitcher = findViewById(R.id.txt);

        // Method name...
        setMyFactory();

        // Declare in and out animations...
        Animation in = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);

        Animation out = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        // set the animation type to TextSwitcher
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);

        //text appear on start
        textSwitcher.setCurrentText("TextSwitch");


        btnNext.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Indexvalue++;
                // If index reaches maximum then reset it
                if (Indexvalue == count)
                    Indexvalue = 0;
                textSwitcher.setText(strings[Indexvalue]);
            }
        });

    }

    private void setMyFactory() {

/*
    // Set the ViewFactory of the TextSwitcher
        to create TextView object...
*/
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory(){

            public View makeView() {

                TextView t1 = new TextView(MainActivity.this);
                t1.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                t1.setTextSize(30);
                return t1;
            }
        });
    }
}