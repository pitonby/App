package servlets;

import connector.ConnectorDB;
import domain.Application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Control extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		String query = "SELECT * FROM apps";
		
		//Соединение и объект для работы с БД
		Connection connection = null;;
		Statement statement = null;
		ArrayList<Application> appList = new ArrayList<>();
		try {
			connection = ConnectorDB.getConnection();
			statement = connection.createStatement();
			// Выбирает все записи из БД
			
			ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	Application app = new Application();
            	app.setId(rs.getString(1));
            	app.setFirstName(rs.getString(2));
            	app.setSecondName(rs.getString(3));
            	app.setDepartment(rs.getString(4));
            	app.setId_number(rs.getString(5));
            	app.setPc_number(rs.getString(6));
            	app.setText(rs.getString(7));
			    app.setStartTime(rs.getString(8));
				app.setEndTime(rs.getString(9));
				app.setEnumFlag(rs.getString(10).toString());
            	appList.add(app);
            }
            rs.close();
			
		} catch (SQLException sqlEx) {
        sqlEx.printStackTrace();
		} finally {
			//Закрываем соединение и объект работы с БД
			try { connection.close(); } catch(SQLException se) {}
			try { statement.close(); } catch(SQLException se) { /*can't do anything */ }
	    }
		
		//Перенаправляем на AddResult.jsp после удачной записи в БД
        response.setContentType("text/html;charset=utf-8");
		request.setAttribute("list", appList);
		getServletContext().getRequestDispatcher("/AllApp.jsp").forward(request, response);
	    response.getWriter().append("Список заявок ").append(request.getContextPath());
    }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
