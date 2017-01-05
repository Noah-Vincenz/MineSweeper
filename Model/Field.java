package Model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.text.AttributeSet.ColorAttribute;

import View.Frame;

public class Field extends JButton{

	private boolean clicked;
	private boolean isBomb;
	private int row;
	private int column;
	private Frame frame;
	
	public Field(Frame f, int typeNo, int fieldRow, int fieldColumn) {
		row = fieldRow;
		column = fieldColumn;
		if(typeNo == 1) {
			isBomb = false;
		}
		else{
			isBomb = true;
		}
		clicked = false;
		addActionListener(new ActionListener() {
			@Override 
			public void actionPerformed (ActionEvent e) {
				frame.incrementMoves();
				frame.startTimer();
				frame.setTimerStarted();
				setClicked();
				if(getType() == false) {
					int label = checkLabel();
					if(label == 0) {
						setText(Integer.toString(label));
						setForeground(Color.ORANGE);
					}
					if(label == 1) {
						setText(Integer.toString(label));
						setForeground(Color.BLUE);
					}
					if(label == 2) {
						setText(Integer.toString(label));
						setForeground(Color.GREEN);
					}
					if(label == 3) {
						setText(Integer.toString(label));
						setForeground(Color.RED);
					}
					if(label == 4) {
						setText(Integer.toString(label));
						setForeground(Color.PINK);
					}
					if(label == 5) {
						setText(Integer.toString(label));
						setForeground(Color.DARK_GRAY);
					}
					if(label == 6) {
						setText(Integer.toString(label));
						setForeground(Color.YELLOW);
					}
					if(label == 7) {
						setText(Integer.toString(label));
						setForeground(Color.MAGENTA);
					}

				}
				else {
					frame.showFinalMessage();
					System.out.println("Game Over");
				}
				frame.wonMessage();
			}
		});
		frame = f;
		frame.setField(row, column, this);
	}
	
	public boolean getClicked () {
		return clicked;
	}
	
	public void setClicked() {
		clicked = true;
	}
	
	public boolean getType() {
		return isBomb;
	}
	public void setType(boolean b) {
		isBomb = b; 
	}
	public int getRow() {
		return row;
	}
	public int getColumn(){
		return column;
	}
	
	public int checkLabel() { 
		int count = 0;
		if (getRow() != frame.getLength()-1) {
			if (frame.getField(getRow()+1,getColumn()).getType() == true) {
				count++;
			}
		}
		if (getRow() != 0) {
			if (frame.getField(getRow()-1,getColumn()).getType() == true) {
				count++;
			}
		}
		if (getColumn() != frame.getFrameWidth()-1) {
			if (frame.getField(getRow(),getColumn()+1).getType() == true) {
				count++;
			}
		}
		if (getColumn() != 0) {
			if (frame.getField(getRow(),getColumn()-1).getType() == true) {
				count++;
			}
		}
		if (getRow() != frame.getLength()-1 && getColumn() != frame.getFrameWidth()-1) {
			if (frame.getField(getRow()+1,getColumn()+1).getType() == true) {
				count++;
			}
		}
		if (getRow() != frame.getLength()-1 && getColumn() != 0) {
			if (frame.getField(getRow()+1,getColumn()-1).getType() == true) {
				count++;
			}
		}
		if (getRow() != 0 && getColumn() != 0) {
			if (frame.getField(getRow()-1,getColumn()-1).getType() == true) {
				count++;
			}
		}
		if (getRow() != 0 && getColumn() != frame.getFrameWidth()-1) {
			if (frame.getField(getRow()-1,getColumn()+1).getType() == true) {
				count++;
			}
		}
		return count;
	}	
}

