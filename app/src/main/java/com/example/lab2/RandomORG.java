package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class RandomORG extends AppCompatActivity {
    private Button generateButton;
    private EditText minVal;
    private EditText maxVal;
    private TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomorg);

        //get attributes
        generateButton = findViewById(R.id.button);
        minVal = findViewById(R.id.MinNumberDecimal);
        maxVal = findViewById(R.id.MaxNumberDecimal);
        answer = findViewById(R.id.AnswerBar);


        //On click generate function
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String minText = minVal.getText().toString();
                String maxText = maxVal.getText().toString();

                if (minText.isEmpty() || maxText.isEmpty()) {
                    // Handle the case where either min or max is empty
                    answer.setText("Please enter both min and max values.");
                    return;
                }

                try {
                    int minValue = Integer.parseInt(minText);
                    int maxValue = Integer.parseInt(maxText);
                    if(maxValue < minValue) {
                        answer.setText("Max value can't be smaller than min value.");
                        throw new NumberFormatException("max value can't be smaller than min value");
                    } else {
                        int temp = randomGenerator(minValue, maxValue);
                        answer.setText(String.valueOf(temp));
                    }
                } catch (NumberFormatException e) {
                    // Handle the case where input is not a valid integer
                    answer.setText("Please enter valid integer values for min and max.");
                }

            }
        });
    }

    public Integer randomGenerator(int a, int b) {
        Random random = new Random();
        return random.nextInt(b - a + 1) + a;
    }
}