package servlets;

import connector.ConnectorDB;
import domain.Flags;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AddApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("firstName");
		String surname = request.getParameter("secondName");
		System.out.println(name + " " + surname);
		
		
		
		//response.setContentType("text/html");
		//response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter printWriter = response.getWriter();
		printWriter.println("<h3>Уважаемый " + name + " " + surname + "!" + " Ваша заявка пока что ни..уя не будет рассмотрена, т.к. это тестовый текст!:)"+"</h3>");
		printWriter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); //кодировка параметров
		
		//инициализируем переменные, переданные со страницы добавления обращений для дальнейшей записи в БД
		String name = request.getParameter("firstName");
		String surname = request.getParameter("secondName");
		String department = request.getParameter("department");
		String id_number = request.getParameter("id_number");
		String pc_number = request.getParameter("pc_number");
		String text = request.getParameter("text");
		
		
		
		
		//response.setContentType("text/html");
		//response.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		
		if(!name.isEmpty() && name!=null && 
		   !surname.isEmpty() && surname!=null && 
		   !department.isEmpty() && department!=null && 
		   !id_number.isEmpty() && id_number!=null && 
		   !pc_number.isEmpty() && pc_number!=null && 
		   !text.isEmpty() && text!=null) 
		{
			//Запрос на добавление в БД заполненных данных
			String query = "INSERT INTO apps (firstName, secondName, department, id_number, pc_number, text, startTime, flag) "
				+ "VALUES ('"+ name + "','"+ surname+ "', '"+ department+"','"+id_number+"','"+pc_number+"','"+ text+"', NOW()"+",'" + Flags.Новое.toString()+"')";
			//Соединение и объект для работы с БД
			Connection connection = null;;
			Statement statement = null;
			try {
				connection = ConnectorDB.getConnection();
				statement = connection.createStatement();
				// Добавляет в БД данные посредством SQL запроса "query"
				statement.executeUpdate(query);
				
			} catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
			} finally {
				//Закрываем соединение и объект работы с БД
				try { connection.close(); } catch(SQLException se) {}
				try { statement.close(); } catch(SQLException se) { /*can't do anything */ }
		    }
            
	    }
		//Перенаправляем на AddResult.jsp после удачной записи в БД
		getServletContext().getRequestDispatcher("/AddResult.jsp").forward(request, response);
	}
}
