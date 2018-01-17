package com.example.android.speedwayscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final String current_home_score = "home_score";
    static final String current_guest_score = "guest_score";

    int scoreHome;
    int scoreGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore both scores from saved state
            scoreHome = savedInstanceState.getInt(current_home_score);
            scoreGuest = savedInstanceState.getInt(current_guest_score);
        }
    }

    // Displays the given score for home
    public void displayForHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.home_score);
        scoreView.setText(String.valueOf(score))
        ;
    }


    // Next three methods add 3,2 or 1 point to home score
    public void add3ToH(View v) {
        scoreHome = scoreHome + 3;
        displayForHome(scoreHome);

    }

    public void add2ToH(View v) {
        scoreHome = scoreHome + 2;
        displayForHome(scoreHome);

    }

    public void add1ToH(View v) {
        scoreHome = scoreHome + 1;
        displayForHome(scoreHome);

    }


    // Displays the given score for guest
    public void displayForGuest(int score) {
        TextView scoreView = (TextView) findViewById(R.id.guest_score);
        scoreView.setText(String.valueOf(score))
        ;
    }


    // Next three methods add 3,2 or 1 point to guest score
    public void add3ToG(View v) {
        scoreGuest = scoreGuest + 3;
        displayForGuest(scoreGuest);

    }

    public void add2ToG(View v) {
        scoreGuest = scoreGuest + 2;
        displayForGuest(scoreGuest);

    }

    public void add1ToG(View v) {
        scoreGuest = scoreGuest + 1;
        displayForGuest(scoreGuest);

    }


    // Reset both scores
    public void reset(View v) {
        scoreHome = 0;
        scoreGuest = 0;
        displayForHome(scoreHome);
        displayForGuest(scoreGuest);
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        // Save current game state
        savedInstanceState.putInt(current_home_score, scoreHome);
        savedInstanceState.putInt(current_guest_score, scoreGuest);

        super.onSaveInstanceState(savedInstanceState);
    }


    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore the game state from saved instance
        scoreHome = savedInstanceState.getInt(current_home_score);
        scoreGuest = savedInstanceState.getInt(current_guest_score);
        displayForHome(scoreHome);
        displayForGuest(scoreGuest);
    }
}


