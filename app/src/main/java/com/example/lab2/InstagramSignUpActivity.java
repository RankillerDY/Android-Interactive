package com.example.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InstagramSignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txtUsername, txtPassword, txtConfirmPassword, haveAccount;
    private Button signUpButton;
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_signup);

        txtUsername = findViewById(R.id.txtNameSignUp);
        txtPassword = findViewById(R.id.txtPasswordSignUp);
        txtConfirmPassword = findViewById(R.id.txtConfirmPassWord);
        haveAccount = findViewById(R.id.footerSignUp);
        signUpButton = findViewById(R.id.SignUpButton);

        //Register event
        haveAccount.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
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
        if (TextUtils.isEmpty(txtConfirmPassword.getText().toString())) {
            txtConfirmPassword.setError(REQUIRE);
            return false;
        }
        if (!TextUtils.equals(txtPassword.getText().toString(),
                txtConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).show();
            return false;
        }
        // Valid
        return true;
    }

    private void signUp() {
        // Invalid
        if (!checkInput()) {
            return;
        }
    }

    private void signInForm() {
        Intent intent = new Intent(this, Instagram.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.SignUpButton) {
            signUp();
        } else if (id == R.id.footerSignUp) {
            signInForm();
        }
    }
}