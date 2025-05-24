package com.pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/aps")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession();
		if(session==null)
		{
			req.setAttribute("msg", "Session Experied");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}
		else
		{
			ProductBean pbean=new ProductBean();
			pbean.setpCode(req.getParameter("pcode"));
			pbean.setpName(req.getParameter("pname"));
			pbean.setpCompany(req.getParameter("pcompany"));
			pbean.setpPrice(req.getParameter("pprice"));
			pbean.setpQuantity(req.getParameter("pqty"));
			
			int rowCount=new AddProductDAO().InsertData(pbean);
			if(rowCount>0)
			{
			      req.setAttribute("msg","Product details added Succesfully");
			     RequestDispatcher rd=req.getRequestDispatcher("AddProduct.jsp");
			     rd.forward(req, res);
			}
			 
		}
	}
}
