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


@WebServlet("/view2")
public class CustomerViewProductServlet extends HttpServlet
{
	 @Override
     protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
     {
  	    HttpSession session=req.getSession(false);
  	    if(session==null)
  	    {
  	    	req.setAttribute("msg","Session Experied");
  	    	RequestDispatcher rd=req.getRequestDispatcher("CustomerLogin.jsp");
  	    	rd.forward(req, res);
  	    }
  	    else
  	    {
  	    	ArrayList<ProductBean> al=new ArrayList<ProductBean>();
  	    	al=new CustomerViewProductsDAO().retriveproducts();
  	    	session.setAttribute("ProductsList", al);
  	    	RequestDispatcher rd=req.getRequestDispatcher("CustomerViewProduct.jsp");
  	    	rd.forward(req, res);
  	    }
     }
}
