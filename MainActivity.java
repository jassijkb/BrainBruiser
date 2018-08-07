package com.example.brainbruiser;

import android.support.v7.app.ActionBarActivity;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	Button btnSignIn,btnSignUp;
	LoginDataBaseAdapter loginDataBaseAdapter;
	public static MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		player = MediaPlayer.create(this,R.raw.cate);
		player.setLooping(true);
		player.start();
		loginDataBaseAdapter=new LoginDataBaseAdapter(this);
	     loginDataBaseAdapter=loginDataBaseAdapter.open();

	     btnSignIn=(Button)findViewById(R.id.buttonSignIN);
	     btnSignUp=(Button)findViewById(R.id.buttonSignUP);

	    btnSignUp.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
			// TODO Auto-generated method stub

			/// Create Intent for SignUpActivity  abd Start The Activity
			player.stop();
			Intent intentSignUP=new Intent(getApplicationContext(),Signup.class);
			startActivity(intentSignUP);
			}
		});
	}

	public void signIn(View V)
	   {
			final Dialog dialog = new Dialog(MainActivity.this);
			dialog.setContentView(R.layout.login);
		    dialog.setTitle("Login");

		    // get the Refferences of views
		    final  EditText editTextUserName=(EditText)dialog.findViewById(R.id.editTextUserNameToLogin);
		    final  EditText editTextPassword=(EditText)dialog.findViewById(R.id.editTextPasswordToLogin);

			Button btnSignIn=(Button)dialog.findViewById(R.id.buttonSignIn);

			// Set On ClickListener
			btnSignIn.setOnClickListener(new View.OnClickListener() {

				public void onClick(View v) {
					// get The User name and Password
					String userName=editTextUserName.getText().toString();
					String password=editTextPassword.getText().toString();

					// fetch the Password form database for respective user name
					String storedPassword=loginDataBaseAdapter.getSinlgeEntry(userName);

					// check if the Stored password matches with  Password entered by user
					if(password.equals(storedPassword))
					{
						Toast.makeText(MainActivity.this, "Congrats: Login Successfull", Toast.LENGTH_SHORT).show();
						//dialog.dismiss();
						Bundle bundle=new Bundle();
						bundle.putString("userName",userName );
						Intent i=new Intent(getApplicationContext(),Hello.class);
						i.putExtras(bundle);
					    startActivity(i);
					}
					else
					{
						Toast.makeText(MainActivity.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
					}
				}
			});

			dialog.show();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	    // Close The Database
		player.stop();
		loginDataBaseAdapter.close();
	}
}