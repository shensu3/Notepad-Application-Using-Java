package guipractice;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Dlg extends JDialog {

	private JPanel contentPane;
	public Note note;
	public String font;
	public int style;
	public int size;

	/**
	 * Launch the application.
	 */
	public void initiate() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dlg frame = new Dlg("font",Dlg.this.note);
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
		public Dlg(String str,Note note) 
		{
			setBounds(100, 100, 588, 376);
			setTitle(str);
			setResizable(false);
			getContentPane().setLayout(null);
			this.note=note;
			String fonts[]={"serif","sansserif","monospaced"};
			String styles[]={"Font.PLAIN","Font.BOLD","Font.ITALIC","Font.BOLD+Font.ITALIC"};
			String sizes[]={"10","12","15","18","22","25","28","30","33","35","38","40"};
			JComboBox comboBox = new JComboBox(fonts);
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 JComboBox cb = (JComboBox)e.getSource();
				        String font = (String)cb.getSelectedItem();
				}
			});
			comboBox.setBounds(68, 107, 104, 27);
			getContentPane().add(comboBox);
			
			JComboBox comboBox_1 = new JComboBox(styles);
			comboBox_1.setBounds(232, 107, 87, 27);
			comboBox_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 JComboBox cb = (JComboBox)e.getSource();
				        style = cb.getSelectedIndex();
				}
			});
			getContentPane().add(comboBox_1);
			
			JComboBox comboBox_2 = new JComboBox(sizes);
			comboBox_2.setBounds(370, 107, 95, 27);
			comboBox_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 JComboBox cb = (JComboBox)e.getSource();
				        size = Integer.parseInt((String)cb.getSelectedItem());
				}
			});
			getContentPane().add(comboBox_2);
			
			JButton btnSetFont = new JButton("Set Font !");
			btnSetFont.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Dlg.this.note.toBack();
					Dlg.this.note.setVisible(true);
					Dlg.this.note.txt.setFont(new Font(Dlg.this.font,Dlg.this.style,Dlg.this.size));
					Dlg.this.setVisible(false);
				}
			});
			btnSetFont.setBounds(229, 234, 118, 41);
			getContentPane().add(btnSetFont);
			
			JLabel lblFontFamily = DefaultComponentFactory.getInstance().createLabel("Font Family");
			lblFontFamily.setBounds(68, 82, 92, 14);
			getContentPane().add(lblFontFamily);
			
			JLabel lblFontWeight = DefaultComponentFactory.getInstance().createLabel("Font Weight");
			lblFontWeight.setBounds(232, 82, 92, 14);
			getContentPane().add(lblFontWeight);
			
			JLabel lblSize = DefaultComponentFactory.getInstance().createLabel("Size");
			lblSize.setBounds(370, 82, 92, 14);
			getContentPane().add(lblSize);
	    }
}
