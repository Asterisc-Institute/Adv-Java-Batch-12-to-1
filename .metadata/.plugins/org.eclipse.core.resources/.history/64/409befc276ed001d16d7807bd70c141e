package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
	
	
	
	
	
	

}
