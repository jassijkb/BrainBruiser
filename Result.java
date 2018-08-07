package com.example.brainbruiser;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class Result extends ActionBarActivity {
	TextView t;
	int cls;
	 private ImageSwitcher sw;
	 int score;
	 public static MediaPlayer player;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		player = MediaPlayer.create(this,R.raw.resu);
		player.setLooping(true);
		player.start();
		sw = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
		t=(TextView)findViewById(R.id.textView1);
		Intent i=getIntent();
		Bundle b = i.getExtras();
		 score= b.getInt("score");
		 cls=b.getInt("class");
		 System.out.println(cls);
		t.setText("Your score "+score+"/10");
		 sw.setFactory(new ViewFactory() {
	         @Override
	         public View makeView() {
	            ImageView myView = new ImageView(getApplicationContext());
	            myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
	            myView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
	            return myView;
	         }
	      });
		 setImage();
		 
		
	}
	public void restart(View view){
		player.stop();
		switch (cls){
		case 1:{
		Intent i=new Intent(Result.this,Technology.class);
		startActivity(i);
		break;
		}
		case 2:{
			Intent i=new Intent(Result.this,Aptitude.class);
			startActivity(i);
			break;
			}
		case 3:{
			Intent i=new Intent(Result.this,Cinema.class);
			startActivity(i);
			break;
			}
		case 4:{
			Intent i=new Intent(Result.this,Politics.class);
			startActivity(i);
			break;
			}
		case 5:{
			Intent i=new Intent(Result.this,Sports.class);
			startActivity(i);
			break;
			}
		default:
			break;
		}
	
	}
	public void exit(View view){
		player.stop();
		android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

	}
	public void setImage(){
		if(score==10)
			 sw.setImageResource(R.drawable.vgsmiley);
		else if(score==9||score==8)
			sw.setImageResource(R.drawable.smiley);
		else if(score==7||score==6||score==5)
			sw.setImageResource(R.drawable.ok);
		else if(score==3||score==4)
			sw.setImageResource(R.drawable.ohno);
		else if(score==2||score==1)
			sw.setImageResource(R.drawable.loser);			
		else 
			sw.setImageResource(R.drawable.tearful);	
	}
		
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.result, menu);
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
