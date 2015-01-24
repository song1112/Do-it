package com.example.gamejamf;





import android.app.Activity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Intent intent;
	View home;
	Button home_btn, puzzle_btn, task_btn; //底下的主鍵
	SharedPreferences getTask;
	Button start1, start2, start3, start4, start5; //開始結束按鈕
	TextView taskText1, taskText2, taskText3, taskText5, taskText4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//set bottom click event
		home = (View)findViewById(R.id.home);
		home_btn = (Button)home.findViewById(R.id.home_btn);
		puzzle_btn = (Button)home.findViewById(R.id.puzzle_btn);
		task_btn = (Button)home.findViewById(R.id.task_btn);
		
		home_btn.setOnClickListener(mainListener);
		puzzle_btn.setOnClickListener(mainListener);
		task_btn.setOnClickListener(mainListener);
		
		
		
		
		taskText1 = (TextView)findViewById(R.id.taskText1);
		taskText2 = (TextView)findViewById(R.id.taskText2);
		taskText3 = (TextView)findViewById(R.id.taskText3);
		taskText4 = (TextView)findViewById(R.id.taskText4);
		taskText5 = (TextView)findViewById(R.id.taskText5);
		
		taskText1.setOnClickListener(textListener);
		taskText2.setOnClickListener(textListener);
		taskText3.setOnClickListener(textListener);
		taskText4.setOnClickListener(textListener);
		taskText5.setOnClickListener(textListener);
		// set SharedPreferences
		getTask = getSharedPreferences("DATA",0);
		
		//
		
		setTask();
	}
	
	private OnClickListener textListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch(v.getId()) {
			case R.id.taskText1:
				textviewEvent(taskText1);
				
				break;
			case R.id.taskText2:
				textviewEvent(taskText2);
				break;
			case R.id.taskText3:
				textviewEvent(taskText3);
				break;
			case R.id.taskText4:
				textviewEvent(taskText4);
				break;
			case R.id.taskText5:
				textviewEvent(taskText5);
				break;
			}
		}
	};
	
	public void textviewEvent(TextView tv) {
		Resources res = this.getResources();
        Drawable drawable = res.getDrawable(R.drawable.mission_ok);
		tv.setBackground(drawable);
		Paint paint = tv.getPaint();
		paint.setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		paint.setAntiAlias(true);
		//儲存拼圖
		savePuzzle();
	}
	
	//底下按鈕的方法
	private OnClickListener mainListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId())
		    {      
		      case R.id.home_btn:  
		    	 // do not anything
		    	  break;
		      case R.id.puzzle_btn: 
		    	 intent = new Intent(MainActivity.this, PuzzleActivity.class);
		    	 startActivity(intent);
		    	 break;
		      case R.id.task_btn:
		    	 intent = new Intent(MainActivity.this, EventActivity.class);
		    	 startActivity(intent);
		    	 break;
		    }
		}
	
	};
	
	//存卡片
	public void savePuzzle() {
		DrawnPuzzles dp = new DrawnPuzzles();
		PuzzleDB pdb = new PuzzleDB(this);
		SQLiteDatabase db = pdb.getWritableDatabase();
		ContentValues args = new ContentValues();
		int i = dp.draw();
		args.put("PUZZLE_FRAG", i);
		long rowid = db.insert("INCOME", null, args);
		Log.i("PuzzleDB","SQL:record inserted, id=" + rowid);
		Toast.makeText(this, "Congratulations, get NO." + i + "puzzle",
		          Toast.LENGTH_LONG).show();
		db.close();
		
	}
	
	public void setTask() {
		//if (getTask.getString("TASK1", "") != null)
		taskText1.setText(getTask.getString("TASK1", ""));
		taskText2.setText(getTask.getString("TASK2", ""));
		taskText3.setText(getTask.getString("TASK3", ""));
		taskText4.setText(getTask.getString("TASK4", ""));
		taskText5.setText(getTask.getString("TASK5", ""));

	}
	
	
}
