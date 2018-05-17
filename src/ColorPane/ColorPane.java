package ColorPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class ColorPane extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JButton buttons[];
	private String names[] = {"blue","cyan","green",
			"magenta","orange","pink","red","white","yellow"};
	private Container container;
	private GridLayout grid;
	
	public ColorPane() {
		super("ColorPane");
		grid = new GridLayout(3, 3, 5, 5);
		container = getContentPane();
		container.setLayout(grid);
		
		buttons = new JButton[names.length];
		for (int count = 0; count < names.length; count++) {
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
			container.add(buttons[count]);
	    }
		setSize(300, 300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		int temp = 0;
		while (temp < names.length && 
				event.getSource() != buttons[temp]) {
			temp++;
		}
		switch (temp) {
		case 0:
			buttons[temp].setBackground(Color.blue);
			break;
		case 1:
			buttons[temp].setBackground(Color.cyan);
			break;
		case 2:
			buttons[temp].setBackground(Color.green);
			break;
		case 3:
			buttons[temp].setBackground(Color.magenta);
			break;
		case 4:
			buttons[temp].setBackground(Color.orange);
			break;
		case 5:
			buttons[temp].setBackground(Color.pink);
			break;
		case 6:
			buttons[temp].setBackground(Color.red);
			break;
		case 7:
			buttons[temp].setBackground(Color.white);
			break;
		case 8:
			buttons[temp].setBackground(Color.yellow);
			break;
		default:
			break;
		}
		buttons[temp].setOpaque(true);
		buttons[temp].setBorderPainted(false);
		container.validate();
	}
	   
	public static void main(String args[]) {
		ColorPane application = new ColorPane();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
