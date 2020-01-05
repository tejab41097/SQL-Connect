package com.example.drive.drive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterIp extends AppCompatActivity {
    String ip="";
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_ip);
        e1=findViewById(R.id.editText);
    }
    public void click(View view){
        ip=e1.getText().toString();
        IpClass ipClass=new IpClass();
        ipClass.setIP(ip);
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
}
