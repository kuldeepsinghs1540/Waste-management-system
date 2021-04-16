package com.example.recyclebin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AdminVerify extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextPassword;
    private Button signIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_verify);

        editTextPassword = (EditText) findViewById(R.id.password);

        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String passwordcheck = "MCATEAM11";
        String password = editTextPassword.getText().toString().trim();

        if(password.isEmpty()){
            editTextPassword.setError("Password is required!");
            editTextPassword.requestFocus();
            return;
        }
        if(!password.matches(passwordcheck)){
            editTextPassword.setError("password is not correct!");
            editTextPassword.requestFocus();
            return;
        }
        if(password.matches(passwordcheck)) {
            startActivity(new Intent(AdminVerify.this, AdminPage.class));
        }
    }
}