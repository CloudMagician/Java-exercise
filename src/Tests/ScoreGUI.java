package Tests;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class ScoreGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Container container;
	private FlowLayout flow;
	
	private JLabel label;
	private JTextField textfield;
	private JTextArea textarea;
	private JButton button;
	
	public ScoreGUI() {
		super("ScoreGUI");
		
		flow = new FlowLayout(1);
		container = getContentPane();
		container.setLayout(flow);
		flow.setAlignment(FlowLayout.CENTER);
		
		label = new JLabel("请输入您的成绩");
		textfield = new JTextField(4);
		textarea = new JTextArea(20,16);
		button = new JButton("submit");
		
		container.add(label);
		container.add(textfield);
		container.add(button);
		container.add(textarea);
		
		button.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Double result = Double.parseDouble(textfield.getText());
					if (result >= 60) {
						textarea.setText("您的成绩为："+result+"\t及格"); 
					} else {
						textarea.setText("您的成绩为："+result+"\t不及格"); 
					}
				}
			}
		);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ScoreGUI application = new ScoreGUI();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}