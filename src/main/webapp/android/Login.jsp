<%@page import="com.db.Mysql_Connection"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Mysql_Connection connectDB = Mysql_Connection.getInstance();

   String Id = request.getParameter("Id");
   String Pw = request.getParameter("Pw.");

		   

   String Login = connectDB.Login(Id,Pw);
   
   System.out.println(Login);
   // 안드로이드로 전송
   //jsp 파일에 출력하는 구문이 out.println() 이기때문에 안드로이드에서 jsp와 구동 후 읽어옴.
   out.println(Login);
   
   %>
