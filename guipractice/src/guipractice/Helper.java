package guipractice; 
import java.util.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Helper {
	static String fileOpen(Note note)
	{
		if(note.modified==true)
		{
			fileSave(note);
		}
		File file=null;
		String fileName=null;
		String data = null;
		StringBuilder sb=new StringBuilder();
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showOpenDialog(note);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
		file = fc.getSelectedFile();
		fileName=file.getAbsolutePath();
		note.setTitle(file.getName());
		char[] chars = new char[(int) file.length()];
		try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			br.read(chars);
			//System.out.print(sb);
			data=new String(chars);
			br.close();
			note.modified=false;
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		note.txt.setText(data);
		return fileName;
	}
	
	static void fileSave(Note note)
	{
		File file=null;
		String data = null;
		StringBuilder sb=new StringBuilder();
		JFileChooser fc = new JFileChooser();
		int returnVal = fc.showSaveDialog(note);
		if (returnVal == JFileChooser.APPROVE_OPTION) 
		{
			try 
			{
				file = new File(fc.getSelectedFile()+".txt");
				BufferedWriter wr=new BufferedWriter(new FileWriter(file));
				wr.write(note.txt.getText());
				wr.close();
				note.modified=false;
			} 
			catch (Exception e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	static void Save(Note note)
	{
		if(note.presentFile==null)
		{
			fileSave(note);
		return;	
		}
		File file=new File(note.presentFile);
		String data = note.txt.getText();
		 if(file!=null)
		 {
			 BufferedWriter wr;
			try 
			{
				wr = new BufferedWriter(new FileWriter(file));
				wr.write(data);
				wr.close();
				note.modified=false;
			 } 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
	}
	static void about()
	{
		String[] options = new String[] {"OK"};
	    JOptionPane.showOptionDialog(null, "The java based notepad application was developed using Java Swings.\nIn order to learn Java GUI. Developed by- \nSushen Kumar Manchukanti, \nGrad student, University of Texas at Dallas.  ", "About",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
	        null, options, options[0]);
	}
	static void font()
	{
		class Dlg extends JDialog {
		    public Dlg(JFrame frame, String str) {
		        super(frame, str);
		        addWindowListener(new WindowAdapter() {
		            public void windowClosing(WindowEvent evt) {
		                System.exit(0);
		            }
		        });
		    }
		}
		Dlg frame = new Dlg(new JFrame(),"Font");
		JPanel panel = new JPanel();
        panel.setSize(200, 200);

	}
	static void newTxt(Note note)
	{
		if(note.modified==true)
		{
			fileSave(note);
		}
		note.presentFile=null;
		note.setTitle("Untitled");
		note.txt.setText("");
		note.modified=false;
	}
	
}
