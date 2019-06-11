package com.example.shp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.google.firebase.database.core.Context;

public class AppIntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_app_intro);

        addSlide(AppIntroFragment.newInstance("About Health Care",
                "Fullestop specializes in developing Online Doctor Appointment Solutions for doctors, hospitals and nursing homes.",
                R.drawable.s_doctor,
                ContextCompat.getColor(getApplicationContext(),R.color.green)));

        addSlide(AppIntroFragment.newInstance("Messaging",
                "People can send message regarding with issues.",
                R.drawable.s_message,
                ContextCompat.getColor(getApplicationContext(),R.color.maroon)));

        addSlide(AppIntroFragment.newInstance("Received Solution",
                "We combine our technical skills and innovative ideas to deliver a solution which meets your requirements in best possible way.",
                R.drawable.r_message,
                ContextCompat.getColor(getApplicationContext(),R.color.inverted)));

        addSlide(AppIntroFragment.newInstance("24 X 7 Service",
                "Our highly experienced team of developers understands your requirements well, and delivers a solution which is up-to-the-mark.",
                R.drawable.s_chat,
                ContextCompat.getColor(getApplicationContext(),R.color.darkblue)));

        addSlide(AppIntroFragment.newInstance("Take Appointment",
                "They give patients the flexibility to book their appointment with the doctor in their neighborhood.",
                R.drawable.s_appointment,
                ContextCompat.getColor(getApplicationContext(),R.color.red)));
    }

    @Override
    public void onDonePressed(Fragment currentFragment){

        super.onDonePressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
