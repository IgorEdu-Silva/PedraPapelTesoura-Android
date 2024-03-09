package com.example.pedrapapeltesoura;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import java.util.Random;

/** @noinspection ALL*/
public class MainActivity extends AppCompatActivity {
    ImageButton buttonRock, buttonPaper, buttonScissors;
    Button buttonPlay;
    TextView placarUp, placarDown, playUser, playCPU;

    int playerScore = 0;
    int computerScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonRock = findViewById(R.id.buttonRock);
        buttonPaper = findViewById(R.id.buttonPaper);
        buttonScissors = findViewById(R.id.buttonScissors);
        buttonPlay = findViewById(R.id.buttonPlay);
        placarUp = findViewById(R.id.PlacarUp);
        placarDown = findViewById(R.id.PlacarDown);
        playUser = findViewById(R.id.playUser);
        playCPU = findViewById(R.id.playCPU);

        buttonPlay.setEnabled(false);

        buttonRock.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                resetButtonBackgrounds();
                buttonRock.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                playUser.setText("Pedra");
                buttonPlay.setEnabled(true);
            }
        });

        buttonPaper.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                resetButtonBackgrounds();
                buttonPaper.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                playUser.setText("Papel");
                buttonPlay.setEnabled(true);
            }
        });

        buttonScissors.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                resetButtonBackgrounds();
                buttonScissors.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                playUser.setText("Tesoura");
                buttonPlay.setEnabled(true);
            }
        });

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int computerChoice = new Random().nextInt(3);
                String[] choices = {"Pedra", "Papel", "Tesoura"};
                int playerChoice = getPlayerChoice();
                int result = getResult(playerChoice, computerChoice);
                updateScore(result);
                playCPU.setText(choices[computerChoice]);
            }
        });
    }

    private void resetButtonBackgrounds() {
        buttonRock.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        buttonPaper.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        buttonScissors.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }

    private int getPlayerChoice() {
        if (buttonRock.getBackground().getConstantState().equals(getResources().getDrawable(android.R.color.darker_gray).getConstantState())) {
            return 0;
        } else if (buttonPaper.getBackground().getConstantState().equals(getResources().getDrawable(android.R.color.darker_gray).getConstantState())) {
            return 1;
        } else if (buttonScissors.getBackground().getConstantState().equals(getResources().getDrawable(android.R.color.darker_gray).getConstantState())) {
            return 2;
        }
        return -1;
    }

    private int getResult(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        }

        if ((playerChoice + 1) % 3 == computerChoice) {
            return 1;
        } else {
            return 2;
        }
    }

    private void updateScore(int result) {
        if (result == 1) {
            playerScore++;
        } else if (result == 2) {
            computerScore++;
        }

        placarUp.setText(String.valueOf(playerScore));
        placarDown.setText(String.valueOf(computerScore));
    }
}
