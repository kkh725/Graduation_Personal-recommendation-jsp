<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<meta name="viewport" content="width=device-width,initial-scale=1.0"/>

<h2>JDBC드라이버 테스트 </h2>

<%
  Connection conn=null;

  try{
	 String jdbcUrl = "jdbc:mysql://login-lecture.cxh9jd3ejp84.ap-northeast-2.rds.amazonaws.com:3306/login_lecture";
     String dbId = "admin";
     String dbPass = "jkr123^^7";
	
	 Class.forName("com.mysql.jdbc.Driver");
	 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
	 out.println("제대로 연결되었습니다.");
  }catch(Exception e){ 
	 out.println("연결오류");
	 e.printStackTrace();
  }
%>