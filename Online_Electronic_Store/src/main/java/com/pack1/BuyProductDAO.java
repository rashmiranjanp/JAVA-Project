package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BuyProductDAO 
{
	ArrayList<ProductBean> al=new ArrayList<ProductBean>();
   public ArrayList<ProductBean> retriveitemdetails(ProductBean pbean)
   {
   	
   	try 
   	{
			Connection con=DBConnect.getCon();
			PreparedStatement pstmt=con.prepareStatement("select * from product where pcode=?");
			pstmt.setString(1,pbean.getpCode());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
			    ProductBean pbean1 = new ProductBean();
			    pbean1.setpCode(rs.getString("pcode"));       // or rs.getString(1) if you prefer column index
			    pbean1.setpName(rs.getString("pname"));
			    pbean1.setpCompany(rs.getString("pcompany"));
			    pbean1.setpPrice(rs.getString("pprice"));     // assuming price is numeric
			    pbean1.setpQuantity(rs.getString("pquantity"));  // assuming quantity is integer
			    al.add(pbean1);
			}
		} 
   	catch (Exception e) 
   	{
   		e.printStackTrace();
			// TODO: handle exception
		}
   	return al;
   	
   }
}
