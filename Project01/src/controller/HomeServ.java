package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

@WebServlet("/home")
public class HomeServ extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int pageID=Integer.parseInt(request.getParameter("page"));
		
		int start=pageID;
		out.print("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>");
		out.print("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js'></script>");
		out.print("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js'></script>");
		
		int total=5;
		if(start==1){}
		else
		{
			start-=1;
			start=start*total+1;
		}
		
		
		
		UserDao db = new UserDao();
		
		try {
			//ArrayList<User> ul=db.getAllUser();
			ArrayList<User> ul=db.getUserByPage(start, total);
			
			
			out.print("<table class='table'>");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th>U ID</th>");
			out.print("<th>User Name</th>");
			out.print("<th>User Pass</th>");
			out.print("<th>Email</th>");
			out.print("<th>Action</th>");
			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");

			
			for(User u:ul)
			{
				out.print("<tr>");
						out.print("<td>"+u.getUid()+"</td>");
						out.print("<td>"+u.getUname()+"</td>");
						out.print("<td>"+u.getUpass()+"</td>");
						out.print("<td>"+u.getUemail()+"</td>");
						out.print("<td><a class='btn btn-primary' href='#'>Update</a> <a class='btn btn-danger' href='delete?id="+u.getUid()+"&pid="+pageID+"'>Delete</a></td>");
		        out.print("</tr>");
			
			}
			
			
			
			out.print("</tbody>");
			out.print("</table>");
			
			
			
			
			out.print("<div class='container'>");
			out.print("<ul class='pagination'>");
			
			out.print("<li ");
			if(pageID==1)
			out.print("class='active'");
			out.print("><a href='home?page=1'>1</a></li>");
			
			out.print("<li ");
			if(pageID==2)
			out.print("class='active'");
			out.print("><a href='home?page=2'>2</a></li>");
			
			out.print("<li ");
			if(pageID==3)
			out.print("class='active'");
			out.print("><a href='home?page=3'>3</a></li>");
			
			out.print("<li ");
			if(pageID==4)
			out.print("class='active'");
			out.print("><a href='home?page=4'>4</a></li>");
			
			
			out.print("</ul></div>");
		

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
