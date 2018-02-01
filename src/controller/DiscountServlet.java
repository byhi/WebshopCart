package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.MNBClient;
import model.ActualDiscount;
import model.Count;
import model.Discount;
import model.PayTwoGetThree;
import model.ProductInMegapack;

/**
 * Servlet implementation class DiscountServlet
 */
@WebServlet("/DiscountServlet")
public class DiscountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiscountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  int id0 = Integer.parseInt( request.getParameter("pro0"));
		  int id1 = Integer.parseInt( request.getParameter("pro1"));
		  int id2 = Integer.parseInt( request.getParameter("pro2"));
		  int id3 = Integer.parseInt( request.getParameter("pro3"));
		  List<ProductInMegapack> list = new ArrayList<ProductInMegapack>();
		  list.add(new ProductInMegapack("Télicsizma", 2000,id0,false));
		  list.add(new ProductInMegapack("Gumikacsa", 3000,id1,false));
		  list.add(new ProductInMegapack("Uborka", 2800,id2,true));
		  list.add(new ProductInMegapack("Gesztenye", 1000,id3,true));

		  String discountName = null; 
		 
		  if(list.size()!=0) {
			  
		  String currText = "(HUF/EUR)";
		  Discount disc = new ActualDiscount(list).actual();
		  MNBClient mnb = new MNBClient();
		  Double curr =  mnb.getValueByCurrencyType("EUR");
		  NumberFormat formatter = new DecimalFormat("#0.00"); 
		  
		  if (id0 == 0 && id1 == 0 && id2 == 0 && id3 == 0 ) {
			  discountName =  "<div class=\"alert alert-danger\" role=\"alert\"><strong>Figyelem!</strong> Nem adott meg mennyiséget.</div>";
		} else {
			String discText = "";
			String discText2 = "";
			
			if ((int)disc.getDiscountCost() != (int)Count.getCount(list)) {
				discText = "  <h5>Discount type:</br>"+disc.getDiscountName()+"</h5>\r\n";
			    discText2 = " <h5 style=\"color:red;\">Cost: </br><del>"+
				Count.getCount(list)+" / "+formatter.format((Count.getCount(list)/curr))
				+"</del> "+currText+"</br></h5>\r\n" ;			
			}
			
		  discountName =  " <div class=\"container\">\r\n" +
		  	" <div class=\"jumbotron\">" + 
		  	"      <h1>Összeg</h1>\r\n" +  
		  	discText2 + 
	  		"      <p>Discounted Cost: </br>"+ disc.getDiscountCost() +" / "+formatter.format((disc.getDiscountCost()/curr))+" "+currText+"</p>\r\n" + 
	  		discText+  
	  		"    </div>\r\n" + 
	  		"   </div>";
		  }

			}
			  
		     
		  request.setAttribute("pro0",  request.getParameter("pro0")  ); 
		  request.setAttribute("pro1",  request.getParameter("pro1")  ); 
		  request.setAttribute("pro2",  request.getParameter("pro2")  ); 
		  request.setAttribute("pro3",  request.getParameter("pro3")  ); 
		  request.setAttribute("discount", discountName  ); 
		  request.getRequestDispatcher("/Cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
