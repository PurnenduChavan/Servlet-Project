package com.todolist;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			PrintWriter pw=response.getWriter();
			
			String Id=request.getParameter("id");
			int id1=Integer.parseInt(Id);

			
			System.out.println(id1);
			
			int st=JdbcOperations.delete(id1);
			
			
			if(st>0)
			{
				response.sendRedirect("status");
			}
			else
			{
				pw.println("Sorry! unable to delete record");
			}
			
		}



}
