package com.example.tinpattiofflineaccountant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {
    Intent intent;
    String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intent = getIntent();
        user=intent.getStringExtra("user");
    }

    public void taskClicked(View view) {
        Intent task=new Intent(this,Tasks.class);
        task.putExtra("user",user);
        startActivity(task);
    }

    public void expClicked(View view) {
        Intent exp=new Intent(this,Accountant.class);
        exp.putExtra("user",user);
        startActivity(exp);
    }
}
