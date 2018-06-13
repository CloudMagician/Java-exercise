package Tests;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private JLabel slabel;
	private JLabel tlabel;
	private JTextField stextfield;
	private JTextField ttextfield;
	private JButton clear;
	private JButton copy;
	private JButton close;
	
	private class AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JButton temp = (JButton)e.getSource();
			if (temp == clear) {
				stextfield.setText("");
				ttextfield.setText("");
			} else if (temp == copy) {
				ttextfield.setText(stextfield.getText());
			} else if (temp == close) {
				System.exit(0);
			}
		}
	}
	
	public TextGUI() {
		super("TextGUI");
		
		container = getContentPane();
		container.setLayout(new FlowLayout());
		
		slabel = new JLabel("Source");
		tlabel = new JLabel("Target");
		stextfield = new JTextField(20);
		ttextfield = new JTextField(20);
		clear = new JButton("Clear");
		copy  = new JButton("Copy");
		close = new JButton("Close");
		
		clear.addActionListener(new AL());
		copy.addActionListener(new AL());
		close.addActionListener(new AL());
		
		container.add(slabel);
		container.add(tlabel);
		container.add(stextfield);
		container.add(ttextfield);
		container.add(clear);
		container.add(copy);
		container.add(close);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TextGUI app = new TextGUI();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
