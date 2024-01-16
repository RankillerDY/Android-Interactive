package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Instagram extends AppCompatActivity implements View.OnClickListener {
    private TextView txtUsername, txtPassword, notAccountYet;
    private Button signInButton;
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram);
        //Get the attribute by there id
        txtUsername = findViewById(R.id.txtName);
        txtPassword = findViewById(R.id.txtPassword);
        signInButton = findViewById(R.id.SignInbutton);
        notAccountYet = findViewById(R.id.footer);

        //Register event
        notAccountYet.setOnClickListener(this);
        signInButton.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(txtUsername.getText().toString())) {
            txtUsername.setError(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(txtPassword.getText().toString())) {
            txtPassword.setError(REQUIRE);
            return false;
        }
        return true;
    }

    private void signIn() {
        //Invalid
        if (!checkInput()) {
            return;
        }

        //Start MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signUp() {
        //Start MainActivity
        Intent intent = new Intent(this, InstagramSignUpActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();// Sign In action
        if (id == R.id.SignInbutton) {
            signIn();
        } else if (id == R.id.footer) {
            signUp();
        }
    }
}