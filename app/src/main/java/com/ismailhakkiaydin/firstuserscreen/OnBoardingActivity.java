package com.ismailhakkiaydin.firstuserscreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class OnBoardingActivity extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = sharedPreferences.getBoolean("firstStart", true);

        Log.e("anasas", "ana kısım");


        if (firstStart) {
            Log.e("dgsdfg", "if kısmı");

            firstUserScreen();
        }

    }

    private void firstUserScreen() {

        Log.e("sgsd", "fonksiyon kısmı");

        addFragment(new Step.Builder().setTitle("This is header 1")
                .setContent("This is content 1")
                .setBackgroundColor(Color.parseColor("#FF0957")) // int background color
                .setDrawable(R.drawable.ic_launcher_background) // int top drawable
                .setSummary("This is summary 1")
                .build());

        addFragment(new Step.Builder().setTitle("This is header 2")
                .setContent("This is content 2")
                .setBackgroundColor(Color.parseColor("#FF0957")) // int background color
                .setDrawable(R.drawable.ic_launcher_background) // int top drawable
                .setSummary("This is summary 2")
                .build());

        addFragment(new Step.Builder().setTitle("This is header 3")
                .setContent("This is content 3")
                .setBackgroundColor(Color.parseColor("#FF0957")) // int background color
                .setDrawable(R.drawable.ic_launcher_background) // int top drawable
                .setSummary("This is summary 3")
                .build());

        setPrevText("Geri");
        setNextText("İleri");
        setCancelText("Tanıtımı Geç");
        setFinishText("Başla");

        SharedPreferences sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("firstStart", false);
        editor.commit();


    }

    @Override
    public void finishTutorial() {
        Intent intent = new Intent(OnBoardingActivity.this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void currentFragmentPosition(int position) {

    }
}
