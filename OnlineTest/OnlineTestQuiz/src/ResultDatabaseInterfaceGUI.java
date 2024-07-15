

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.Vector;
import java.sql.*; 
import java.awt.*;

class ResultDatabaseInterfaceGUI extends JFrame implements Runnable
{
	JTable sheet;
	Thread t;
	//Vector<String> row;
	Vector<Vector<String>> row;
	Vector<String> col;
	Vector<String> roedata;
	
	public DefaultTableModel model1;

	ResultDatabaseInterfaceGUI()
	{
		try
		{
			//row=new Vector<String>();
			row=new Vector<>();

			col=new Vector<String>();
			col.add("Id");
			col.add("Name");
			col.add("Mark");
			col.add("Subject");

			setVisible(true);
			setLocation(350,250);
			setSize(300,300);
			setResizable(false);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			t=new Thread(this);
			t.start();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
	}
	public void run()
	{
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			Connection con=DriverManager.getConnection("jdbc:odbc:result_db");
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
//			String url = "jdbc:ucanaccess://C:/Users/COMnet/eclipse-workspace/Project_2_AptiTest/src/Database2.accdb";
			String url = "jdbc:ucanaccess://D://JavaWorkspace//AptiTest/Database2.accdb";
			Connection con = DriverManager.getConnection(url);
			String sql=new String("select * from result_sheet");
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			String id,nm,mrk,sub;

			
			/*while(rs.next())
			{
				
				
			}*/
			
			 while (rs.next())
			 {
				Vector<String> rowData = new Vector<>();
				rowData.add(rs.getString("Id"));
				rowData.add(rs.getString("Name"));
				rowData.add(rs.getString("Mark"));
				rowData.add(rs.getString("Subject"));
				row.add(rowData); // Add each row of data to the main row Vector
			}

			//model1 = new DefaultTableModel(row,col)
			sheet=new JTable(row,col);
			JScrollPane scrollPane = new JScrollPane(sheet); // Add table to scroll pane
            add(scrollPane, BorderLayout.CENTER);
			//add(sheet,BorderLayout.CENTER);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
		
	}
	public static void main(String []args)
	{
		new ResultDatabaseInterfaceGUI();
	}
}
