package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "Session Experied");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}
		
		else
		{
			String pcode = req.getParameter("pCode");
			ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("ProductList");
		 	ProductBean pb=null;
		 	Iterator<ProductBean> i=al.iterator();
		 	while(i.hasNext())
		 	{
		 		pb=i.next();
		 		if(pcode.equals(pb.getpCode()))
		 		{
		 			break;
		 		}
		 	}
		 	pb.setpPrice(req.getParameter("pPrice"));
		 	pb.setpQuantity(req.getParameter("pQty"));
		 	
		 	int rowCount=new UpdateProductDAO().updateProduct(pb);
		 	if(rowCount>0)
		 	{
		 		req.setAttribute("msg", "Product Details Updated!!!");
		 		RequestDispatcher rd=req.getRequestDispatcher("UpdateProduct.jsp");
		 		rd.forward(req, res);
		 	}
		}
	}
}
