package TextIO;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextIO extends JFrame implements ActionListener {
	private static final long serialVersionUID = -5422386071488047299L;
	private FileDialog		op,sv;
    private JButton 		btn1,btn2;
    private JPanel 			jp; 
    private TextArea 		tarea;
    private BorderLayout	border,buttonborder;
	private Container container;
    
    TextIO() {
        super("TextIO");
        border = new BorderLayout(20,20);
        setLayout(border);
        setSize(600,300);
        setVisible(true);
        
        btn1=new JButton("打开");
        btn2=new JButton("保存");
        tarea=new TextArea("");
        
        container = getContentPane();
        buttonborder = new BorderLayout(20,20);
        container.setLayout(buttonborder);
        jp = new JPanel();
        jp.add(btn1,BorderLayout.EAST);
        jp.add(btn2,BorderLayout.WEST);
        container.add(jp,BorderLayout.SOUTH);
        container.add(tarea,BorderLayout.NORTH);
        btn1.setBounds(520,60,50,30);
        btn2.setBounds(520,120,50,30);
        tarea.setBounds(30,50,460,220);
        
        op=new FileDialog(this,"打开",FileDialog.LOAD);
        sv=new FileDialog(this,"保存",FileDialog.SAVE);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getSource() == btn1) {
            String str;
            op.setVisible(true);
            try {
            	File file=new File(op.getDirectory(),op.getFile());
                FileReader fr=new FileReader(file);
                BufferedReader br=new BufferedReader(fr);
                tarea.setText("");
                while((str=br.readLine())!=null)tarea.append(str+'\n');
                fr.close();
            } catch(Exception e1) {}
        }
        if(e.getSource()==btn2) {
            sv.setVisible(true);
            try {
                File file=new File(sv.getDirectory(),sv.getFile());
                FileWriter fw=new FileWriter(file);
                BufferedWriter bw=new BufferedWriter(fw);
                String gt=tarea.getText();
                bw.write(gt,0,gt.length());
                bw.flush();
                fw.close();
            } catch (Exception e2) {}
        }
	}
	
	public static void main(String[] args) {
		TextIO textio = new TextIO();
		textio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
