package com.example.lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button division;
    private EditText firstVal;
    private EditText secondVal;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        //select attributes
        firstVal = findViewById(R.id.FirstNumVal);
        secondVal = findViewById(R.id.SecondNumVal);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        answer = findViewById(R.id.Result);
        String formatted = getString(R.string.result, 0.00);
        answer.setText(formatted);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstText = firstVal.getText().toString();
                String secondText = secondVal.getText().toString();

                if (firstText.isEmpty() || secondText.isEmpty()) {
                    // Handle the case where either min or max is empty
                    answer.setText("Please enter both first and second values.");
                    return;
                }

                try {
                    double firstValue = Double.parseDouble(firstText);
                    double secondValue = Double.parseDouble(secondText);

                    Double temp = calculator(firstValue, secondValue, plus.getText().toString());
                    String solution = getString(R.string.result, temp);
                    answer.setText(solution);
                } catch (NumberFormatException e) {
                    // Handle the case where input is not a valid integer
                    answer.setText("Please enter valid integer values for first and second.");
                }
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstText = firstVal.getText().toString();
                String secondText = secondVal.getText().toString();

                if (firstText.isEmpty() || secondText.isEmpty()) {
                    // Handle the case where either min or max is empty
                    answer.setText("Please enter both first and second values.");
                    return;
                }

                try {
                    double firstValue = Double.parseDouble(firstText);
                    double secondValue = Double.parseDouble(secondText);

                    Double temp = calculator(firstValue, secondValue, minus.getText().toString());
                    String solution = getString(R.string.result, temp);
                    answer.setText(solution);
                } catch (NumberFormatException e) {
                    // Handle the case where input is not a valid integer
                    answer.setText("Please enter valid integer values for first and second.");
                }
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstText = firstVal.getText().toString();
                String secondText = secondVal.getText().toString();

                if (firstText.isEmpty() || secondText.isEmpty()) {
                    // Handle the case where either min or max is empty
                    answer.setText("Please enter both first and second values.");
                    return;
                }

                try {
                    double firstValue = Double.parseDouble(firstText);
                    double secondValue = Double.parseDouble(secondText);

                    Double temp = calculator(firstValue, secondValue, multiply.getText().toString());
                    String solution = getString(R.string.result, temp);
                    answer.setText(solution);
                } catch (NumberFormatException e) {
                    // Handle the case where input is not a valid integer
                    answer.setText("Please enter valid integer values for first and second.");
                }
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstText = firstVal.getText().toString();
                String secondText = secondVal.getText().toString();

                if (firstText.isEmpty() || secondText.isEmpty()) {
                    // Handle the case where either min or max is empty
                    answer.setText("Please enter both first and second values.");
                    return;
                }

                try {
                    double firstValue = Double.parseDouble(firstText);
                    double secondValue = Double.parseDouble(secondText);
                    Double temp = calculator(firstValue, secondValue, division.getText().toString());
                    if (temp.isInfinite()) {
                        temp = 0.00;
                        Toast.makeText(Calculator.this, "Can't divide by zero", Toast.LENGTH_LONG).show();
                    }
                    String solution = getString(R.string.result, temp);
                    answer.setText(solution);
                } catch (NumberFormatException e) {
                    // Handle the case where input is not a valid integer
                    answer.setText("Please enter valid integer values for first and second.");
                }
            }
        });
    }

    public double calculator(double a, double b, String operator) {
        switch (operator) {
            case "CỘNG": {
                return a + b;
            }
            case "TRỪ": {
                return a - b;
            }
            case "NHÂN": {
                return a * b;
            }
            case "CHIA": {
                return a / b;
            }
            default: {
                return 0;
            }
        }
    }
}