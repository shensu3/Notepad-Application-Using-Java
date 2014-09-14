package guipractice;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class addition 
{
	private JFrame mainframe;
	private int a=0;
	private int b=0;
	private Integer sum=0;
	private JTextField text1=new JTextField(JTextField.RIGHT);
	private JTextField text2=new JTextField(JTextField.RIGHT);
	private JTextField text3=new JTextField(JTextField.RIGHT);
	public addition()
	{
		mainframe=new JFrame("Addition stuff :)");
		//mainframe.setLayout(new ());
		//mainframe.setOpacity(60);
		mainframe.setSize(600, 600);
		Container cp= mainframe.getContentPane();
		cp.setBackground(Color.gray);
		JPanel jp=new JPanel();
		JLabel header = new JLabel("Addition plox !",JLabel.CENTER);
		jp.setLayout(new GridLayout(3,2));
		mainframe.add(header);
		mainframe.add(jp);
		mainframe.setVisible(true);
		JLabel num1=new JLabel("Number 1",JLabel.LEFT);
		JLabel num2=new JLabel("Number 2",JLabel.LEFT);
		JButton add=new JButton("ADD");
		add.addActionListener(new addListener());
		jp.add(num1);
		jp.add(text1);
		jp.add(num2);
		jp.add(text2);
		jp.add(add);
		jp.add(text3);
	}
	
	public void sum()
	{
		 a=Integer.parseInt(text1.getText());
		 b=Integer.parseInt(text2.getText());
		 sum=a+b;
		text3.setText(sum.toString());
	}
	
	class addListener implements ActionListener
	{
		 public void actionPerformed(ActionEvent e) {
			sum();
		 }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addition a=new addition();
	}

}


