package com.tejab.sqlserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ResultSet;

public class Register extends AppCompatActivity {


    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
    }

    public void switchtoVendor(View view){
        Intent i= new Intent(getApplicationContext(),Vendor.class);
        startActivity(i);
    }
    public void switchtoCustomer(View view){
        Intent i= new Intent(getApplicationContext(),Customer.class);
        startActivity(i);
    }
}
