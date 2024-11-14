package com.solution.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.solution.Employee.Employee;

@WebServlet(urlPatterns="/delete",loadOnStartup=10)
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("InsertServlet File is loading");
	}
    public DeleteServlet() {
        super();
        System.out.println("UpdateServlet is Instantiated");

    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String Serial_no1 = request.getParameter("Serial_no");
		   
		   Integer Serial_no = Integer.parseInt(Serial_no1);
		   
		   IController contr = new ControllerImpl();
		  Employee emp = contr.select(Serial_no);
		  
		  PrintWriter out = response.getWriter();
		  out.println("<html><head><title>Result</title></head><body>");
		  out.println("<center>");
		  out.println("<h1>Employee Data</h1>");
		  out.println("<table border='1'>");
		  out.println("<tr> <th>Serial_no</th>  <td>"+emp.getSerial_no()+"</td> </tr>");
		  out.println("<tr> <th>Name</th>  <td>"+emp.getName()+"</td> </tr>");
		  out.println("<tr> <th>Account_no</th>  <td>"+emp.getAccount_no()+"</td> </tr>");
		  out.println("<tr> <th>IFSC_no</th>  <td>"+emp.getIFSC_no()+"</td> </tr>");
		  out.println("<tr> <th>Balance</th>  <td>"+emp.getBalance()+"</td> </tr>");

		  out.println("</table>");
		  out.println("</br>");
		  out.println("<h2>Do you want to delete this data?</h2>");
		  out.println("<button><a href='delete?Serial_no="+Serial_no+"'>yes</button>");
		  out.println("<button><a href= index.html> no</a></button> ");
		

		  out.println("</center></body></html>");
		  
		
		   
		   
		   
		 
		 
		   
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Integer rowCount = null;
		PrintWriter out = response.getWriter();

		String Serial_no1 = request.getParameter("Serial_no");
		   
		   Integer Serial_no = Integer.parseInt(Serial_no1);
		   
		   IController contr = new ControllerImpl();
		   
		   
		 rowCount = contr.delete(Serial_no);
		 
		 if(rowCount != 0) {
			 
			 out.println("<h1>Data deleted Successfully!</h1>");
		 }
		 
		 else{
			out.println("<h1>Deletion failed</h1>");
		 }
	}

}
