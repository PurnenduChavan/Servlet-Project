package com.todolist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class UpdateServlet extends HttpServlet{

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter out=response.getWriter();
		
		String Id=request.getParameter("Tid");
		int iD=Integer.parseInt(Id);

		
		String taskname=request.getParameter("Ttask");
		
		String DueDate=request.getParameter("Tduedate");


		
		String Status=request.getParameter("Tstatus");
		GetSet st=new GetSet();
		
		st.setId(iD);
		st.setTask(taskname);
		st.setDuedate(DueDate);
		st.setStatus(Status);
	
		
		int r=JdbcOperations.update(st);
		
		if(r>0){
			
			response.sendRedirect("status");
		}
		else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}
}
