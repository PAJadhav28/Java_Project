

import java.sql.*;
import javax.swing.*;


public class DatabaseInterface 
{
	Question q;

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	String sql;
	String dns;
	static String table;
	
	public DatabaseInterface()
	{
		try
		{
			q=new Question();

//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url = "jdbc:ucanaccess://D://JavaWorkspace//AptiTest/AptiDatabase2.accdb";
			if(SubjectChooser.getSubject().trim().equals("C Programming"))table="c_apti_db";
			if(SubjectChooser.getSubject().trim().equals("C++ Programming"))table="cpp_apti_db";
			if(SubjectChooser.getSubject().trim().equals("Java Programming"))table="j_apti_db";
			if(SubjectChooser.getSubject().trim().equals("C# Programming"))table="ch_apti_db";
//			con=DriverManager.getConnection("jdbc:odbc:apti_db");
			con = DriverManager.getConnection(url);
			sql=new String();	
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
	}
//	public Question getFullQuestion(int id)
	public Question getFullQuestion(int id)
	{
		try
		{
			System.out.println("table is: "+table);
			sql="select * from "+table+" where id= "+id;
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next())
			{
				q.setID(id);
				q.setQuestion(rs.getString("question").trim());
				q.setOption1(rs.getString("opt1").trim());
				q.setOption2(rs.getString("opt2").trim());
				q.setOption3(rs.getString("opt3").trim());
				q.setOption4(rs.getString("opt4").trim());
				q.setAnswer(rs.getString("answer").trim());
			}
	
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
			e.printStackTrace();
		}
		return q;
	}
	
	//===================
	
	//======================
	public String getAnswer(int id)
	{
		String ans=new String();
		try
		{
			sql="select answer from "+table+" where id="+id;
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			if(rs.next())
			{
				ans=rs.getString("answer");
			}
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null,""+e);
		}
		return ans;
	}
}
