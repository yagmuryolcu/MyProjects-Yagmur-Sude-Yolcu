package com.yagmursude.myapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YagmurSudeYolcu extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_activity);


        Button getStartedButton = findViewById(R.id.startButton);
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get Started düğmesine tıklanınca MainActivity'ye geçiş yap
                Intent intent = new Intent(YagmurSudeYolcu.this, MainActivity.class);
                startActivity(intent);
            }
        });    }


    }
