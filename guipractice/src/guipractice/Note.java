package guipractice;

import java.util.*;

import javax.swing.event.*;
import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Note extends JFrame {

	boolean modified=false;
	public String presentFile=null;
	public StringBuilder data;
	public StringBuilder tempData;
	public String fileName; 
	public JPanel contentPane;
	public JMenuItem mntmOpen;
	public JMenu mnFile;
	public JTextArea txt;
	/**
	 * Launch the application.
	 */
	public void initialize() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Note frame = new Note("Notepad");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Note(String s) {
		this.setTitle(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setBounds(100, 100, 588, 376);
		txt = new JTextArea();
		txt.setColumns(20);
        txt.setLineWrap(true);
        txt.setRows(5);
        txt.setWrapStyleWord(true);
        txt.setFont(new Font("serif",Font.PLAIN,18));
        txt.getDocument().addDocumentListener(new MyDocumentListener());
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.add(txt);
		getContentPane().add(scrollPane);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.newTxt(Note.this);
			}
		});
		mnFile.add(mntmNew);
		
		mntmOpen = new JMenuItem("Open");
		mntmOpen.setMnemonic(KeyEvent.VK_O);
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				presentFile=Helper.fileOpen(Note.this);
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save as");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.fileSave(Note.this);	
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmSave_1 = new JMenuItem("Save");
		mntmSave_1.setMnemonic(KeyEvent.VK_S);
		mntmSave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.Save(Note.this);
			}
		});
		mnFile.add(mntmSave_1);
		
		JMenu mnEdit = new JMenu("edit");
		mnEdit.setMnemonic(KeyEvent.VK_E);
		menuBar.add(mnEdit);
		
		JMenuItem mntmFind = new JMenuItem("Find");
		mnEdit.add(mntmFind);
		
		JMenuItem  mntmCut = new JMenuItem(new DefaultEditorKit.CutAction());
		mntmCut.setText("Cut");
		mntmCut.setMnemonic(KeyEvent.VK_X);
		mnEdit.add(mntmCut);
		
		JMenuItem  mntmCopy = new JMenuItem(new DefaultEditorKit.CopyAction());
		mntmCopy.setText("Copy");
		mntmCopy.setMnemonic(KeyEvent.VK_C);
		mnEdit.add(mntmCopy);
		
		JMenuItem  mntmPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
		mntmPaste.setText("Paste");
		mntmPaste.setMnemonic(KeyEvent.VK_P);
		mnEdit.add(mntmPaste);
		
		JMenuItem mntmSelectAll = new JMenuItem("Select All");
		mntmSelectAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Note.this.txt.selectAll();
			}
		});
		mntmSelectAll.setMnemonic(KeyEvent.VK_A);
		mnEdit.add(mntmSelectAll);
		
		JMenu mnView = new JMenu("View");
		menuBar.add(mnView);
		
		JMenuItem mntmFont = new JMenuItem("Font");
		mntmFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dlg dlg=new Dlg("Font",Note.this);
				dlg.initiate();
			}
		});
		mnView.add(mntmFont);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Helper.about();
			}
		});
		mnHelp.add(mntmAbout);
	   }
	class MyDocumentListener implements DocumentListener {
        final String newline = "\n";
 
        public void insertUpdate(DocumentEvent e) {
            Note.this.modified=true;
        }
        public void removeUpdate(DocumentEvent e) {
        	Note.this.modified=true;
        }
        public void changedUpdate(DocumentEvent e) {
        	Note.this.modified=true;
        }
	}
}
