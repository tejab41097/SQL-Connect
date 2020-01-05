package com.tejab.sqlserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Vendor extends AppCompatActivity {

    EditText org,gst,enpol,phone,email,password,cnfpassword;
    String type,eorg,egst,eenpol,ephone,eemail,epassword,ecnfpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor);
        org=findViewById(R.id.editText);
        gst=findViewById(R.id.editText2);
        enpol=findViewById(R.id.editText3);
        phone=findViewById(R.id.editText4);
        email=findViewById(R.id.editText5);
        password=findViewById(R.id.editText6);
        cnfpassword=findViewById(R.id.editText7);
    }

    public void register(View view){
        eorg=org.getText().toString();
        egst=gst.getText().toString();
        eenpol=enpol.getText().toString();
        ephone=phone.getText().toString();
        eemail=email.getText().toString();
        epassword=password.getText().toString();
        ecnfpassword=password.getText().toString();
        LoginProcess newuser=new LoginProcess();
        type="vendor";
        if(epassword.equals(ecnfpassword)) {
            String toastmsg = newuser.check_registerVendor(type, eorg, egst, eenpol, ephone, eemail, epassword);
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
            Toast.makeText(getApplicationContext(), "Please Enter same password !!", Toast.LENGTH_LONG).show();
            password.setText("");
            cnfpassword.setText("");
        }
    }
}
