package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connector.ConnectorDB;


public class End extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public End() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		System.out.println(id);
		response.setContentType("text/html;charset=utf-8");
			

String query1 = "UPDATE apps SET flag='Завершено' WHERE id="+id;
String query2 = "UPDATE apps SET endTime=NOW() WHERE id="+id;
		
        
		
		//Соединение и объект для работы с БД
		Connection connection = null;;
		Statement statement = null;

		try {
			connection = ConnectorDB.getConnection();
			statement = connection.createStatement();
			// Выбирает все записи из БД
			
			statement.executeUpdate(query1);
			statement.executeUpdate(query2);
			
           
            
            
            
			
		} catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
		} finally {
			//Закрываем соединение и объект работы с БД
			try { connection.close(); } catch(SQLException se) {}
			try { statement.close(); } catch(SQLException se) { /*can't do anything */ }
	    }
		
	    
		//Перенаправляем на Edit.jsp после удачной записи в БД
        response.setContentType("text/html;charset=utf-8");
		
		getServletContext().getRequestDispatcher("/admin.html").forward(request, response);
	}

}
