package com.pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		
	HttpSession session=req.getSession(false);
	if(session==null)
	{
		req.setAttribute("msg", "session required");
		RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
		rd.forward(req, res);
	}
	else
	{
		req.getRequestDispatcher("Logout.jsp").forward(req, res);
	}
		
	
	}

}
