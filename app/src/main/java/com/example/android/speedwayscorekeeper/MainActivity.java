package com.example.android.speedwayscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String CURRENT_HOME_SCORE = "home_score";
    private static final String CURRENT_GUEST_SCORE = "guest_score";

    private int scoreHome, scoreGuest;
    private TextView homeScoreView, guestScoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        homeScoreView = findViewById(R.id.home_score);
        guestScoreView = findViewById(R.id.guest_score);

        // Check whether we're recreating a previously destroyed instance
        if (savedInstanceState != null) {
            // Restore both scores from saved state
            scoreHome = savedInstanceState.getInt(CURRENT_HOME_SCORE);
            scoreGuest = savedInstanceState.getInt(CURRENT_GUEST_SCORE);
        }
    }

    // Display the given score for home
    public void displayForHome(int score) {
        homeScoreView.setText(String.valueOf(score));
    }

    // Next three methods add 3, 2 or 1 point to home score
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

    // Display the given score for guest
    public void displayForGuest(int score) {
        guestScoreView.setText(String.valueOf(score));
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
        super.onSaveInstanceState(savedInstanceState);

        // Save current game state
        savedInstanceState.putInt(CURRENT_HOME_SCORE, scoreHome);
        savedInstanceState.putInt(CURRENT_GUEST_SCORE, scoreGuest);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // Restore the game state from saved instance
        scoreHome = savedInstanceState.getInt(CURRENT_HOME_SCORE);
        scoreGuest = savedInstanceState.getInt(CURRENT_GUEST_SCORE);
        displayForHome(scoreHome);
        displayForGuest(scoreGuest);
    }
}