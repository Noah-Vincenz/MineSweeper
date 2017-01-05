package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class OptionFrame extends JFrame{

	private Frame f;
	
	public OptionFrame() {
		super("NoahSweeper");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JLabel jl = new JLabel("Pick difficulty level:");
		add(jl, BorderLayout.NORTH);
		JPanel jpMiddle = new JPanel (new GridLayout(3,1));
		ButtonGroup bg = new ButtonGroup();
		JRadioButton jr1 = new JRadioButton("Beginner -- 10 mines -- 9x9 tile grid");
		jr1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new Frame(9, 9);
			}
		});
		JRadioButton jr2 = new JRadioButton("Intermediate -- 40 mines -- 16x16 tile grid");
		jr2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new Frame(16, 16);
			}
		});
		JRadioButton jr3 = new JRadioButton("Advanced -- 99 mines -- 16x30 tile grid");
		jr3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f = new Frame(16, 30);
			}
		});
		bg.add(jr1);
		bg.add(jr2);
		bg.add(jr3);
		jpMiddle.add(jr1);
		jpMiddle.add(jr2);
		jpMiddle.add(jr3);
		add(jpMiddle, BorderLayout.CENTER);
		setSize(400,300);
		setVisible(true);
	}
}
