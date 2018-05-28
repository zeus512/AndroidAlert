package com.example.androidalert;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePinActivity extends Activity {
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public static final String Password = "password";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_change_pin);
		final EditText et=(EditText)findViewById(R.id.editText1);
		final EditText et2=(EditText)findViewById(R.id.editText2);
		Button bt=(Button)findViewById(R.id.button1);
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String aa=et.getText().toString();
				String bb=et2.getText().toString();
				if(aa.equals("")& bb.equals("")){
					Toast.makeText(getApplicationContext(), "Please enter All Fields", 90).show();
				}else{
					 sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
	        		SharedPreferences.Editor editor = sharedpreferences.edit();
	        
	        		//---save the values in the EditText view to preferences---
	     			editor.putString(Password, bb);
	        
	        		//---saves and update the values both are same---
	                	editor.commit();
	        
	        		Toast.makeText(getBaseContext(), "Updated Successfully",
					Toast.LENGTH_SHORT).show();
	        		Intent it=new Intent(ChangePinActivity.this,SettingsActivity.class);
					startActivity(it);
					finish();
				}
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_change_pin, menu);
		return true;
	}

}
