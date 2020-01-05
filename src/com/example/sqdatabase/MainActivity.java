package com.example.sqdatabase;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity   {
	EditText e1,e2,e3;
	SQL sq;
	String s;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText1);
        e2=(EditText)findViewById(R.id.editText2);
        e3=(EditText)findViewById(R.id.editText3);
        sq=new SQL(MainActivity.this);
    }

    public void save( View v) {
		sq.open();
		sq.savemyd(e1.getText().toString(),e2.getText().toString());
		sq.close();
		Toast.makeText(getApplicationContext(), "Data Saved", 5000).show();
		}
    public void delete( View v) {
    	sq.open();
    	sq.delmyd(e3.getText().toString());
    	sq.close();
    	Toast.makeText(getApplicationContext(), "Data Deleted", 5000).show();
   	}
    public void view( View v) {
    	sq.open();
    	Toast.makeText(getApplicationContext(), "Viewing Data", 1000).show();
    	s=sq.view();
    	Dialog d=new Dialog(this);
    	d.setTitle("Your Data:-");
    	TextView t  = new TextView(this);
    	t.setText(s);
    	d.setContentView(t);
    	d.show();
    	sq.close();
   	}
    public void update( View v) {
    	sq.open();
    	sq.updatemyd(e3.getText().toString(),e1.getText().toString(),e2.getText().toString());
    	sq.close();
    	Toast.makeText(getApplicationContext(), "Updation Done Succesfully!!", 1000).show();
   	}
    
   
    
}
