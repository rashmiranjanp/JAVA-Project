package com.pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/alog")
	public class AdminLoginServlet extends HttpServlet
	{
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
		{
			AdminBean abean=new AdminLoginDAO().checkAdminLogin(req.getParameter("aname"), req.getParameter("apwd"));
			
			if(abean==null)
			{
				req.setAttribute("msg", "Invalid Admin Credentials");
				RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
				rd.forward(req, res);
			}
			else
			{
				HttpSession session=req.getSession();
				session.setAttribute("abean", abean);
				RequestDispatcher rd=req.getRequestDispatcher("AdminHome.jsp");
				rd.forward(req, res);
			}
		}
	}


