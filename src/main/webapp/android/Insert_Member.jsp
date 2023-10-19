<%@page import="com.db.Mysql_Connection"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Mysql_Connection connectDB = Mysql_Connection.getInstance();

   String Member_Key = request.getParameter("Member_Key"); //여기 파라미터에서 받는 "id"값과, 안드로이드스튜디오에서 "&id" 문자열이 같아야한다.
   String Id = request.getParameter("Id");
   String Pw = request.getParameter("Pw");
   String Name = request.getParameter("Name");
   String Age = request.getParameter("Age");
   String Sex = request.getParameter("Sex");
   String Resisdence = request.getParameter("Resisdence");
   String Address = request.getParameter("Address");
		   

   String Insert_Member = connectDB.Insert_Member(Member_Key,Id,Pw,Name,Age,Sex,Resisdence,Address);
   
   System.out.println(Insert_Member);
   // 안드로이드로 전송
   //jsp 파일에 출력하는 구문이 out.println() 이기때문에 안드로이드에서 jsp와 구동 후 읽어옴.
   out.println(Insert_Member);
   %>
