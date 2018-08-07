package com.example.brainbruiser;

import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class Cinema extends ActionBarActivity {
	List<Question> quesList;
	int score=0;
	int qid=0;
	Question currentQ;
	TextView txtQuestion;
	RadioButton rda, rdb, rdc,rdd;
	Button butNext;
	private ViewSwitcher switcher;
	private static final int REFRESH_SCREEN = 1;
	private TextView timerValue;
    private long startTime = 0L;
    private Handler customHandler = new Handler();
    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;
    AlertDialog.Builder alertDialogBuilder;
	public static MediaPlayer player;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cinema);
		player = MediaPlayer.create(this,R.raw.mus);
		player.setLooping(true);
		player.start();
		switcher = (ViewSwitcher) findViewById(R.id.ViewSwitcher);
		startScan();
		DBHelper db=new DBHelper(this);
		quesList=db.getAllQuestions3();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.textView1);
		rda=(RadioButton)findViewById(R.id.radio0);
		rdb=(RadioButton)findViewById(R.id.radio1);
		rdc=(RadioButton)findViewById(R.id.radio2);
		rdd=(RadioButton)findViewById(R.id.radioButton1);
		butNext=(Button)findViewById(R.id.button1);
		timerValue = (TextView) findViewById(R.id.timerValue);
		
		alertDialogBuilder = new AlertDialog.Builder(this);
				 alertDialogBuilder.setMessage("OOPS!!!!  TIME UP.............." +
				 		"Do you want to restart??");
				alertDialogBuilder.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
			         @Override
			         public void onClick(DialogInterface arg0, int arg1) {
			        	Restart();
			            //Toast.makeText(MainActivity.this,"You clicked yes button",Toast.LENGTH_LONG).show();
			         }
			      });
			      
			      alertDialogBuilder.setNegativeButton("EXIT",new DialogInterface.OnClickListener() {
			         @Override
			         public void onClick(DialogInterface dialog, int which) {
			            finish();
			         }
			      });
			     
	}
	public void Restart()
	{
	   this.recreate();
	}

public void startScan() {
		
		new Thread() {
			
			public void run() {		
				
				try{			
					
					Thread.sleep(5000);
					Refresh.sendEmptyMessage(REFRESH_SCREEN);
				} catch(Exception e){
				}
			}
		}.start();
	}
Handler Refresh = new Handler(){
	public void handleMessage(Message msg) {
		
		switch(msg.what){
		
		case REFRESH_SCREEN:
			switcher.showNext();
			startTime = SystemClock.uptimeMillis();
            customHandler.postDelayed(updateTimerThread, 0);
            setQuestionView();
			butNext.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
					RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
					System.out.println(currentQ.getANSWER());
					
					if(currentQ.getANSWER().equals(answer.getText()))
					{
					score++;
					System.out.println("score");
					
					}
					if(qid<10){
						 
					currentQ=quesList.get(qid);
					setQuestionView();
					}else{
				   player.stop();
						 customHandler.removeCallbacks(updateTimerThread);
					Intent intent = new Intent(getApplicationContext(), Result.class);
					Bundle b = new Bundle();
					b.putInt("score", score);
					b.putInt("class",3);
					intent.putExtras(b); 
					startActivity(intent);
					finish();
					}
					}
			});
			// To go back to the first view, use switcher.showPrevious()
			break;

		default:
			break;
		}
	}
};
private Runnable updateTimerThread = new Runnable() {
    public void run() {
        timeInMilliseconds = SystemClock.uptimeMillis() - startTime;
        updatedTime = timeSwapBuff + timeInMilliseconds;
        int secs = (int) (updatedTime / 1000);
        int mins = secs / 60;
        secs = secs % 60;
       
       
        int milliseconds = (int) (updatedTime % 1000);
        if(mins<1){
        timerValue.setText("" + mins + ":"
                + String.format("%02d", secs) + ":"
                + String.format("%03d", milliseconds));
        customHandler.postDelayed(this, 0);
        }
        else{
        	timerValue.setText("1:00:000");
        	AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            customHandler.removeCallbacks(updateTimerThread);
            customHandler.postDelayed(this, 9000000);
        	 
        	 //timeSwapBuff += timeInMilliseconds;
            // customHandler.removeCallbacks(updateTimerThread);
        }
        
       
    }

};
private void setQuestionView()
{
txtQuestion.setText(currentQ.getQUESTION());
rda.setText(currentQ.getOPTA());
rdb.setText(currentQ.getOPTB());
rdc.setText(currentQ.getOPTC());
rdd.setText(currentQ.getOPTD());

qid++;
}




	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cinema, menu);
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
