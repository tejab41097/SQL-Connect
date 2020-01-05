package com.tejab.sqlserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Customer extends AppCompatActivity {

    EditText cat,name,phone,email,password,cnfpassword;
    String ecat,ename,ephone,eemail,epassword,ecnfpassword,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
        cat=findViewById(R.id.editText);
        name=findViewById(R.id.editText2);
        phone=findViewById(R.id.editText3);
        email=findViewById(R.id.editText4);
        password=findViewById(R.id.editText5);
        cnfpassword=findViewById(R.id.editText6);
    }

    public void register(View view){
        ecat=cat.getText().toString();
        ename=name.getText().toString();
        ephone=phone.getText().toString();
        eemail=email.getText().toString();
        epassword=password.getText().toString();
        ecnfpassword=cnfpassword.getText().toString();
        LoginProcess newuser=new LoginProcess();
        type="customer";
        if(epassword.equals(ecnfpassword)) {
            String toastmsg = newuser.check_registerCustomer(type,ecat,ename,ephone,eemail,epassword);
            if (toastmsg.equals("successful")) {
                Toast.makeText(getApplicationContext(), "email:- " + eemail + " Registered!!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), toastmsg, Toast.LENGTH_LONG).show();
                email.setText("");
                password.setText("");
                cnfpassword.setText("");
            }
        } else {
            Toast.makeText(getApplicationContext(),"Please Enter same password !!", Toast.LENGTH_LONG).show();
            password.setText("");
            cnfpassword.setText("");
        }
    }
}
