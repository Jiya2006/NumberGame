package com.jiya.numbergame;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int randomNumber;
    private int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtMessage = findViewById(R.id.txtMessage);
        TextView txtAttempts = findViewById(R.id.txtAttempts);
        EditText editGuess = findViewById(R.id.editGuess);

        Button btnCheck = findViewById(R.id.btnCheck);
        Button btnRestart = findViewById(R.id.btnRestart);

        randomNumber = (int)(Math.random() * 100) + 1;

        btnCheck.setOnClickListener(v -> {

            String input = editGuess.getText().toString();

            if(input.isEmpty()){
                txtMessage.setText("Enter a number first!");
                return;
            }

            int guess = Integer.parseInt(input);
            attempts++;

            txtAttempts.setText("Attempts: " + attempts);

            if(guess == randomNumber){

                txtMessage.setText("🎉 Correct! You guessed it in " + attempts + " attempts!");

                Toast.makeText(
                        MainActivity.this,
                        "Congratulations! 🎉",
                        Toast.LENGTH_SHORT
                ).show();
            }
            else if(guess > randomNumber){
                txtMessage.setText("📈 Too High!");
            }
            else{
                txtMessage.setText("📉 Too Low!");
            }
        });

        btnRestart.setOnClickListener(v -> {

            randomNumber = (int)(Math.random() * 100) + 1;
            attempts = 0;

            txtAttempts.setText("Attempts: 0");
            txtMessage.setText("Guess a number between 1 and 100");
            editGuess.setText("");
        });

    }
}