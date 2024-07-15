import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminClass extends JFrame implements ActionListener{
	
	JButton addque;
	JButton addadmin;

	JPanel tpan,bpan;

	JLabel albl;

	JLabel qlbl;

	JButton ok;
	
	public AdminClass(String string) {
		
		super(string);


		tpan=new JPanel();
		tpan.setLayout(new GridLayout(2,2,3,3));

		albl=new JLabel(" Add New Admin");
		albl.setFont(new Font("",Font.BOLD,15));
		addadmin = new JButton("Add");
		addadmin.addActionListener(this);

		qlbl=new JLabel(" Add New Question ");
		qlbl.setFont(new Font("",Font.BOLD,15));
		addque = new JButton("Add");
		addque.addActionListener((ActionListener) this);

		tpan.add(albl);tpan.add(addadmin);
		tpan.add(qlbl);tpan.add(addque);

		add(tpan,BorderLayout.CENTER);

		setVisible(true);
		setSize(300,150);
		setLocation(350,250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==addque)
		{
			new QueFillSubject("Add Question Frame");
		}
		if(e.getSource()==addadmin)
		{
			new AddNewAdmin("New Admin Frame");
		}
	}
	
}
