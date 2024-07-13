package p3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


import dao.DAO;


public class LoginCheck extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		DAO dao=new DAO();
		String desig=dao.LoginCheck(email, password);
		if(desig!=null)
		{
			if(desig.equalsIgnoreCase("user"))
			{	response.sendRedirect("UserHome.html");
			}else if(desig.equalsIgnoreCase("admin"))
			{	response.sendRedirect("AdminHome.html");
			}else
			{
				response.sendRedirect("login.html?msg=InvalidDesig");
			}
		}else {
			response.sendRedirect("login.html?msg=InvalidAuthentication");
		}
	}

}
