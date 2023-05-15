package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

public class UserDao {
	
	String driver="com.mysql.jdbc.Driver";
	String dbName="batch12";
	String url="jdbc:mysql://localhost:3306/"+dbName;
	String dbuname="root";
	String dbpass="abc123";
	String tblname="user_tbl";
	
	
	
	Connection getConnect() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		return DriverManager.getConnection(url,dbuname,dbpass);
	}


	public int save(User u) throws ClassNotFoundException, SQLException {

		String sql="insert into user_tbl (uname, upass, uemail) values(?,?,?)";
        Connection con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, u.getUname());
		ps.setString(2, u.getUpass());
		ps.setString(3, u.getUemail());
		int a= ps.executeUpdate();
		con.close();
		return a;
	}
	
	public boolean checkUser(String email) throws ClassNotFoundException, SQLException {

		String sql="select * from user_tbl where uemail=?";
        Connection con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email);
		
		ResultSet  rs= ps.executeQuery();
		
		if(rs.absolute(1))
		return true;
		
		con.close();
		
		return false;
		
	}
	
	public ArrayList<User> getAllUser() throws ClassNotFoundException, SQLException {

		String sql="select * from user_tbl";
        Connection con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);

		ResultSet  rs= ps.executeQuery();
		
		ArrayList<User> ul=new ArrayList<>();
		
		while(rs.next())
		{
			User u =new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			ul.add(u);
		}
		
		con.close();
		
		return ul;
		
	}

	
	public ArrayList<User> getUserByPage(int start,int total) throws ClassNotFoundException, SQLException {

		start-=1;
		String sql="select * from user_tbl limit "+start+","+total+"";
        Connection con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);

		ResultSet  rs= ps.executeQuery();
		
		ArrayList<User> ul=new ArrayList<>();
		
		while(rs.next())
		{
			User u =new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			ul.add(u);
		}
		
		con.close();
		
		return ul;
		
	}

	public int deleteUser(int uid) throws ClassNotFoundException, SQLException  {

		String sql="DELETE FROM user_tbl WHERE uid=?";
        Connection con=getConnect();
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,uid);

		int a= ps.executeUpdate();
		con.close();
		return a;
		
	}
	
	
	

}
