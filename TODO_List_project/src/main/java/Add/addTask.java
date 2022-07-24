package Add;
import java.sql.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Add_Task")
public class addTask extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String taskString = request.getParameter("newTask");
		if(taskString.length()==0) {
			response.sendRedirect("index.jsp");
			
		}
		else {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/todo" , "Manjeet" ,"HAha1100@");
			String query ="insert into TaskTable(task) values(?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, taskString);
			
			statement.executeUpdate();
			
			statement.close();
			connection.close();
			
			
		}
		
		catch (ClassNotFoundException | SQLException e) {
	
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");
		
		}
		
		
	}


}
