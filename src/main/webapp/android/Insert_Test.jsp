<%@page import="com.db.Mysql_Connection"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Mysql_Connection connectDB = Mysql_Connection.getInstance();

   String OrderNo = request.getParameter("OrderNo"); //여기 파라미터에서 받는 "id"값과, 안드로이드스튜디오에서 "&id" 문자열이 같아야한다.
   String Status = request.getParameter("Status");
   String Store = request.getParameter("Store");
   String Type_of_food = request.getParameter("Type_of_food");
   String Menu = request.getParameter("Menu");
   String Amount = request.getParameter("Amount");
   String Date = request.getParameter("Date");
   String FormatedTime = request.getParameter("FormatedTime");
   String Day = request.getParameter("Day");
   String Member_Key = request.getParameter("Member_Key");
		   

   String Insert_test = connectDB.Insert_Test(OrderNo,Status,Store,Type_of_food,Menu
		   ,Amount,Date,FormatedTime,Day,Member_Key);
   
   System.out.println(Insert_test);
   System.out.println(Day);
   // 안드로이드로 전송
   //jsp 파일에 출력하는 구문이 out.println() 이기때문에 안드로이드에서 jsp와 구동 후 읽어옴.
   out.println(Insert_test);
   %>

   
   .
   