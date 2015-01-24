package com.example.gamejamf;

import java.util.HashSet;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class PuzzleActivity extends Activity {
	View puzzle;
	Button home_btn, puzzle_btn, task_btn; //底下的主鍵
	ImageView frag1, frag2, frag3, frag4, frag5, frag6, frag7, frag8, frag9 ;
	//frag6, frag7, frag8, frag9
	Set<String> flags; //存已獲得的拼圖
//	String 
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
		
		flags = new HashSet<String>();
		
		frag1 = (ImageView)findViewById(R.id.frag1);
		frag2 = (ImageView)findViewById(R.id.frag2);
		frag3 = (ImageView)findViewById(R.id.frag3);
		frag4 = (ImageView)findViewById(R.id.frag4);
		frag5 = (ImageView)findViewById(R.id.frag5);
		frag6 = (ImageView)findViewById(R.id.frag6);
		frag7 = (ImageView)findViewById(R.id.frag7);
		frag8 = (ImageView)findViewById(R.id.frag8);
		frag9 = (ImageView)findViewById(R.id.frag9);
		
		frag1.setOnClickListener(imageListener);
		frag2.setOnClickListener(imageListener);
		frag3.setOnClickListener(imageListener);
		frag4.setOnClickListener(imageListener);
		frag5.setOnClickListener(imageListener);
//		frag6.setOnClickListener(imageListener);
//		frag7.setOnClickListener(imageListener);
//		frag8.setOnClickListener(imageListener);
//		frag9.setOnClickListener(imageListener);
	}
	
	private OnClickListener imageListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			coverUnknown();//先複蓋所有的牌
			getPuzzleDB();//取得已獲得的牌
			switch(v.getId()) {
			case R.id.frag1:
				puzzle0Event(0);
				puzzle1Event(0);
				break;
			case R.id.frag2:
				puzzle0Event(1);
				puzzle1Event(1);
				break;
			case R.id.frag3:
				puzzle0Event(2);
				puzzle1Event(2);
				break;
			case R.id.frag4:
				puzzle0Event(3);
				puzzle1Event(3);
				break;
			case R.id.frag5:
				puzzle0Event(4);
				puzzle1Event(4);
				break;

			}
		}
	};
	
	
	//每個大拼圖的第一格
	private void puzzle0Event(int i) {
		switch(i) {
		case 0:
			for (String s:flags) {
				int t = Integer.parseInt(s);
				if(t==0) {
					frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle0));
				}
			}
			break;
		case 1:
			for (String s:flags) {
				int t = Integer.parseInt(s);
				if(t==9) {
					frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle9));
				}
			}
			break;
		case 2:
			for (String s:flags) {
				int t = Integer.parseInt(s);
				if(t==18) {
					frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle18));
				}
			}
			break;
		case 3:
			for (String s:flags) {
				int t = Integer.parseInt(s);
				if(t==27) {
					frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle18));
				}
			}
			break;
		case 4:		
			for (String s:flags) {
				int t = Integer.parseInt(s);
				if(t==36) {
					frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle18));
				}
			}
		}
	}
	
	//每個大拼圖的第一格
		private void puzzle1Event(int i) {
			switch(i) {
			case 0:
				for (String s:flags) {
					int t = Integer.parseInt(s);
					if(t==1) {
						frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle1));
					}
				}
				break;
			case 1:
				for (String s:flags) {
					int t = Integer.parseInt(s);
					if(t==10) {
						frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle9));
					}
				}
				break;
			case 2:
				for (String s:flags) {
					int t = Integer.parseInt(s);
					if(t==19) {
						frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle18));
					}
				}
				break;
			case 3:
				for (String s:flags) {
					int t = Integer.parseInt(s);
					if(t==28) {
						frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle18));
					}
				}
				break;
			case 4:		
				for (String s:flags) {
					int t = Integer.parseInt(s);
					if(t==37) {
						frag1.setImageDrawable(getResources().getDrawable(R.drawable.puzzle18));
					}
				}
			}
		}
	private void getPuzzleDB() {
		PuzzleDB pdb = new PuzzleDB(this);
		SQLiteDatabase db = pdb.getWritableDatabase();
		Cursor cursor = db.query("INCOME", new String[] { "_ID",
		    	"PUZZLE_FRAG" }, null, null, null, null, null);
		if (cursor.moveToFirst()) {
	        do {
	        	flags.add(cursor.getString(1));
	          
	        } while (cursor.moveToNext());
	    }
		cursor.close();
		db.close();
		
	}
	
	//複蓋所有的牌
	private void coverUnknown() {
		frag1.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag2.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag3.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag4.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag5.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag6.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag7.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag8.setImageDrawable(getResources().getDrawable(R.drawable.none));
		frag9.setImageDrawable(getResources().getDrawable(R.drawable.none));
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
