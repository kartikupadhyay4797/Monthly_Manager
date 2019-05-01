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
public class Tasks extends AppCompatActivity {
    ArrayList<MyObj> objlist;
    TaskArrayAdapter adapteer;
    ListView list;
    Intent intent;
    String user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        objlist = new ArrayList<MyObj>();
        adapteer = new TaskArrayAdapter(this, objlist);
        list = (ListView) findViewById(R.id.mylist);
        list.setAdapter(adapteer);
        intent=getIntent();
        user=intent.getStringExtra("user");
/*        try{
        filename= new Date().toString().substring(4,7)+new Date().toString().substring(24,28)+".txt";
        fw=new File(filename);
        fw.setReadable(true);
        fw.setWritable(true);

        int ch;

        // check if File exists or not
        FileReader fr=null;

            fr = new FileReader(filename);

            int temp=0;
            String det="",expendString="",dateString="";
            while ((ch=fr.read())!=-1){
                if((char)ch==','){
                    if(temp==2){
                        adapteer.add(new MyObj(Integer.parseInt(expendString),det,dateString));
                        temp=0;
                        det="";
                        expendString="";
                        dateString="";
                        continue;
                    }
                    else {
                        temp++;
                        continue;
                    }
                }
                if(temp==0)
                    expendString=expendString+(char)ch;
                if(temp==1)
                    det=det+(char)ch;
                if (temp==2)
                    dateString=dateString+(char)ch;
            }
            // close the file
            fr.close();

        }
        catch (FileNotFoundException fe)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "File not found!!!", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch (IOException e){
            Toast toast = Toast.makeText(getApplicationContext(), "IOException found!!!", Toast.LENGTH_SHORT);
            toast.show();
        }
*/
    }

    public void submitted(View v) throws NullPointerException, NumberFormatException, IOException {
/*
        fw=new File(filename);
        fw.setReadable(true);
        fw.setWritable(true);
*/
        int status=0;
        String deadlineString="",assignedUserString="";
        EditText deadline=(EditText)findViewById(R.id.date);
        deadlineString=deadline.getText().toString();
        EditText assignedUser=(EditText)findViewById(R.id.assignedUser);
        assignedUserString=assignedUser.getText().toString();
        EditText detail=(EditText)findViewById(R.id.detail);
        String det="";
        det = detail.getText().toString();
        if(det.equals("") || deadlineString.equals("") || assignedUserString.equals("")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Expenditure and Details must be filled with appropriate data.", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
/*            try {
                FileWriter fw = new FileWriter(filename);

                // read character wise from string and write
                // into FileWriter
                String str = expendString + ',' + det;
                for (int i = 0; i < str.length(); i++)
                    fw.write(str.charAt(i));
                fw.write(',');
                String date = new Date().toString().substring(0, 10) + new Date().toString().substring(29, 34);
                for (int i = 0; i < date.length(); i++)
                    fw.write(date.charAt(i));
                fw.write(',');
                //close the file
                fw.close();
*/
            String str;
            adapteer.add(new MyObj(status,det,deadlineString,assignedUserString));
                str = "Undone"+',' + det;
            String whatsAppMessage = str+","+deadlineString+","+assignedUserString;

            Intent sendIntent = new Intent();
            sendIntent.setAction(ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, whatsAppMessage);
            sendIntent.setType("text/plain");

            // Do not forget to add this to open whatsApp App specifically
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);

            Toast toast = Toast.makeText(getApplicationContext(), "1 item added successfully!!!", Toast.LENGTH_SHORT);
            toast.show();
/*            }
            catch (FileNotFoundException fe){
                Toast toast = Toast.makeText(getApplicationContext(), "File not found!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
            catch (IOException e){
                Toast toast = Toast.makeText(getApplicationContext(), "IOException found!!!", Toast.LENGTH_SHORT);
                toast.show();
            }
*/
        }
    }
    public void updateFile(View v) throws IOException {
        EditText fileData=(EditText)findViewById(R.id.fileData);
        String data=fileData.getText().toString();
/*
        fw=new File(filename);
        fw.setReadable(true);
        fw.setWritable(true);

        FileWriter fw=new FileWriter(filename);
        for (int i = 0; i < data.length(); i++)
                fw.write(data.charAt(i));
        fw.close();

        int ch;

        // check if File exists or not
        FileReader fr=null;
*/
        try
        {
            /*
            fr = new FileReader(filename);
            */
            // read from FileReader till the end of file
            int temp=0;
            String det="",expendString="",dateString="",userString="";
            for (int i=0;i<data.length();i++){
                if(data.charAt(i)==','){
                    temp++;
                    continue;
                }
                if(temp==0)
                    expendString=expendString+data.charAt(i);
                if(temp==1)
                    det=det+data.charAt(i);
                if (temp==2)
                    dateString=dateString+data.charAt(i);
                if (temp==3)
                    userString=userString+data.charAt(i);
            }
            adapteer.add(new MyObj(expendString,det,dateString,userString));
            // close the file
            // fr.close();


            Toast toast = Toast.makeText(getApplicationContext(), "Data updated successfully!!!", Toast.LENGTH_SHORT);
            toast.show();

        }
        catch (NullPointerException fe)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "please fill appropriate data to the field!!!", Toast.LENGTH_SHORT);
            toast.show();
        }
        /*
        catch (IOException e){
            Toast toast = Toast.makeText(getApplicationContext(), "IOException found!!!", Toast.LENGTH_SHORT);
            toast.show();
        }*/
    }
}