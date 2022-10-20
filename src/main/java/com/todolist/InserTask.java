package com.todolist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InserTask extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		PrintWriter pw=response.getWriter();
		
		String Id=request.getParameter("Tid");
		int iD=Integer.parseInt(Id);

		
		String taskname=request.getParameter("Ttask");
		
		String DueDate=request.getParameter("Tduedate");


		
		String Status=request.getParameter("Tstatus");
		
		


		GetSet gt=new GetSet();
		
		gt.setId(iD);
		gt.setTask(taskname);;
		gt.setDuedate(DueDate);
		gt.setStatus(Status);
		
		int status=JdbcOperations.insert(gt);
		if(status>0)
		{
			pw.print("<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n"
					+ "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n"
					+ "\r\n"
					+ "</head>"
					+ "<body>"
					+ "<div class=\"card\" >\r\n"
					+ "  <div class=\"card-body bg-warning\">\r\n"
					+ "    <strong>Record Inserted. </strong>\r\n"
					+ "  </div>\r\n"
					+ "</div>"
					+ "</body>"
					+ "</html>");
		}
		else {
			pw.print("<h1>record not inserted</h1>");
		}

		
	}


}
