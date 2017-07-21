<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Результат обработки обращения</title>
</head>
<body>
	<h1>
           <% 
        String name = request.getParameter("firstName");
   		String surname = request.getParameter("secondName");
   		String department = request.getParameter("department");
   		String id_number = request.getParameter("id_number");
   		String pc_number = request.getParameter("pc_number");
   		String text = request.getParameter("text");
   		if(!name.isEmpty() && name!=null && 
   			   !surname.isEmpty() && surname!=null && 
   			   !department.isEmpty() && department!=null && 
   			   !id_number.isEmpty() && id_number!=null && 
   			   !pc_number.isEmpty() && pc_number!=null && 
   			   !text.isEmpty() && text!=null) 
   			{
            %>
            Ваше обращение отправлено!<br>
        		<br><%=name%><br>
       			<%=surname%><br>
       			<%=department%><br>
       			<%=id_number%><br>
       			<%=pc_number%><br>
       			<%=text%>         
       		
       		<% } else { %>
       		Заполните все поля!
       		<% } %>
            
            
   </h1>
</body>
</html>