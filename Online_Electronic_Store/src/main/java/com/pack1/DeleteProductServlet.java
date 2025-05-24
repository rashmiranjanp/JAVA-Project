package com.pack1;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		
		HttpSession session=req.getSession(false);
		if(session==null)
		{
			req.setAttribute("msg", "Session Exepried");
			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.html");
			rd.forward(req, res);
		}
		else
		{
			String code=req.getParameter("pcode");
			int rowCount=new DeleteProductDAO().deleteProduct(code);
			if(rowCount>0)
			{
			req.setAttribute("msg", "Session Exepried");
			RequestDispatcher rd=req.getRequestDispatcher("DeleteProduct.jsp");
			rd.forward(req, res);
		    }
		   else
		   {
			throw new ServletException("Data NOT deleted");
		   }
	   }
	}
}


