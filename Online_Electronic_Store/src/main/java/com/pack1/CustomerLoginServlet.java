package com.pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/clog")
public class CustomerLoginServlet extends HttpServlet
{
	@Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException
  {
	  CustomerBean cbean=new CustomerLoginDAO().checkcustomerlogin(req.getParameter("uname"),req.getParameter("pwrd"));
	  if(cbean==null)
	  {
		  req.setAttribute("msg","login failed try again");
		  RequestDispatcher rd=req.getRequestDispatcher("InvalidCredentials.jsp");
		  rd.forward(req, res);
	  }
	  else
	  {
		  HttpSession session=req.getSession();
		  session.setAttribute("cbean",cbean);
		  RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.jsp");
		  rd.forward(req, res);
	  }
  }
}
