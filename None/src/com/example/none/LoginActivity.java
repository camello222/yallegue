package com.example.none;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {


	// UI references.
	private AutoCompleteTextView mNameView;
	private EditText mPasswordView;
	private Button mLoginButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	     setContentView(R.layout.activity_login);
	     mNameView = (AutoCompleteTextView)findViewById(R.id.name);
	     mPasswordView = (EditText)findViewById(R.id.password);
	     mLoginButton = (Button)findViewById(R.id.email_sign_in_button);
	     mLoginButton.setOnClickListener(new View.OnClickListener() {
	    	 public void onClick(View v) {
	    		 // Perform action on click   
	    		 try {
	    			 UserDriver.login(mNameView.getText().toString(), mPasswordView.getText().toString());
	    			 Intent i = new Intent("com.example.none.MainActivity");
	    			 startActivity(i);
	    		 } catch (Exception e) {
	    			 // TODO Auto-generated catch block
	    			 Toast.makeText(getApplicationContext(), e.toString(),
	    					 Toast.LENGTH_LONG).show();
	    		 }
             }
         });

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
