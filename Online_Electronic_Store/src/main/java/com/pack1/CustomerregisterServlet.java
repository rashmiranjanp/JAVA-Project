package com.pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/creg")
public class CustomerregisterServlet extends HttpServlet
{
	String empty;
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		 
		 CustomerBean cbean=new CustomerBean();
		 cbean.setUname(req.getParameter("uname"));
		 cbean.setPwrd(req.getParameter("pwrd"));
		 cbean.setFname(req.getParameter("fname"));
		 cbean.setLname(req.getParameter("lname"));
		 cbean.setAddr(req.getParameter("addr"));
		 cbean.setMid(req.getParameter("mid"));
		 cbean.setPhno(req.getParameter("phno"));
		  
		
	       if((req.getParameter("uname")).equals("") ||(req.getParameter("pwrd")).equals("") ||(req.getParameter("fname")).equals("") ||(req.getParameter("lname")).equals("") ||(req.getParameter("addr")).equals("") ||(req.getParameter("mid")).equals("") ||(req.getParameter("phno")).equals(""))
	          {
	    	   req.setAttribute("invalidcustomer","invalid customer details");
			 RequestDispatcher rd=req.getRequestDispatcher("Error.jsp");
			 rd.forward(req, res);
		        return;
	         }
		 
		 int rowcount=new CustomerRegisterDAO().insertdata(cbean);
		 if(rowcount>0)
		 {
			
			HttpSession session= req.getSession();
			session.setAttribute("cbean",cbean);
		    RequestDispatcher rd=req.getRequestDispatcher("CustomerRegister.jsp");
			rd.forward(req, res);
		 }
		 
	}

}
