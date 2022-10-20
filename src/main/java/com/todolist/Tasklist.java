package com.todolist;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tasklist extends HttpServlet {
		
		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
			
			PrintWriter pw=response.getWriter();
			
			
			
			List<GetSet> tasklist=JdbcOperations.status();
			
			
			pw.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Insert title here</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"ISO-8859-1\">\r\n"
					+ "<title>ToDoListApp</title>\r\n"
					+ "<link\r\n"
					+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\"\r\n"
					+ "	rel=\"stylesheet\"\r\n"
					+ "	integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\"\r\n"
					+ "	crossorigin=\"anonymous\">\r\n"
					+ "<script\r\n"
					+ "	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\r\n"
					+ "	integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"\r\n"
					+ "	crossorigin=\"anonymous\"></script>\r\n"
					+ "\r\n"
					+ "</head>\r\n"
					+ "<body \">\r\n"
					+ "	<nav class=\"navbar navbar-expand-lg navbar-light bg-dark\">\r\n"
					+ "		<div class=\"container\">\r\n"
					+ "			<a class=\"navbar-brand\" href=\"index.html\"><h3><b style=\"color: white;\">ToDoListApp</h3></b></a>\r\n"
					+ "			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n"
					+ "				data-target=\"#navbarTogglerDemo02\"\r\n"
					+ "				aria-controls=\"navbarTogglerDemo02\" aria-expanded=\"false\"\r\n"
					+ "				aria-label=\"Toggle navigation\">\r\n"
					+ "				<span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "			</button>\r\n"
					+ "		</div>\r\n"
					+ "					<h5><a class=\"nav-link\" href=\"status\" style=\"color: white; float: right;\">TaskStatus</a></h5>\r\n"
					+ "		\r\n"
					+ "	</nav><br><br>\r\n"
					+ "<p class=\"text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4\">Task List </p>"
					+"<div class=\"container\">\r\n"
					+"<table  border='1' class=\"table table-dark \">\r\n"
					+ " <thead class=\"thread-dark\">\r\n"
					+ "<tr>"
					+ "<th>Task No</th>"
					+ "<th> Task</th>"
					+ "<th> Due Date</th>"
					+ "<th> Status</th>"

					+ "<th>Edit </th>"
					+ "<th>Delete </th>"
					+ "</tr>");
			for(GetSet gs:tasklist){
				pw.print("<tr>"
						+ "<td>"+gs.getId()+"</td>"
					    + "<td>"+gs.getTask()+"</td>"
					    + "<td>"+gs.getDuedate()+"</td>"
					    + "<td>"+gs.getStatus()+"</td>"
					    + "<td><button class=\"btn btn-primary\"><a href='updateForm?id="+gs.getId()+"'><h6  style=\"color:white\">Edit</h6></a></button></td>"
					    + "<td><button class=\"btn btn-danger\"><a href='deleteData?id="+gs.getId()+"'><h6 style=\"color:white\">Delete</h6></button></a></td>"
					    + "</tr>");
			}
			
			
			
					pw.print("+ \"</table>\"\r\n"
							+"</div>\r\n"
							+ "</body>\r\n"
							+ "</html>");
							
							
			
			}

	}
