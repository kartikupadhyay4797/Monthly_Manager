package com.example.tinpattiofflineaccountant;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.system.Os;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import static android.app.PendingIntent.getActivity;
import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.ACTION_SENDTO;
import static android.graphics.Color.BLUE;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;
import java.io.IOException;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    public void submitted(View v) throws NullPointerException, NumberFormatException, IOException {
        String username,pass;
        EditText user=(EditText)findViewById(R.id.username);
        username=user.getText().toString();
        EditText password=(EditText)findViewById(R.id.pass);
        pass = password.getText().toString();
        if((username.equals("")) || (pass.equals(""))) {
            Toast toast = Toast.makeText(getApplicationContext(), "Expenditure and Details must be filled with appropriate data.", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
                if (username.equals("kartik") && pass.equals("123")) {
                    Intent intent = new Intent(this, Login.class);
                    intent.putExtra("user", username);
                    startActivity(intent);
                    Toast toast = Toast.makeText(getApplicationContext(), "user logged in successfully!!!", Toast.LENGTH_SHORT);
                    toast.show();
                }
        }
    }
}