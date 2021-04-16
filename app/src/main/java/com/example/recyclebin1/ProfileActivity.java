package com.example.recyclebin1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button searchbin,Myalert,FileComplain,ManageProfile;
    private FirebaseUser user;
    private DatabaseReference reference;

    private String userID;
    private Button signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        userID = user.getUid();

        final TextView fullNameTextView = (TextView) findViewById(R.id.Full);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null) {
                    String fullnam = userProfile.fullName;

                    fullNameTextView.setText(fullnam);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfileActivity.this, "Something wrong happened! ", Toast.LENGTH_LONG).show();
            }
        });
        signOut = (Button) findViewById(R.id.signOut);
        signOut.setOnClickListener(this);

        searchbin = (Button) findViewById(R.id.searchbin);
        searchbin.setOnClickListener(this);

        ManageProfile = (Button) findViewById(R.id.ManageProfile);
        ManageProfile.setOnClickListener(this);

        Myalert = (Button) findViewById(R.id.Myalert);
        Myalert.setOnClickListener(this);

        FileComplain = (Button) findViewById(R.id.FileComplain);
        FileComplain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signOut:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(ProfileActivity.this, MainActivity.class));
                break;
            case R.id.searchbin:
                startActivity(new Intent(ProfileActivity.this,SearchBin.class));
                break;
            case R.id.ManageProfile:
                startActivity(new Intent(ProfileActivity.this,ManageProfile.class));
                break;
            case R.id.Myalert:
                startActivity(new Intent(ProfileActivity.this,MyAlert.class));
                break;
            case R.id.FileComplain:
                startActivity(new Intent(ProfileActivity.this,Complaint.class));

        }
    }
}