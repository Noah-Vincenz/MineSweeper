package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Model.Field;

public class Frame extends JFrame {
	
	private Field[][] fieldArray;
	private JLabel moves, timer;
	private int length, width, time;
	private JPanel jpNorth, jpField;
	private int type;
	private Timer t;
	private boolean timerStarted;
	
	public Frame (int fieldLength, int fieldWidth) {
		super ("NoahSweeper");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		type = 0;
		length = fieldLength;
		width = fieldWidth;
		time = 0;
		fieldArray = new Field[length][width];
		setLayout(new BorderLayout());
		jpNorth = new JPanel(new GridLayout(0,2));
		moves = new JLabel("0");
		timer = new JLabel(Integer.toString(time));	    
		t = new Timer();
		timerStarted = false;
		jpNorth.add(moves);
		jpNorth.add(timer);
		add(jpNorth, BorderLayout.NORTH);
		jpField = new JPanel(new GridLayout (length, width));
		add(jpField, BorderLayout.CENTER);
		Random rnd = new Random();
		int n = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (width == 9) {
					n = 7;
				}
				else if (width == 16) {
					n = 5;
				}
				else {
					n = 4;
				}
				type = rnd.nextInt(n);
				Field f;
				if (type == 0) {
					 f = new Field (this, 2, i, j);
				}
				else {
					f = new Field (this, 1, i, j);
				}
				fieldArray[i][j] = f;
				jpField.add(f);
			}
		}
		setSize(500,500);
		setVisible(true);
	}
	
	
	public Field getField (int row, int column) {
		return fieldArray[row][column];
	}

	public void setField (int row, int column, Field f) {
		fieldArray[row][column] = f;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getFrameWidth() {
		return width;
	}
	
	public void showFinalMessage() {
		JOptionPane.showMessageDialog(this, "Game Over. MineField exploded!", "Game Over", JOptionPane.WARNING_MESSAGE);
	}
	public void incrementMoves() {
		String movesString = moves.getText();
		int movesInt = Integer.parseInt(movesString);
		movesInt++;
		moves.setText(Integer.toString(movesInt));
	}
	public void setTimerStarted () {
		timerStarted = true;
	}
	
	public void startTimer() {
		if (timerStarted == false) {
			t.schedule(new TimerTask() {
		        @Override public void run() {
		        	time++;
					timer.setText(Integer.toString(time));
		        }
		    }, 0, 1000);
		}
	}
	
	public boolean checkIfWon() {
		boolean won = true;
		for(int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				Field f = getField(i,j);
				if (f.getType() == false && f.getClicked() == false) {
					won = false;
				}
			}
		}
		return won;
	}
	
	public void wonMessage() {
		if( checkIfWon() == true) {
			JOptionPane.showMessageDialog(this, "You won, all mines captured. Your time: "+time+" seconds.", "You won", JOptionPane.PLAIN_MESSAGE);
		}
	}

}
