package com.example.brainbruiser;




import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Categories extends ActionBarActivity {
	Button apt,cinema,poli,sports,tech;
	TextView t;
	Bundle bundle;
	public static MediaPlayer player;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories);
		player = MediaPlayer.create(this,R.raw.cate);
		player.setLooping(true);
		player.start();
		bundle = getIntent().getExtras();
		final String value=bundle.getString("userName");
		t=(TextView)findViewById(R.id.textView2);
		t.setText("Hello "+value+"!");
		apt=(Button)findViewById(R.id.button1);
		cinema=(Button)findViewById(R.id.button2);
		poli=(Button)findViewById(R.id.button3);
		sports=(Button)findViewById(R.id.button4);
		tech=(Button)findViewById(R.id.button5);
    apt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Bundle bundle=new Bundle();
				//bundle.putCharSequence("cat",apt.getText());
				player.stop();
				Intent intent=new Intent(getBaseContext(),Aptitude.class);
				//intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        cinema.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				player.stop();
				// TODO Auto-generated method stub
				//Bundle bundle=new Bundle();
				//bundle.putCharSequence("cat",cinema.getText());
				Intent intent=new Intent(getBaseContext(),Cinema.class);
				//intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        poli.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Bundle bundle=new Bundle();
				player.stop();
				bundle.putString("USERNAME",value);
				Intent intent=new Intent(getBaseContext(),Politics.class);
				//intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        sports.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				player.stop();
				Intent intent=new Intent(getBaseContext(),Sports.class);
				
				startActivity(intent);
			}
		});
        tech.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Bundle bundle=new Bundle();
				//bundle.putCharSequence("cat",tech.getText());
				player.stop();
				Intent intent=new Intent(getBaseContext(),Technology.class);
				//intent.putExtras(bundle);
				startActivity(intent);
			}
		});
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.categories, menu);
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
