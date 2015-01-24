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
	//�~�P�{��
	public void shuffle() {
		for(int i=0;i<27;i++) {
			int p = rand.nextInt(27); //�H������m
			int temp = puzzle[i]; //�Ȧs
			puzzle[i] = puzzle[p]; //�洫
			puzzle[p] = puzzle[i];
		}
	}
	
	//�����
	public int draw() {
		return puzzle[rand.nextInt(27)];
		//return puzzle[i];
	}
	
	

}
