package com.example.gamejamf;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class EventActivity extends Activity{
	View event;
	Button home_btn, puzzle_btn, task_btn; //底下的主鍵
	TextView task1, task2, task3, task4, task5;
	TaskGenerator tg;
	SharedPreferences saveTask;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_event);
		//set bottom click event
		event = (View)findViewById(R.id.event);
		home_btn = (Button)event.findViewById(R.id.home_btn);
		puzzle_btn = (Button)event.findViewById(R.id.puzzle_btn);
		task_btn = (Button)event.findViewById(R.id.task_btn);
						
		home_btn.setOnClickListener(mainListener);
		puzzle_btn.setOnClickListener(mainListener);
		task_btn.setOnClickListener(mainListener);
		 tg = new TaskGenerator();
		task1 = (TextView)findViewById(R.id.task1);
		task2 = (TextView)findViewById(R.id.task2);
		task3 = (TextView)findViewById(R.id.task3);
		task4 = (TextView)findViewById(R.id.task4);
		task5 = (TextView)findViewById(R.id.task5);
		saveTask = getSharedPreferences("DATA",0);
		task1.setOnClickListener(eventListener);
		task2.setOnClickListener(eventListener);
		task3.setOnClickListener(eventListener);
		task4.setOnClickListener(eventListener);
		task5.setOnClickListener(eventListener);
		
		setTask();
	}
			
	//底部的按鈕事件
	private OnClickListener mainListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent;
			switch (v.getId())
			{      
				case R.id.home_btn:  
				   intent = new Intent(EventActivity.this, MainActivity.class);
				   startActivity(intent);
				   break;
				case R.id.puzzle_btn: 
					intent = new Intent(EventActivity.this, PuzzleActivity.class);
					startActivity(intent);
				   break;
				case R.id.task_btn:
				   //
				   break;
			}
		}
			
	};
	private OnClickListener eventListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String s;
			switch (v.getId())
			{      
			case R.id.task1:
//				s = getTime();
				saveTask.edit().putString("TASK1", task1.getText().toString()).commit();
				task1.setEnabled(false);
				task1.setText("Done");
				break;
			case R.id.task2:
//				s = getTime();
				saveTask.edit().putString("TASK2", task2.getText().toString()).commit();
				task2.setEnabled(false);
				task2.setText("Done");
				break;
			case R.id.task3:
//				s = getTime();
				saveTask.edit().putString("TASK3", task3.getText().toString()).commit();
				task3.setEnabled(false);
				task3.setText("Done");
				break;
			case R.id.task4:
//				s = getTime();
				saveTask.edit().putString("TASK4", task4.getText().toString()).commit();
				task4.setEnabled(false);
				task4.setText("Done");
				break;
			case R.id.task5:
//				s = getTime();
				saveTask.edit().putString("TASK5", task5.getText().toString()).commit();
				task5.setEnabled(false);
				task5.setText("Done");
				break;
			}
			
		}
	};
	
//	//time
//	 private String getTime() {
//
//		TimePickerDialog time = new TimePickerDialog(this,new OnTimeSetListener() {
//			
//			@Override
//			public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//				String taskTime = hourOfDay + ":" + minute;
//				saveTask.edit().putString("TIME", taskTime).commit();
//				
//			}
//		}, 0, 0, true);
//		time.show();
//		
//		return saveTask.getString("TIME", "");
//	 }
             
	public void setTask() {

		task1.setText(tg.getTask(0));
		task2.setText(tg.getTask(1));
		task3.setText(tg.getTask(2));
		task4.setText(tg.getTask(3));
		task5.setText(tg.getTask(4));
	}
}
