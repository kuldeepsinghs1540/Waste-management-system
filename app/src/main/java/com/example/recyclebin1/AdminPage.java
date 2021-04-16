package com.example.recyclebin1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AdminPage extends AppCompatActivity implements View.OnClickListener {

    private Button userlist,complaint,dustbin,staff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);

        userlist=(Button) findViewById(R.id.userlist);
        userlist.setOnClickListener(this);

        staff=(Button) findViewById(R.id.staff);
        staff.setOnClickListener(this);

        dustbin=(Button) findViewById(R.id.dustbin);
        dustbin.setOnClickListener(this);

        complaint=(Button) findViewById(R.id.complaint);
        complaint.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.userlist:
                startActivity(new Intent(AdminPage.this,UserManage.class));
                break;
            case R.id.staff:
                startActivity(new Intent(AdminPage.this,StaffManage.class));
                break;
            case R.id.dustbin:
                startActivity(new Intent(AdminPage.this,dustbinManage.class));
                break;
            case R.id.complaint:
                startActivity(new Intent(AdminPage.this,ComplainManage.class));
                break;
        }
    }
}