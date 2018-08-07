package com.example.brainbruiser;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Hello extends ActionBarActivity {
	Button hello;
	Bundle b;
	public static MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello);
		player = MediaPlayer.create(this,R.raw.cate);
		player.setLooping(true);
		player.start();
		b = getIntent().getExtras();
		final String value=b.getString("userName");
		hello=(Button)findViewById(R.id.button1);
		hello.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    player.stop();
				Bundle bundle=new Bundle();
				bundle.putString("userName",value );
				Intent i=new Intent(getApplicationContext(),Categories.class);
				i.putExtras(bundle);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hello, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		player.stop();
	}
}
