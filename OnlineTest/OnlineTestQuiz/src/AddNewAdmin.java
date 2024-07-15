import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddNewAdmin extends JFrame implements ActionListener {

	JPanel tpan,bpan;

	JLabel lunm;
	JTextField tunm;

	JLabel lpas;
	JPasswordField tpas;

	JButton ok;

	String unm;
	String pas;
	int id;
	
	static Connection con;
	static String sql;
	static PreparedStatement ps;
	static String table;
	
	
	static
	{

		try 
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://D://JavaWorkspace//AptiTest/NewAdminData.accdb";
			con = DriverManager.getConnection(url);
			System.out.print("Question store connection eastablished  ");
			sql=new String();
			table = "newadmin_db";
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public AddNewAdmin(String string) {
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		unm = tunm.getText().trim();
		pas = tpas.getText().trim();
		
		try {
			storeAdmin(unm, pas);
		} catch (SQLException e1) {
			
			System.out.println("---"+e1.getMessage());
			e1.printStackTrace();
			
		}
		
		System.out.println("New admin created with UserName: "+unm+" Password: "+pas);
	}

	private void storeAdmin(String unm2, String pas2) throws SQLException {
		
		sql = "insert into "+table+" values(?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1,""+id);
		ps.setString(2,unm2.trim());
		ps.setString(3,pas2.trim());
		ps.executeUpdate();
		ps.close();
		
		System.out.println("New admin data stored successfully.");
	}

}
