package p3;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import dao.DAO;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		DAO dao=new DAO();
		boolean flag=dao.doRegister(email, password, phone, address);
		if(flag)
		{
			response.sendRedirect("login.html");
		}else {
			response.sendRedirect("index.html?msg=registration failed...");
		}
	}
	

}