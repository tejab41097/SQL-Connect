package com.tejab.sqlserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText email,password;
    String eemail,epassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.editText2);
        password=findViewById(R.id.editText3);
    }

    public void register(View view){
        Intent i=new Intent(getApplicationContext(),Register.class);
        startActivity(i);
    }

    public void login(View view){
        eemail=email.getText().toString();
        epassword=password.getText().toString();
        LoginProcess user=new LoginProcess();
        Toast.makeText(getApplicationContext(),user.login_check(eemail,epassword),Toast.LENGTH_LONG).show();
        if(user.login_check(eemail,epassword).equals("successful")) {
            Toast.makeText(getApplicationContext(),"You have successfully logged in with email:-"+eemail,Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(), LoggedIn.class);
            startActivity(i);
        }else{
            email.setText("");
            password.setText("");
        }
    }
}
