package Add;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteTask")
public class deleteTask extends HttpServlet {
	
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException {
		
		int id =  Integer.parseInt(request.getParameter("taskId")); 
		
		response.getWriter().print("id: "+ id);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo" , "Manjeet" ,"HAha1100@");
			Statement statement = connection.createStatement();
			String queryString ="delete from tasktable where id ="+id;
			
		    statement.executeUpdate(queryString);
		    statement.close();
		    connection.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		response.sendRedirect("index.jsp");
		
		
		
	}

}
