import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainAdminLoginFrame extends JFrame implements ActionListener {

	JPanel tpan,bpan;

	JLabel lunm;
	JTextField tunm;

	JLabel lpas;
	JPasswordField tpas;

	JButton ok;


	String unm="Pallavi";
	String pas="admin";
	
	public MainAdminLoginFrame(String string) {
		
		super(string);

		tpan=new JPanel();
		tpan.setLayout(new GridLayout(2,2,3,3));

		lunm=new JLabel(" User Name ");
		lunm.setFont(new Font("",Font.BOLD,15));
		tunm=new JTextField();
		tunm.setFont(new Font("",Font.BOLD,15));

		lpas=new JLabel(" Password ");
		lpas.setFont(new Font("",Font.BOLD,15));
		tpas=new JPasswordField();
		tpas.setFont(new Font("",Font.BOLD,15));

		tpan.add(lunm);tpan.add(tunm);
		tpan.add(lpas);tpan.add(tpas);

		bpan=new JPanel();

		ok=new JButton("Okay");
		ok.setFont(new Font("",Font.BOLD,15));
		ok.addActionListener(this);
		bpan.add(ok);
		

		add(tpan,BorderLayout.CENTER);
		add(bpan,BorderLayout.SOUTH);


		setVisible(true);
		setSize(300,150);
		setLocation(350,250);
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
//		if(e.getSource()==ok)
//		{
//			if(unm.equals(tunm.getText().trim()) && pas.equals(tpas.getText().trim()))
//			{
//				setVisible(false);
//				new AdminClass("Admin Class");
//			}
//			else
//			{
//				System.out.println("Invalid username or password");
//			}
//		}
		
		if(unm.equals(tunm.getText().trim()) && pas.equals(tpas.getText().trim()))
		{
			setVisible(false);
//			new SubjectChooser("Choose Subject");
			
			System.out.println("Successfully login");
			new AdminClass("Admin Class");
		}
		else
		{
			System.out.println("Invalid username or password");
		}
		
		
	}

}
