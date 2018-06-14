package Tests;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class TestGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private JButton b1;
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JLabel  l1;
	
	final class AL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			b1.setBackground(Color.white);
			b2.setBackground(Color.white);
			b3.setBackground(Color.white);
			b4.setBackground(Color.white);
			
			JButton tempbutton = (JButton) e.getSource();
			tempbutton.setBackground(Color.gray);
			l1.setText(tempbutton.getText()+"输出");
		}
	}
	
	public TestGUI() {
		super("TestGUI");
		
		container = getContentPane();
		container.setLayout(new BorderLayout(5,5));
		b1 = new JButton("北区");
		b2 = new JButton("南区");
		b3 = new JButton("西区");
		b4 = new JButton("东区");
		l1 = new JLabel();
		
		b1.setOpaque(true);
		b1.setBorderPainted(false);
		b2.setOpaque(true);
		b2.setBorderPainted(false);
		b3.setOpaque(true);
		b3.setBorderPainted(false);
		b4.setOpaque(true);
		b4.setBorderPainted(false);
		
		container.add(BorderLayout.NORTH,	b1);
		container.add(BorderLayout.SOUTH,	b2);
		container.add(BorderLayout.WEST, 	b3);
		container.add(BorderLayout.EAST, 	b4);
		container.add(BorderLayout.CENTER,	l1);
		
		b1.addActionListener(new AL());
		b2.addActionListener(new AL());
		b3.addActionListener(new AL());
		b4.addActionListener(new AL());
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		TestGUI application = new TestGUI();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
