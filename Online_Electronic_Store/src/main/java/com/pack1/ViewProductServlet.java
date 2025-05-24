package com.pack1;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/View1")
public class ViewProductServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		HttpSession session=req.getSession();
		if(session==null)
		{
			req.setAttribute("msg", "Session Experied!!");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al=new ViewProductDAO().reteriveProduct();
			session.setAttribute("ProductList", al);
			RequestDispatcher rd=req.getRequestDispatcher("ViewProduct.jsp");
			rd.forward(req, res);
		}
	}

}
