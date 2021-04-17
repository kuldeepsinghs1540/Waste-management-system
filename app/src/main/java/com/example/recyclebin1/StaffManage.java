package com.example.recyclebin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class StaffManage extends AppCompatActivity implements View.OnClickListener {

    private ImageButton Addstaff, DeleteStaff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_manage);

        Addstaff = (ImageButton) findViewById(R.id.Addstaff);
        Addstaff.setOnClickListener(this);

        DeleteStaff = (ImageButton) findViewById(R.id.DeleteStaff);
        DeleteStaff.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Addstaff:
                startActivity(new Intent(StaffManage.this, AddStaff.class));
                break;
            case R.id.DeleteStaff:
                startActivity(new Intent(StaffManage.this, Deletestaff.class));
        }
    }
}