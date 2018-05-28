package com.example.androidalert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPinActivity extends Activity {
SharedPreferences sharedpreferences;
public static final String MyPREFERENCES = "MyPrefs" ;
public static final String Password = "password";
EditText ed;
Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter_pin);
		 sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	      ed=(EditText)findViewById(R.id.editText1);
	      
	      b1=(Button)findViewById(R.id.button1);
	      sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	      
	      b1.setOnClickListener(new View.OnClickListener() {
	         @Override
	         public void onClick(View v) {
	            String n  = ed.getText().toString();
	            
	            SharedPreferences.Editor editor = sharedpreferences.edit();
	            
	            editor.putString(Password, n);
	           
	            editor.commit();
	            Intent it=new Intent(EnterPinActivity.this,PinActivity.class);
				startActivity(it);
	            Toast.makeText(getApplicationContext(),"Signup Completed",Toast.LENGTH_LONG).show();
	         }
	      });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_enter_pin, menu);
		return true;
	}

}
