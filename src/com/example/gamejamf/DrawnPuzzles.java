package com.example.gamejamf;

import java.util.Random;

public class DrawnPuzzles {
	Random rand = new Random();
	int[] puzzle = new int[27];
	
	public DrawnPuzzles() {
		for (int i=0;i<puzzle.length;i++) {
			puzzle[i] = i;
		}
	}
	//洗牌程式
	public void shuffle() {
		for(int i=0;i<27;i++) {
			int p = rand.nextInt(27); //隨機的位置
			int temp = puzzle[i]; //暫存
			puzzle[i] = puzzle[p]; //交換
			puzzle[p] = puzzle[i];
		}
	}
	
	//抽拼圖
	public int draw() {
		return puzzle[rand.nextInt(27)];
		//return puzzle[i];
	}
	
	

}
