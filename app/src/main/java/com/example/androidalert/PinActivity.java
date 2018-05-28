package com.example.androidalert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PinActivity extends Activity {
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String Password = "password";
	String password1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pin);
		 sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

 		if (sharedpreferences.contains(Password)) {
			 password1=sharedpreferences.getString(Password, "");
		}
		final EditText pin=(EditText)findViewById(R.id.editText1);
		Button click=(Button)findViewById(R.id.button1);
		TextView tv=(TextView)findViewById(R.id.textView2);
		click.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String value=pin.getText().toString();
				if(value.equals(password1)){
					Intent it=new Intent(PinActivity.this,SettingsActivity.class);
					startActivity(it);
							
				}else{
					Toast.makeText(getApplicationContext(), "Invalid Pin Entered", Toast.LENGTH_LONG).show();
				}
			}
		});
		tv.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it=new Intent(PinActivity.this,EnterPinActivity.class);
				startActivity(it);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_pin, menu);
		return true;
	}

}
