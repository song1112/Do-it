package com.example.gamejamf;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PuzzleActivity extends Activity {
	View puzzle;
	Button home_btn, puzzle_btn, task_btn; //©³¤Uªº¥DÁä
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.check_puzzle);
		
		//set bottom click event
		puzzle = (View)findViewById(R.id.puzzle);
		home_btn = (Button)puzzle.findViewById(R.id.home_btn);
		puzzle_btn = (Button)puzzle.findViewById(R.id.puzzle_btn);
		task_btn = (Button)puzzle.findViewById(R.id.task_btn);
				
		home_btn.setOnClickListener(mainListener);
		puzzle_btn.setOnClickListener(mainListener);
		task_btn.setOnClickListener(mainListener);
	}
	
	private OnClickListener mainListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent;
			switch (v.getId())
		    {      
		      case R.id.home_btn:  
		    	intent = new Intent(PuzzleActivity.this, MainActivity.class);
			    startActivity(intent);
		    	break;
		      case R.id.puzzle_btn: 
		    	//don't do
		    	break;
		      case R.id.task_btn:
		    	intent = new Intent(PuzzleActivity.this, EventActivity.class);
			    startActivity(intent);
			    break;
		    }
		}
	
	};

}
