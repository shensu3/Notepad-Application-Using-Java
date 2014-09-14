package guipractice;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Notepad 
{

	private Note note;
	public Notepad() 
	{
		Note note=new Note("Notepad");
		this.note=note;
		note.initialize();
	}
	public void openFile(String s)
	{
		System.out.println("opening :" + s);
	}
	public static void main(String args[])
	{
		Notepad notepad=new Notepad();
	}
	
}
