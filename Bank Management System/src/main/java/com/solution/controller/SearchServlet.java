package com.solution.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solution.Employee.Employee;

@WebServlet(urlPatterns="/search" , loadOnStartup=10)
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   static{
	   System.out.println("SerachServlet File is loading!!");
   }
    public SearchServlet() {
        super();
        System.out.println("SerachServlet File is Instantiated!!");

    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Serial_no1 = request.getParameter("Serial_no");
		   
		   Integer Serial_no = Integer.parseInt(Serial_no1);
		   IController contr = new ControllerImpl();
			  Employee emp = contr.select(Serial_no);
		  
		  PrintWriter out = response.getWriter();
		  out.println("<html><head><title>Result</title></head><body>");
		  out.println("<center>");
		  out.println("<h1>Customer Account Data</h1>");
		  out.println("<table border='1'>");
		  
		  out.println("<tr> <th>Serial_no</th>  <td>"+emp.getSerial_no()+"</td> </tr>");
		  out.println("<tr> <th>Name</th>  <td>"+emp.getName()+"</td> </tr>");
		  out.println("<tr> <th>Account_no</th>  <td>"+emp.getAccount_no()+"</td> </tr>");
		  out.println("<tr> <th>IFSC_no</th>  <td>"+emp.getIFSC_no()+"</td> </tr>");
		  out.println("<tr> <th>Balance</th>  <td>"+emp.getBalance()+"</td> </tr>");

		  out.println("</table>");
		  out.println("</br><button> <a href='index.html'> home page</a></button> ");

		  out.println("</center></body></html>");
		  
		   
	}

}
