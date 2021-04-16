package com.example.recyclebin1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView register ,forgotPassword;
    private EditText editTextEmail,editTextPassword;
    private Button signIn,USERNITC,Staff,Admin;

    private FirebaseAuth mAuth;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        USERNITC = (Button)findViewById(R.id.USERNITC);
        USERNITC.setOnClickListener(this);

        Staff = (Button) findViewById(R.id.Staff);
        Staff.setOnClickListener(this);

        Admin = (Button) findViewById(R.id.Admin);
        Admin.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.USERNITC:
                startActivity(new Intent(this,UserPage.class));
                break;
            case R.id.Staff:
                startActivity(new Intent(this,StaffPage.class));
                break;
            case R.id.Admin:
                startActivity(new Intent(this,AdminVerify.class));
                break;
        }
    }
}