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
	private JLabel slabel = new JLabel("Source");
	private JLabel tlabel = new JLabel("Target");
	private JTextField stextfield = new JTextField(20);
	private JTextField ttextfield = new JTextField(20);
	private JButton clear = new JButton("Clear");
	private JButton copy  = new JButton("Copy");
	private JButton close = new JButton("Close");
	
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
