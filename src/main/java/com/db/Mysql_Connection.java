package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class Mysql_Connection {
    private static Mysql_Connection instance = new Mysql_Connection();

    public static Mysql_Connection getInstance() {
        return instance;
    }
    public Mysql_Connection() {  }

    // oracle 계정
    String jdbcUrl = "jdbc:mysql://login-lecture.cxh9jd3ejp84.ap-northeast-2.rds.amazonaws.com:3306/login_lecture?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    String userId = "admin";
    String userPw = "jkr123^^7";

    Connection conn = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt2 = null;
    ResultSet rs = null;
    ResultSet rs2 = null;

    String sql = ".";
    String sql2 = "";
    String sql3 = "";
    String returns = "a";

    public String Insert_Test( String OrderNo, String Status, String Store, String Type_of_food,
    		String Menu, String Amount, String Date, String FormatedTime, String Day, String Member_Key ) {
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            

                sql = "INSERT INTO Order_test VALUES(?,?,?,?,?,?,?,?,?,?)";
                pstmt2 = conn.prepareStatement(sql);
                pstmt2.setString(1, OrderNo);
                pstmt2.setString(2, Status);
                pstmt2.setString(3, Store);
                pstmt2.setString(4, Type_of_food);
                pstmt2.setString(5, Menu); 
                pstmt2.setString(6, Amount);
                pstmt2.setString(7, Date);
                pstmt2.setString(8, FormatedTime);
                pstmt2.setString(9, Day);
                pstmt2.setString(10, Member_Key);
                pstmt2.executeUpdate();
                returns = OrderNo+Status+Amount+FormatedTime+Day+Date+Member_Key;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
        }
        return returns;
    }
    
    public String Insert_Member( String Member_Key, String Id, String Pw, String Name,
    		String Age, String Sex, String Resisdence,  String Address) {
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            

                sql = "INSERT INTO Member VALUES(?,?,?,?,?,?,?,?)";
                pstmt2 = conn.prepareStatement(sql);
                pstmt2.setString(1, Member_Key);
                pstmt2.setString(2, Id);
                pstmt2.setString(3, Pw);
                pstmt2.setString(4, Name);
                pstmt2.setString(5, Age); 
                pstmt2.setString(6, Sex);
                pstmt2.setString(7, Resisdence);
                pstmt2.setString(8, Address);
                pstmt2.executeUpdate();
                returns = Address;
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
        }
        return returns;
    }
    
    
    public String Login(String id, String pwd) { //로그인 구문 // 아이디 비밀번호로 멤버키 찾고, 아이디로 주소까지 찾아오
    	String Address="";
    	String msg="실패2";
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            String member_key;

            sql = "SELECT Pw from Member WHERE Id = ?";
            sql2 = "SELECT Member_Key from Member WHERE Id = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt2 = conn.prepareStatement(sql2);
            pstmt.setString(1, id);
            pstmt2.setString(1, id);

            rs = pstmt.executeQuery();
            if (rs.next()) {
            	System.out.println(rs.getString(1));
            	if( rs.getString(1).equals(pwd)) { // id가 id인 테이블의 pw값 검색하고, 입력한 pw가 맞으면 로그인
            		rs2 = pstmt2.executeQuery();
            		if(rs2.next()) {
                		member_key = rs2.getString(1);
                		sql3 = "SELECT Address from Member WHERE Id = ?";
                		pstmt = conn.prepareStatement(sql3);
                		pstmt.setString(1, id);
                		rs = pstmt.executeQuery();
                		if(rs.next()) {
                			System.out.println(rs.getString(1));
                			Address = rs.getString(1);
                		}
                		
            		}
            		else {
            			member_key = "멤버키가 없습니다. 치명적 오류";
            		}
            		
            		
                msg = "true "+member_key + " " + Address;
                System.out.println(msg);
                }
            else {
            	msg = "false";
            }
        } 
    	}
    		
    		catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
        }
        return msg;
    }
    
    public String Find_Address(String Member_Key) { //로그인 구문
    	String address="";
    	
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            

            sql = "SELECT Address from Member WHERE Member_Key = ?";
            pstmt = conn.prepareStatement(sql);
            System.out.println("멤버키는? : "+Member_Key);
            pstmt.setString(1, Member_Key);
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
            	System.out.println(rs.getString(1));
           
                		address = rs.getString(1);
                		return address;
            		}
            else {
            			address = "주소가 없음";
            		}
                System.out.println(address);
                }

        
    		catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pstmt2 != null)try {pstmt2.close();    } catch (SQLException ex) {}
            if (pstmt != null)try {pstmt.close();} catch (SQLException ex) {}
            if (conn != null)try {conn.close();    } catch (SQLException ex) {    }
        }
    	return address;
    }
    
   
    
    
}

